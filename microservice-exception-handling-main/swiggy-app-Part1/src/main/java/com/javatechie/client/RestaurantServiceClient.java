package com.javatechie.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.javatechie.dto.OrderResponseDTO;

@Component
public class RestaurantServiceClient {
	@Autowired
	private RestTemplate template;

	public OrderResponseDTO fetchOrderStatus(String orderId) {
		OrderResponseDTO orderResponseDTO = null;
		orderResponseDTO = template.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId,
				OrderResponseDTO.class);

		return orderResponseDTO;
	}
}
