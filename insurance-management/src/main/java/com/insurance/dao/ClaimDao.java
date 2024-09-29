package com.insurance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.dto.Claim;
import com.insurance.repository.ClaimRepository;

@Repository
public class ClaimDao {

	@Autowired
	private ClaimRepository claimRepository;

	public Claim insertClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	public Claim getByClaimId(int claimId) {

		Optional<Claim> optinal = claimRepository.findById(claimId);

		if (optinal.isPresent()) {
			return optinal.get();
		}

		return null;
	}

	public Claim deleteClaimId(int claimId) {
		Optional<Claim> optinal = claimRepository.findById(claimId);
		if (optinal.isPresent()) {
			claimRepository.deleteById(claimId);
			return optinal.get();
		}
		return null;
	}

	public Claim updateClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	public List<Claim> displayAllClaim() {

		return claimRepository.findAll();
	}

}
