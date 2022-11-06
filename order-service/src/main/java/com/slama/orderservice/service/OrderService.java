package com.slama.orderservice.service;

import com.slama.orderservice.dto.OrderRequest;
import com.slama.orderservice.model.Order;
import com.slama.orderservice.model.OrderLineItems;
import com.slama.orderservice.model.mapper.OrderLineItemsDtoToOrderLineItemsMapper;
import com.slama.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public record OrderService(
        OrderLineItemsDtoToOrderLineItemsMapper orderLineItemsDtoToOrderLineItemsMapper,
        OrderRepository orderRepository
) {

    public void createOrder(OrderRequest orderRequest) {

        Order order = new Order();

        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> rs = orderRequest.getOrderLineItemsList().stream().map(orderLineItemsDtoToOrderLineItemsMapper::mapTo).toList();
        order.setOrderLineItemsList(rs);

        orderRepository.save(order);
    }
}
