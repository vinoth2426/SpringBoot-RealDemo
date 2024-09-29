package com.insurance.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.insurance.dao.InsurancePolicyDao;
import com.insurance.dto.ApiResponse;
import com.insurance.dto.InsurancePolicy;

@Service
public class InsurancePolicyService {

	@Autowired
	private InsurancePolicyDao insurancePolicyDao;

	@Autowired
	private ApiResponse<InsurancePolicy> insuranceResponse;

	@Autowired
	private ApiResponse<List<InsurancePolicy>> findAllinsuranceResponse;

	public ApiResponse<InsurancePolicy> inserClient(InsurancePolicy insurancePolicy) {

		insurancePolicy = insurancePolicyDao.insertInsurancePolicy(insurancePolicy);

		if (Objects.isNull(insurancePolicy)) {
			insuranceResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			insuranceResponse.setMsg("Data is not saved.");
			insuranceResponse.setData(null);
		} else {
			insuranceResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			insuranceResponse.setMsg("Policy Created successfully done.");
			insuranceResponse.setData(insurancePolicy);
		}
		return insuranceResponse;

	}

	public ApiResponse<InsurancePolicy> getByInsuracePolicyId(int policyId) {

		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);

		if (Objects.isNull(insurancePolicy)) {

			throw new RuntimeException("InsurancePolicy Details not found");
		}

		insuranceResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		insuranceResponse.setMsg("insurancePolicy not found.");
		insuranceResponse.setData(insurancePolicy);

		return insuranceResponse;

	}

	public ApiResponse<InsurancePolicy> deleteInsuracePolicy(int policyId) {

		InsurancePolicy insurancePolicy = insurancePolicyDao.deleteInsurancePolicyId(policyId);

		if (Objects.isNull(insurancePolicy)) {

			throw new RuntimeException("InsurancePolicy Details not found");
		}

		insuranceResponse.setStatusCode(HttpStatus.FOUND.value());
		insuranceResponse.setMsg("InsurancePolicy Deleted successfully.");
		insuranceResponse.setData(insurancePolicy);

		return insuranceResponse;

	}

	public ApiResponse<List<InsurancePolicy>> displayAllPolicy() {

		List<InsurancePolicy> policys = insurancePolicyDao.displayAllInsurancyPolicy();
		if (Objects.isNull(policys)) {
			findAllinsuranceResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			findAllinsuranceResponse.setMsg("policy Details are not avalible.");
			findAllinsuranceResponse.setData(null);
		} else {
			findAllinsuranceResponse.setStatusCode(HttpStatus.FOUND.value());
			findAllinsuranceResponse.setMsg("policy Details avalible.");
			findAllinsuranceResponse.setData(policys);
		}

		return findAllinsuranceResponse;
	}

}
