package computacion.marketplace.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("Marketplace", "Mi primera página con Spring Boot");
        return "index";
    }
}
