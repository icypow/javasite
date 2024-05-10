package Controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Entity.*;
import Service.*;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.time.LocalDate;


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

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        // Проверяем данные логина
        if (!clientsvc.isValidLogin(username, password)) { //ДОПИСАТЬ СЕРВИС ПРОВЕРКИ ЛОГИНА
            // Если данные неверны, добавляем сообщение об ошибке в модель
            model.addAttribute("error", "Invalid username or password. Please try again.");
            // Возвращаем страницу логина снова
            return "login";
        }

        // Если данные верны, выполните необходимые действия (например, редирект на другую страницу)
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(String username, String password, String phone, String fullName, String email, String address) {
        //добавление клиента в бд
        return "redirect:/login";
    }

}