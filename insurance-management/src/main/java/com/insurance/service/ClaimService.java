package com.insurance.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.insurance.dao.ClaimDao;
import com.insurance.dao.InsurancePolicyDao;
import com.insurance.dto.ApiResponse;
import com.insurance.dto.Claim;
import com.insurance.dto.InsurancePolicy;

@Service
public class ClaimService {

	@Autowired
	private InsurancePolicyDao insurancePolicyDao;

	@Autowired
	private ApiResponse<Claim> claimResponse;

	@Autowired
	private ClaimDao claimDao;

	@Autowired
	private ApiResponse<List<Claim>> findAllclaimResponse;

	public ApiResponse<Claim> inserClaim(Claim claim, int policyId) {

		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);

		if (Objects.isNull(insurancePolicy)) {
			claimResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			claimResponse.setMsg("Not claimed yet.");
			claimResponse.setData(null);
		} else {
			claim.setInsurancePolicy(insurancePolicy);
			claimDao.insertClaim(claim);
			claimResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			claimResponse.setMsg("Claimed successfully done.");
			claimResponse.setData(claim);
		}
		return claimResponse;
	}

	public ApiResponse<Claim> getByClaimId(int claimId) {

		Claim claim = claimDao.getByClaimId(claimId);

		if (Objects.isNull(claim)) {

			throw new RuntimeException("Claim Details not found");
		}

		claimResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		claimResponse.setMsg("Claimed exist.");
		claimResponse.setData(claim);

		return claimResponse;

	}

	public ApiResponse<Claim> deleteClaim(int claimId) {

		Claim claim = claimDao.deleteClaimId(claimId);

		if (Objects.isNull(claim)) {

			throw new RuntimeException("Claim Details not found");
		}

		claimResponse.setStatusCode(HttpStatus.FOUND.value());
		claimResponse.setMsg("Claimed Deleted successfully.");
		claimResponse.setData(claim);

		return claimResponse;

	}

	public ApiResponse<Claim> updateClaim(Claim claim) {

		Claim updateClaim = claimDao.getByClaimId(claim.getClaimId());

		if (Objects.isNull(claim)) {

			throw new RuntimeException("Claim Details not found");
		}
		updateClaim.setClaimNumber(claim.getClaimNumber());
		updateClaim.setClaimDate(claim.getClaimDate());
		updateClaim.setClaimDescrption(claim.getClaimDescrption());
		updateClaim.setClaimStatus(claim.getClaimStatus());

		claimResponse.setStatusCode(HttpStatus.ACCEPTED.value());
		claimResponse.setMsg("Claimed Updated successfully.");
		claimResponse.setData(updateClaim);

		return claimResponse;

	}

	public ApiResponse<List<Claim>> displayAllClaim() {

		List<Claim> claims = claimDao.displayAllClaim();
		if (Objects.isNull(claims)) {
			findAllclaimResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			findAllclaimResponse.setMsg("Claimed Details are not avalible.");
			findAllclaimResponse.setData(null);
		} else {
			findAllclaimResponse.setStatusCode(HttpStatus.FOUND.value());
			findAllclaimResponse.setMsg("Claimed Details avalible.");
			findAllclaimResponse.setData(claims);
		}

		return findAllclaimResponse;
	}

}
