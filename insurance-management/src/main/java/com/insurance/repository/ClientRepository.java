package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.dto.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
