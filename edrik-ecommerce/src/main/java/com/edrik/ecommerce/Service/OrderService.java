package com.edrik.ecommerce.Service;


import com.edrik.ecommerce.dao.OrderDao;
import com.edrik.ecommerce.model.Order;
import com.edrik.ecommerce.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

        private final OrderDao orderDao;
        public Order createOrder (Order order, HttpHeaders headers){
            order.setCreatedBy(headers.getFirst("createdBy"));
            if (validate(order)) {
                order.setOrderId(UUID.randomUUID());
                order.setStatus(OrderStatus.CREATED);
                order.setOrderedAt(new Date());
            }
            return orderDao.createOrder(order);

        }
        public boolean validate (Order order){
            boolean valid = true;
            if (!StringUtils.hasText(order.getOrderName())) {
                valid = false;
            }
            if (order.getPrice() < 0) {
                valid = false;
            }
            if (!StringUtils.hasText(order.getCreatedBy())) {
                valid = false;
            }
            return valid;
        }

        public Order getOrderById(UUID id){
            return orderDao.getOrderById(id);
        }

        public List<Order> getOrders() {
            return orderDao.getOrders();
        }


    public Order patchOrder(Order update,UUID id) {
            Order order = getOrderById(id);
            if(update.getOrderName()!=null){
                order.setOrderName(update.getOrderName());
            }
            if(update.getPrice()!=null){
                order.setPrice(update.getPrice());
            }
            return orderDao.patchOrder(order);
    }

    public String deleteOrder(UUID id) {
            Order order = getOrderById(id);
            return orderDao.deleteOrder(order);
    }

    public Order updateOrder(UUID id, Order update) {
            Order order=getOrderById(id);
            order.setOrderName(update.getOrderName());
            order.setPrice(update.getPrice());
            order.setCreatedBy(update.getCreatedBy());
            return orderDao.updateOrder(order);
    }
}
