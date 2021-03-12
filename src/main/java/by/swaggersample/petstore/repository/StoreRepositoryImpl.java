package by.swaggersample.petstore.repository;

import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    private List<Order> orderList = new ArrayList<>();

    @Override
    public Order createOrder(Order order) {
        orderList.add(order);
        return order;
    }

    @Override
    public Order getOrderById(long id) {
        for (Order order : orderList) {
            if (order.getId() == id){
                return order;
            }
        }
        return null;
    }

    @Override
    public void deleteOrderById(long id) {
        for (Order order : orderList) {
            if (order.getId() == id){
                orderList.remove(order);
                break;
            }
        }
    }

    @Override
    public Map<Status, Integer> getCountByStatusCode() {
        Map<Status, Integer> countByStatus = new HashMap<>();
        for (Order order : orderList) {
            Status status = order.getStatus();
            if (countByStatus.containsKey(status)) {
                countByStatus.put(status, countByStatus.get(status) + order.getQuantity());
            } else {
                countByStatus.put(status, order.getQuantity());
            }
        }
        return countByStatus;
    }

    @Override
    public boolean containsById(long id) {
        for (Order order : orderList) {
            if (order.getId() == id){
                return true;
            }
        }
        return false;
    }
}
