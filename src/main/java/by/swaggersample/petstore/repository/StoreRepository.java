package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;

import java.util.Map;

public interface StoreRepository {
    Order createOrder(Order order);

    Order getOrderById(long id);

    void deleteOrderById(long id);

    Map<Status, Integer> getCountByStatusCode();

    boolean containsById(long id);
}
