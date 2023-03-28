package com.cg.ibs.investment.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Account_Holding_Bean")
public class AccountHoldingBean implements Serializable{
	@Id
	private Long aHId;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private CustomerBean customer;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private AccountBean account;
	@Enumerated(EnumType.STRING)
	private AccountHoldingType type;
	
	public AccountHoldingBean() {
		super();
	}
	public Long getaHId() {
		return aHId;
	}
	public void setaHId(Long aHId) {
		this.aHId = aHId;
	}
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	public AccountBean getAccount() {
		return account;
	}
	public void setAccount(AccountBean account) {
		this.account = account;
	}
	public AccountHoldingType getType() {
		return type;
	}
	public void setType(AccountHoldingType type) {
		this.type = type;
	}

}
