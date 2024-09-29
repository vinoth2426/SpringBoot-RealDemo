package com.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.dto.ApiResponse;
import com.insurance.dto.Claim;
import com.insurance.service.ClaimService;

@RestController
@RequestMapping("/api")
public class ClaimController {
	
	@Autowired
	private ClaimService  claimService;

	@PostMapping("/saveClaim/{policyId}")
	public ApiResponse<Claim> saveClaim(@RequestBody Claim claim,@PathVariable int policyId){
		return claimService.inserClaim(claim, policyId);
	}
	
	@GetMapping("/getByClaimId/{claimId}")
	public ApiResponse<Claim> getByClaimId(@PathVariable int claimId){
		return claimService.getByClaimId(claimId);
	}
	@DeleteMapping("/deleteClaim/{claimId}")
	public ApiResponse<Claim> deleteClaim(@PathVariable int claimId){
		return claimService.deleteClaim(claimId);
	}
	
	@PutMapping("/updateClaim/{claimId}")
	public ApiResponse<Claim> updateClaim(@RequestBody Claim claim){
		return claimService.updateClaim(claim);
	}
	
	@GetMapping("/displayAllClaim")
	public ApiResponse<List<Claim>> displayAllClaim(){
		return claimService.displayAllClaim();
	}
	
}
