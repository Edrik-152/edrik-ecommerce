package com.edrik.ecommerce.contoller;

import com.edrik.ecommerce.Service.OrderService;
import com.edrik.ecommerce.model.Order;
import com.edrik.ecommerce.model.UpdateOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {

    private final OrderService service;


    @GetMapping("/name")
    public String get(){
        return "edrik";
    }



    @PostMapping("/create-order")
    public Order createOrder(@RequestBody Order order, @RequestHeader HttpHeaders headers){

       return service.createOrder(order,headers);
    }

    @GetMapping("/get-order/{id}")
    public Order getOrderById(@PathVariable UUID id){
        return service.getOrderById(id);
    }
    @GetMapping("/get-orders")
    public List<Order> getOrder(){
        return service.getOrders();
    }
    @PutMapping("/update-order")
    public Order updateOrder(@RequestBody UpdateOrder order) {
        return service.updateOrder(order);
    }
    @PatchMapping("/patch-order/{id}")
    public Order patchOrder(@PathVariable UUID id,@RequestBody Order order){
        return service.patchOrder(order,id);
    }
    @DeleteMapping("/delete-order/{id}")
    public String deleteOrder(@PathVariable UUID id){
        return service.deleteOrder(id);
    }
}

