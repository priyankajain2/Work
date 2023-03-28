package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MUTUAL_FUND")
public class MutualFund implements Serializable{
	
	
	@Id
	private Integer folioNumber;
	@OneToOne
	private BankMutualFund bankMutualFund;
	@Column(precision = 2)		
	private Double mfUnits;
	@Column(precision = 2)
	private Double mfAmount;		
	private LocalDate openingDate;	
	private LocalDate closingDate;
	private Integer duration;
	private Integer installments;
	@Enumerated(EnumType.STRING)
	private Frequency frequency;
	private Boolean status;
	private MFType type;
	private LocalDate nextInstallDate;
	private LocalDate buyDate;
	@ManyToOne(cascade = CascadeType.MERGE)
	private InvestmentBean inv;
	
	public InvestmentBean getInv() {
		return inv;
	}
	public void setInv(InvestmentBean inv) {
		this.inv = inv;
	}
	public MutualFund() {
		super();
	}
	
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
	
	public LocalDate getNextInstallDate() {
		return nextInstallDate;
	}
	public void setNextInstallDate(LocalDate nextInstallDate) {
		this.nextInstallDate = nextInstallDate;
	}
	public Integer getFolioNumber() {
		return folioNumber;
	}
	public void setFolioNumber(Integer folioNumber) {
		this.folioNumber = folioNumber;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	public BankMutualFund getBankMutualFund() {
		return bankMutualFund;
	}
	public void setBankMutualFund(BankMutualFund bankMutualFund) {
		this.bankMutualFund = bankMutualFund;
	}
	public Double getMfUnits() {
		return mfUnits;
	}
	public void setMfUnits(Double mfUnits) {
		this.mfUnits = mfUnits;
	}
	public Double getMfAmount() {
		return mfAmount;
	}
	public void setMfAmount(Double mfAmount) {
		this.mfAmount = mfAmount;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public MFType getType() {
		return type;
	}
	public void setType(MFType type) {
		this.type = type;
	}
	public LocalDate getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(LocalDate buyDate) {
		this.buyDate = buyDate;
	}
	
	
	
}
