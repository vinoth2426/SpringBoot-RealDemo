package com.insurance.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "claim")
public class Claim {

	@Id
	@Column(name = "claimId")
	private int claimId;

	@Column(name = "claimNumber")
	private long claimNumber;

	@Column(name = "claimDescrption")
	private String claimDescrption;

	@Column(name = "claimDate")
	private String claimDate;

	@Column(name = "claimStatus")
	private String claimStatus;

	@Column(name = "claimAmount")
	private String claimAmount;

	@OneToOne
	@JoinColumn(name = "policyId")
	private InsurancePolicy insurancePolicy;

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getClaimDescrption() {
		return claimDescrption;
	}

	public void setClaimDescrption(String claimDescrption) {
		this.claimDescrption = claimDescrption;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

}
