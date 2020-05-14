package com.assessment.microservices.orders.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.microservices.orders.entities.Order;
import com.assessment.microservices.orders.services.OrdersService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
	@Value("${server.port}")
	private int port;

	@Resource
	OrdersService ordersService;

	@GetMapping(value = "/{id}")
	List<Order> getUser(@PathVariable(name = "id") int userId) {
		System.out.println("Working from port " + port + " of order service");
		return ordersService.getOrdersForUser(userId);
	}

}
