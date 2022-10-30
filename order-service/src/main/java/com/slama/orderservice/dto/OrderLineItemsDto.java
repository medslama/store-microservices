package com.slama.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderLineItemsDto {

    private String code;
    private BigDecimal price;
    private Integer quantity;
}
