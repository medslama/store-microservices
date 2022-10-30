package com.slama.orderservice.model.mapper;

import com.slama.orderservice.dto.OrderLineItemsDto;
import com.slama.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class OrderLineItemsDtoToOrderLineItemsMapper {

    public OrderLineItems mapTo(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setCode(orderLineItemsDto.getCode());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        return orderLineItems;
    }
}
