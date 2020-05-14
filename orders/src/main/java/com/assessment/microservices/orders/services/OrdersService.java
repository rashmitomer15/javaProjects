package com.assessment.microservices.orders.services;

import java.util.List;

import com.assessment.microservices.orders.entities.Order;

public interface OrdersService {

	List<Order> getOrdersForUser(Integer userId);
}
