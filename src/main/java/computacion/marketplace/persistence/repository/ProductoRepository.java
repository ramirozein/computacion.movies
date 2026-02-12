package computacion.marketplace.persistence.repository;

import computacion.marketplace.persistence.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {
}
