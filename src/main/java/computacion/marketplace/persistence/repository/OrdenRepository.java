package computacion.marketplace.persistence.repository;

import computacion.marketplace.persistence.entity.OrdenEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrdenRepository extends CrudRepository<OrdenEntity, Long> {
}
