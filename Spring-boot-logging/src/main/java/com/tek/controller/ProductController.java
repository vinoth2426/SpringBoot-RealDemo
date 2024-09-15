package com.tek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tek.model.Product;
import com.tek.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save")
	public List<Product> saveProducts(@RequestBody List<Product> products) {

		List<Product> pList = service.addProduct(products);

		return pList;
	}

	@GetMapping("/findProducts")
	public List<Product> getProducts() {

		List<Product> products = service.findAllProducts();

		return products;
	}

	@GetMapping("/findByProductId")
	public Optional<Product> getProductById(@RequestParam int id) {

		Optional<Product> product = service.findByProduct(id);

		return product;
	}
}
