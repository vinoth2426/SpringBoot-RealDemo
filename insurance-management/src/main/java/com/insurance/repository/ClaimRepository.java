package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.dto.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {

}
