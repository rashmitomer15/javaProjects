package com.assessment.microservices.aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class AggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@Bean(name = "restTemp")
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
