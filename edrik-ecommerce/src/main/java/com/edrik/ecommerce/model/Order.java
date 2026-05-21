package com.edrik.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
@JsonProperty(access = JsonProperty.Access.READ_ONLY)
private UUID orderId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
private OrderStatus status;
private String orderName;
private Long price;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
private Date orderedAt;
private String createdBy;
}
