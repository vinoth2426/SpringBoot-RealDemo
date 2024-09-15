package com.tek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tek.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}