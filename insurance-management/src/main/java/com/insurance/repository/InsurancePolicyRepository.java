package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.dto.InsurancePolicy;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Integer> {

}
