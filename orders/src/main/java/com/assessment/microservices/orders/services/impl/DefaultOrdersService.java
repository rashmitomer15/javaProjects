package com.assessment.microservices.orders.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.assessment.microservices.orders.entities.Order;
import com.assessment.microservices.orders.services.OrdersService;

@Service
public class DefaultOrdersService implements OrdersService {

	@Override
	public List<Order> getOrdersForUser(Integer userId) {
		List<Order> resultproduct = getAllOrders().stream()
				.filter(p -> userId.equals(p.getUserId())).collect(Collectors.toList());
		if (resultproduct.size()>0) {
			return resultproduct;
		}
		return Collections.emptyList();
	}
	
	protected List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1, 250.0D,"14-Apr-2020",1));
		orders.add(new Order(2, 420.0D,"15-Apr-2020",1));		
		orders.add(new Order(3, 250.0D,"14-Apr-2020",2));
		return orders;
	}


}
