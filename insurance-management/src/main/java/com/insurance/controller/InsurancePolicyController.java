package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.ApiResponse;
import com.insurance.dto.InsurancePolicy;
import com.insurance.service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class InsurancePolicyController {

	@Autowired
	private InsurancePolicyService insurancePolicyService;

	@PostMapping("/saveInsurancePolicy")
	public ApiResponse<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyService.inserClient(insurancePolicy);
	}

	@GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
	public ApiResponse<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId) {
		return insurancePolicyService.getByInsuracePolicyId(insurancePolicyId);
	}

	@DeleteMapping("/deleteInsurancePolicy/{insurancePolicyId}")
	public ApiResponse<InsurancePolicy> deleteInsurancePolicy(@PathVariable int insurancePolicyId) {
		return insurancePolicyService.deleteInsuracePolicy(insurancePolicyId);
	}

	@GetMapping("/displayAllPolicy")
	public ApiResponse<List<InsurancePolicy>> displayAllPolicy() {
		return insurancePolicyService.displayAllPolicy();
	}

}
