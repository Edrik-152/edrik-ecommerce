package com.edrik.ecommerce.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateOrder {
    private UUID id;
    private OrderStatus status;
    private String orderName;
    private long price;
    private Date orderedAt;
    private String createdBy;
}
