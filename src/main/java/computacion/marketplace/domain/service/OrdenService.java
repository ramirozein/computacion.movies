package computacion.marketplace.domain.service;

import computacion.marketplace.persistence.entity.OrdenDetalleEntity;
import computacion.marketplace.persistence.entity.OrdenEntity;
import computacion.marketplace.persistence.entity.ProductoEntity;
import computacion.marketplace.persistence.entity.Response;
import computacion.marketplace.persistence.repository.OrdenDetalleRepository;
import computacion.marketplace.persistence.repository.OrdenRepository;
import computacion.marketplace.persistence.repository.ProductoRepository;
import computacion.marketplace.web.dto.CompraItem;
import computacion.marketplace.web.dto.CompraRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrdenService {
    private final ProductoRepository productoRepository;
    private final OrdenRepository ordenRepository;
    private final OrdenDetalleRepository ordenDetalleRepository;

    public OrdenService(ProductoRepository productoRepository, OrdenRepository ordenRepository, OrdenDetalleRepository ordenDetalleRepository) {
        this.productoRepository = productoRepository;
        this.ordenRepository = ordenRepository;
        this.ordenDetalleRepository = ordenDetalleRepository;
    }

    @Transactional
    public Response procesarCompra(CompraRequest request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            return new Response(400, false, "El carrito esta vacio");
        }

        OrdenEntity orden = new OrdenEntity();
        orden.setFecha(LocalDateTime.now());
        orden.setTotal(0.0);

        // Save first to generate ID
        orden = ordenRepository.save(orden);

        double totalCalculado = 0.0;

        for (CompraItem item : request.getItems()) {
            Optional<ProductoEntity> productoOpt = productoRepository.findById(item.getProductoId());

            if (productoOpt.isEmpty()) {
                throw new RuntimeException("Producto no encontrado: " + item.getProductoId());
            }

            ProductoEntity producto = productoOpt.get();

            if (producto.getStock() < item.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            // Update Stock
            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);

            // Create Detail
            OrdenDetalleEntity detalle = new OrdenDetalleEntity();
            detalle.setOrden(orden);
            detalle.setProducto(producto);
            detalle.setCantidad(item.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            ordenDetalleRepository.save(detalle);

            totalCalculado += (producto.getPrecio() * item.getCantidad());
        }

        orden.setTotal(totalCalculado);
        ordenRepository.save(orden);

        return new Response(200, true, "Compra realizada con exito. Orden #" + orden.getId());
    }
}
