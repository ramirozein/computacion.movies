package computacion.marketplace.web.controller;

import computacion.marketplace.persistence.entity.ProductoEntity;
import computacion.marketplace.persistence.entity.Response;
import computacion.marketplace.persistence.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<ProductoEntity> getAllProducts() {
        return (List<ProductoEntity>) productoRepository.findAll();
    }

    @PostMapping
    public Response saveProduct(@RequestBody ProductoEntity producto) {
        productoRepository.save(producto);
        return new Response(200, true, "Producto guardado correctamente");
    }
}
