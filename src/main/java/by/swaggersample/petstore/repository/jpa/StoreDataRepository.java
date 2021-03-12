package by.swaggersample.petstore.repository.jpa;

import by.swaggersample.petstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDataRepository extends JpaRepository<Order, Long> {

}
