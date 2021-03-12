package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;

import java.util.Map;

public interface StoreService {
    Order createOrder(Order order);

    Order getOrderById(long id);

    void deleteOrderById(long id);

    Map<Status, Integer> getCountByStatusCode();
}
