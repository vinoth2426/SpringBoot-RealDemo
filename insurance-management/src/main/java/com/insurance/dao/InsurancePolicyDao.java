package com.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.dto.InsurancePolicy;
import com.insurance.repository.InsurancePolicyRepository;

@Repository
public class InsurancePolicyDao {

	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;

	public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	public InsurancePolicy getByInsurancePolicyId(int insuranceId) {

		Optional<InsurancePolicy> optinal = insurancePolicyRepository.findById(insuranceId);

		if (optinal.isPresent()) {
			return optinal.get();
		}

		return null;
	}

	public InsurancePolicy deleteInsurancePolicyId(int insuranceId) {
		Optional<InsurancePolicy> optinal = insurancePolicyRepository.findById(insuranceId);
		if (optinal.isPresent()) {
			insurancePolicyRepository.deleteById(insuranceId);
			return optinal.get();
		}
		return null;
	}

	public List<InsurancePolicy> displayAllInsurancyPolicy() {

		return insurancePolicyRepository.findAll();
	}

}
