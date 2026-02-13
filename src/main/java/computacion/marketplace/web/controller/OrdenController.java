package computacion.marketplace.web.controller;

import computacion.marketplace.domain.service.OrdenService;
import computacion.marketplace.persistence.entity.Response;
import computacion.marketplace.web.dto.CompraRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comprar")
@CrossOrigin(origins = "*")
public class OrdenController {
    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @PostMapping
    public Response realizarCompra(@RequestBody CompraRequest request) {
        try {
            return ordenService.procesarCompra(request);
        } catch (RuntimeException e) {
            return new Response(400, false, e.getMessage());
        } catch (Exception e) {
            return new Response(500, false, "Error interno del servidor");
        }
    }
}
