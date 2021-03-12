package by.swaggersample.petstore.resource;

import by.swaggersample.petstore.domain.Order;
import by.swaggersample.petstore.domain.Status;
import by.swaggersample.petstore.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "/store")
@Slf4j
public class StoreResource {

    @Autowired
    private StoreService storeService;

    @PostMapping(path = "/order")
    public Order createOrder(@Valid @RequestBody Order order){
        log.info("method createOrder has started");
        log.debug("Order: " + order.toString());
        return storeService.createOrder(order);
    }

    @GetMapping(path = "/order/{orderId}")
    public Order getOrderById(@PathVariable long orderId){
        log.info("method getOrderById has started");
        log.debug("orderId = " + orderId);
        return storeService.getOrderById(orderId);
    }

    @DeleteMapping(path = "/order/{orderId}")
    public void deleteOrderById(@PathVariable long orderId){
        log.info("method deleteOrderById has started");
        log.debug("orderId = " + orderId);
        storeService.deleteOrderById(orderId);
    }

    @GetMapping(path = "/inventory")
    public Map<Status, Integer> getCountByStatusCode(){
        log.info("method getCountByStatusCode has started");
        return storeService.getCountByStatusCode();
    }
}
