package com.edrik.ecommerce.mapper;


import com.edrik.ecommerce.Dto.OrderDto;
import com.edrik.ecommerce.model.Order;

public class OrderMapper {
    public static OrderDto toDto(Order order){
        OrderDto dto=new OrderDto();
        dto.setName(order.getOrderName());
        dto.setPrice(order.getPrice());
        return dto;
    }
    public static Order toOrder(OrderDto dto){
        Order order=new Order();
        order.setOrderName(dto.getName());
        order.setPrice(dto.getPrice());
        return order;
    }
}
