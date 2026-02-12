package computacion.marketplace.persistence.repository;

import computacion.marketplace.persistence.entity.OrdenDetalleEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdenDetalleRepository extends CrudRepository<OrdenDetalleEntity, Long> {
}
