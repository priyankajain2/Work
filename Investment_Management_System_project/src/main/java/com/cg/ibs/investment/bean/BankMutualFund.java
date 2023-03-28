package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bank_Mutual_Fund")
public class BankMutualFund implements Serializable {
	
	@Id
	private Integer mfPlanId;
	private String title;
	@Column(precision = 2)
	private Double nav;
	private LocalDate launchDate;
	@Column(precision = 2)
	private Double minAmtSip;
	@Column(precision = 2)
	private Double minAmtDir;

	private Boolean dirStatus;

	private Boolean sipStatus;
	private LocalDate expiryDate;

	public BankMutualFund() {
		super();
	}

	public Integer getMfPlanId() {
		return mfPlanId;
	}

	public void setMfPlanId(Integer mfPlanId) {
		this.mfPlanId = mfPlanId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getNav() {
		return nav;
	}

	public void setNav(Double nav) {
		this.nav = nav;
	}

	public LocalDate getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(LocalDate launchDate) {
		this.launchDate = launchDate;
	}

	public Double getMinAmtSip() {
		return minAmtSip;
	}

	public void setMinAmtSip(Double minAmtSip) {
		this.minAmtSip = minAmtSip;
	}

	public Double getMinAmtDir() {
		return minAmtDir;
	}

	public void setMinAmtDir(Double minAmtDir) {
		this.minAmtDir = minAmtDir;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getDirStatus() {
		return dirStatus;
	}

	public void setDirStatus(Boolean dirStatus) {
		this.dirStatus = dirStatus;
	}

	public Boolean getSipStatus() {
		return sipStatus;
	}

	public void setSipStatus(Boolean sipStatus) {
		this.sipStatus = sipStatus;
	}

}
