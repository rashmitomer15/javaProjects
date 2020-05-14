package com.assessment.microservices.aggregator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assessment.microservices.aggregator.model.OrderDetails;
import com.assessment.microservices.aggregator.model.User;
import com.assessment.microservices.aggregator.services.AggregatorService;

@Service
public class DefaultAggregatorService implements AggregatorService {

	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@Override
	public OrderDetails getOrderDetails(Integer userId) {

		OrderDetails orderDet = new OrderDetails();

		String url = "/user/" + userId;

		url = "http://users" + url;
		ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, null, User.class);
		User user = response.getBody();

		orderDet.setUserDetails(user);
		
		String url2 = "/orders/" + userId;

		url2 = "http://orders" + url2;
		ResponseEntity<List> response1 = restTemplate.exchange(url2, HttpMethod.GET, null, List.class);
		List orderList = response1.getBody();
		
		orderDet.setOrders(orderList);

		return orderDet;
	}

}
