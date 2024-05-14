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


    @PostMapping("/searchByCategory")
    public String searchByCategory(@RequestParam(name = "category") String category, Model model){
        return "redirect:/search?id="+category;
    }




    @GetMapping("/product")
    public String getProductDetails(@RequestParam(name = "id") int productId, Model model) {
        // Получаем информацию о товаре по его ID
        Product product = productsvc.findById(productId);
        if (product == null) {
            // Если товар с указанным ID не найден, перенаправляем на страницу поиска
            return "redirect:/search";
        }
        List<Review> reviews = reviewsvc.getProductReviews(product);
        List<ReviewWithAuthor> rwas = new ArrayList<>();
        for (Review review : reviews){
            Client client = clientsvc.findById(review.getClient().getClientId());
            ReviewWithAuthor rwa = new ReviewWithAuthor(review, client);
            rwas.add(rwa);
        }

        // Если товар найден, передаем его информацию на страницу
        model.addAttribute("reviews", rwas);
        model.addAttribute("product", product);
        return "product";
    }

    @PostMapping("/product/addReview")
    public String addReview(@AuthenticationPrincipal UserDetails user, @RequestParam(name = "productId") int productId, @RequestParam(name = "rate") int rate, @RequestParam(name = "reviewText") String reviewText){
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Product product = productsvc.findById(productId);
        Review review = new Review(product, client, rate, reviewText);
        reviewsvc.save(review);
        return "redirect:/product?id=" + productId;


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
        cartItems.sort((x,y)->x.getProduct().getProductName().compareTo(y.getProduct().getProductName()));
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@AuthenticationPrincipal UserDetails user, @RequestParam("productId") int productId, @RequestParam("amount") int amount, Model model) {
        Product product = productsvc.findById(productId);
        if (product.getProductAmount() < amount) {
            model.addAttribute("messageprod", "Only " + product.getProductAmount() + " of " + product.getProductName() + " in stock");
            model.addAttribute("product", product);
            return "product";
        }
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
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        // Обновление количества товара в заказе
        OrderProduct op = orderproductsvc.getExactOP(cart, product);
        orderproductsvc.delete(op);
        op.setPoAmount(amount);
        orderproductsvc.save(op);
        return "redirect:/cart";
    }

    @PostMapping("/cart/removeFromCart")
    public String removeItemFromCart(@AuthenticationPrincipal UserDetails user, @RequestParam("productId") int productId) {
        Product product = productsvc.findById(productId);
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        OrderProduct op = orderproductsvc.getExactOP(cart, product);
        orderproductsvc.delete(op);
        return "redirect:/cart";
    }

    @PostMapping("/cart/confirmOrder")
    public String confirmOrder(@AuthenticationPrincipal UserDetails user, Model model) {
        // Подтверждение заказа
        Client client = clientsvc.findClientByLogin(user.getUsername());
        Order cart = clientsvc.getCart(client);
        List<OrderProduct> orderProducts = ordersvc.getOrderProducts(cart);
        if (orderProducts.isEmpty()) {
            model.addAttribute("messageprod", "Корзина пустая!");
            List<OrderProduct> cartProducts = ordersvc.getOrderProducts(cart);
            List<CartItemDTO> cartItems = new ArrayList<>();
            for (OrderProduct orderProduct : cartProducts) {
                Product product2 = productsvc.findById(orderProduct.getProduct().getProductId());
                CartItemDTO cartItemDTO = new CartItemDTO(orderProduct, product2);
                cartItems.add(cartItemDTO);
            }
            cartItems.sort((x,y)->x.getProduct().getProductName().compareTo(y.getProduct().getProductName()));
            model.addAttribute("cartItems", cartItems);
            return "cart";
        }
        for (OrderProduct productwithamount : orderProducts){
            Product product = productsvc.findById(productwithamount.getProduct().getProductId());
            if (productwithamount.getPoAmount() > product.getProductAmount()) {
                model.addAttribute("messageprod", "Only " + product.getProductAmount() + " of " + product.getProductName() + " in stock");
                List<OrderProduct> cartProducts = ordersvc.getOrderProducts(cart);
                List<CartItemDTO> cartItems = new ArrayList<>();
                for (OrderProduct orderProduct : cartProducts) {
                    Product product2 = productsvc.findById(orderProduct.getProduct().getProductId());
                    CartItemDTO cartItemDTO = new CartItemDTO(orderProduct, product2);
                    cartItems.add(cartItemDTO);
                }
                cartItems.sort((x,y)->x.getProduct().getProductName().compareTo(y.getProduct().getProductName()));
                model.addAttribute("cartItems", cartItems);
                return "cart";
            }
            product.setProductAmount(product.getProductAmount() - productwithamount.getPoAmount());
            productsvc.update(product);
        }
        cart.setStatus(1);
        ordersvc.update(cart);
        cart = new Order(client, 0, 0, null, null);
        ordersvc.save(cart);
        return "redirect:/profile";
    }


    @GetMapping("/profile")
    public String viewProfile(@AuthenticationPrincipal UserDetails user, Model model) {
        Client client = clientsvc.findClientByLogin(user.getUsername());
        List<Order> orders = clientsvc.getOrders(client);
        List<List<CartItemDTO>> listOfOrders = new ArrayList<>();
        for (Order order : orders) {
            List<OrderProduct> cartProducts = ordersvc.getOrderProducts(order);
            List<CartItemDTO> cartItems = new ArrayList<>();
            for (OrderProduct orderProduct : cartProducts) {
                Product product = productsvc.findById(orderProduct.getProduct().getProductId());
                CartItemDTO cartItemDTO = new CartItemDTO(orderProduct, product);
                cartItems.add(cartItemDTO);
            }
            cartItems.sort((x,y)->x.getProduct().getProductName().compareTo(y.getProduct().getProductName()));
            listOfOrders.add(cartItems);
        }
        model.addAttribute(client);
        model.addAttribute("orders", listOfOrders);
        return "profile";
    }


}
