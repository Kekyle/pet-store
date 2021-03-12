package by.swaggersample.petstore.service;

import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;
import by.swaggersample.petstore.repository.StoreRepository;
import by.swaggersample.petstore.repository.jpa.StoreDataRepository;
import by.swaggersample.petstore.service.exception.InvalidIdSuppliedException;
import by.swaggersample.petstore.service.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDataRepository storeRepository;

    @Override
    public Order createOrder(Order order) {
        log.info("method createOrder has started");
        log.debug("order : " + order.toString());
        return storeRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {
        log.info("method getOrderById has started");
        log.debug("id = " + id);
        if (storeRepository.existsById(id)) {
            return storeRepository.getOne(id);
        } else if (!storeRepository.existsById(id)) {
            throw new InvalidIdSuppliedException("Invalid id supplied");
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }

    @Override
    public void deleteOrderById(long id) {
        log.info("method deleteOrderById has started");
        log.debug("id = " + id);
        if (storeRepository.existsById(id)) {
            storeRepository.deleteById(id);
        } else if (!storeRepository.existsById(id)) {
            throw new InvalidIdSuppliedException("Invalid id supplied");
        } else {
            throw new OrderNotFoundException("Order not found");
        }
    }

    @Override
    public Map<Status, Integer> getCountByStatusCode() {
        log.info("method getCountByStatusCode has started");
        return null;
    }
}
