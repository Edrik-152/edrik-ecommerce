package com.edrik.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

private UUID orderId;
private OrderStatus status;
private String orderName;
private long price;
private Date orderedAt;
private Date createdBy;
}
