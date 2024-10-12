package com.tek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tek.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
	
	 Payment findByOrderId(int orderId);

}
