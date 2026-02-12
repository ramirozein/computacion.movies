package computacion.marketplace.web.controller;

import computacion.marketplace.persistence.entity.ProductoEntity;
import computacion.marketplace.persistence.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*")
public class HomeController {
    private final ProductoRepository productoRepository;

    public HomeController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        model.addAttribute("producto", new ProductoEntity());
        return "index";
    }
}
