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

//    @PostMapping("/login")
//    public String login(String username, String password, Model model) {
//        // Проверяем данные логина
//        if (!clientsvc.isValidLogin(username, password)) { //ДОПИСАТЬ СЕРВИС ПРОВЕРКИ ЛОГИНА
//            // Если данные неверны, добавляем сообщение об ошибке в модель
//            model.addAttribute("error", "Invalid username or password. Please try again.");
//            // Возвращаем страницу логина снова
//            return "login";
//        }
//
//        // Если данные верны, выполните необходимые действия (например, редирект на другую страницу)
//        return "redirect:/home";
//    }


    @GetMapping("/register")
    public String registerForm(@AuthenticationPrincipal Object user) {
        System.out.println(user);
        return "register";
    }


    @GetMapping("/test")
    public String test() {
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



    @GetMapping("/hello")
    public String helloForm(Model model) {
        return "hello";
    }

}