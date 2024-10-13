package com.tek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tek.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
