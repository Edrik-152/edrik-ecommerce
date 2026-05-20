package com.edrik.ecommerce.dao;


import com.edrik.ecommerce.model.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class OrderDao {
     Map<UUID, Order>  map  = new HashMap<>();;

    public  List<Order> getOrders() {

        List<Order> orderList = new ArrayList<>();
        for (Map.Entry<UUID,Order> o:map.entrySet()){
            orderList.add(o.getValue());
        }

        return orderList ;
    }


    public  Order createOrder(Order order){
        if(check(order.getOrderId())){
            map.put(order.getOrderId(),order);
        }

        return order;
    }
    public boolean check(UUID id){
        if(map.containsKey(id)){
            return false;
        }
        return true;
    }

    public Order getOrderById(UUID id) {
        return map.get(id);
    }

    public Order updateOrder(Order order) {
        if(check(order.getOrderId())){
            map.put(order.getOrderId(),order);
            return map.get(order.getOrderId());
        }
        return null;
    }
}
