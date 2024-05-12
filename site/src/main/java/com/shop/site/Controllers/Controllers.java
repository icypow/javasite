package com.shop.site.Controllers;
import com.shop.site.Service.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.shop.site.Entity.*;
import com.shop.site.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


@Controller
public class Controllers {
    CategorySVC categorysvc = new CategorySVC();
    ClientSVC clientsvc = new ClientSVC();
    OrderProductSVC orderproductsvc = new OrderProductSVC();
    OrderSVC ordersvc = new OrderSVC();
    ProductCategorySVC productcategorysvc = new ProductCategorySVC();
    ProductSVC productsvc = new ProductSVC();
    ReviewSVC reviewsvc = new ReviewSVC();


    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }


    @GetMapping("/register")
    public String registerForm(@AuthenticationPrincipal Object user) {
        System.out.println(user);
        return "register";
    }


    @PostMapping("/register")
    public String register(String username , String password, String phone, String fullName, String email, String address) {
        Client cl = new Client();
        cl.setLogin(username);
        cl.setPassword(password);
        cl.setPhone(phone);
        cl.setName(fullName);
        cl.setEmail(email);
        cl.setAddress(address);
        clientsvc.save(cl);
        return "redirect:/login";
    }

    @GetMapping("/search")
    public String search(@AuthenticationPrincipal UserDetails user, @RequestParam(name = "productName", required = false) String productName,
                         @RequestParam(name = "category", required = false) String category,
                         Model model) {
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        if (cart == null){
            cart = new Order(client, 0, 0, null, null);
            ordersvc.save(cart);
        }
        List<Product> searchResults = Collections.emptyList();
        if (productName != null && !productName.isEmpty()) {
            // Поиск по названию товара
            Product product = productsvc.findByName(productName);
            if (product == null) {
                // Если товар не найден, передаем сообщение об отсутствии товара

                model.addAttribute("message", "Товар не найден: " + productName);
            } else {
                // Если товар найден, перенаправляем на страницу товара
                // Вам нужно будет реализовать эту логику позже
                return "redirect:/product?id=" + product.getProductId();
            }
        } else if (category != null && !category.isEmpty()) {
            Category categoryObj = categorysvc.findByName(category);
            if (categoryObj == null){
                model.addAttribute("message", "Такой категории не существует: " + category);
                return "search";
            }
            searchResults = productcategorysvc.GetProducts(categoryObj);
            if (searchResults == null){
                model.addAttribute("message", "В данной категории нет товаров: " + category);
                return "search";
            }
        }

        model.addAttribute("searchResults", searchResults);
        return "search";
    }


    @GetMapping("/product")
    public String getProductDetails(@RequestParam(name = "id") int productId, Model model) {
        // Получаем информацию о товаре по его ID
        Product product = productsvc.findById(productId);
        if (product == null) {
            // Если товар с указанным ID не найден, перенаправляем на страницу поиска
            return "redirect:/search";
        }
        // Если товар найден, передаем его информацию на страницу
        model.addAttribute("product", product);
        return "product";
    }



    @GetMapping("/cart")
    public String viewCart(@AuthenticationPrincipal UserDetails user, Model model) {
        // Получаем список товаров в корзине для данного клиента
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        if (cart == null){
            cart = new Order(client, 0, 0, null, null);
            ordersvc.save(cart);
            cart = clientsvc.getCart(client);
        }
        List<OrderProduct> cartProducts = ordersvc.getOrderProducts(cart);
        List<CartItemDTO> cartItems = new ArrayList<>();
        for (OrderProduct orderProduct : cartProducts) {
            Product product = productsvc.findById(orderProduct.getProduct().getProductId());
            CartItemDTO cartItemDTO = new CartItemDTO(orderProduct, product);
            cartItems.add(cartItemDTO);
        }
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@AuthenticationPrincipal UserDetails user, @RequestParam("productId") int productId, @RequestParam("amount") int amount) {
        Product product = productsvc.findById(productId);
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        if (cart == null){
            cart = new Order(client, 0, 0, null, null);
            ordersvc.save(cart);
            cart = clientsvc.getCart(client);
        }
        OrderProduct op = new OrderProduct(cart, product, amount);
        orderproductsvc.save(op);
        return "redirect:/product?id=" + productId;
    }

    @PostMapping("/cart/updateQuantity")
    public String updateCartItemQuantity(@AuthenticationPrincipal UserDetails user, @RequestParam("productId") int productId, @RequestParam("amount") int amount) {
        Product product = productsvc.findById(productId);
//        List<Product> lp = productsvc.findAll();
//        List<Order> lo = ordersvc.findAll();
//        List<OrderProduct> orpd = orderproductsvc.findAll();
//        System.out.println(lp);
//        System.out.println(lo);
//        System.out.println(orpd);
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        // Обновление количества товара в заказе
        OrderProduct op = orderproductsvc.getExactOP(cart, product);
        orderproductsvc.delete(op);
        op.setPoAmount(amount);
        orderproductsvc.save(op);
        return "redirect:/cart";
    }
//
//    @PostMapping("/cart/removeItem")
//    public String removeItemFromCart(@RequestParam("productId") int productId) {
//        // Удаление позиции из заказа
//        orderproductsvc.removeItem(productId);
//        return "redirect:/cart";
//    }
//
//    @PostMapping("/cart/confirmOrder")
//    public String confirmOrder(@AuthenticationPrincipal UserDetails user) {
//        // Подтверждение заказа
//        Client client = clientsvc.findClientByLogin(user.getUsername());
//        Order cart = clientsvc.getCart(client);
//        ordersvc.confirmOrder(cart);
//        return "redirect:/search";
//    }
}
