package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Investment_bean")
public class InvestmentBean implements Serializable {
	
	@Id
	private BigInteger UCI;
	@OneToOne
	@JoinColumn(name = "UCI")
	@MapsId
	private CustomerBean customer;

	@Column(precision = 2)
	private Double goldunits;

	@Column(precision = 2)
	private Double silverunits;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "inv")
	@JsonIgnore
	private Set<MutualFund> funds;
	@OneToOne(cascade= CascadeType.PERSIST)
	@JsonIgnore
	private AccountBean account;

	public InvestmentBean() {
		super();
	}

	public BigInteger getUCI() {
		return UCI;
	}

	public void setUCI(BigInteger bigInteger) {
		UCI = bigInteger;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public Double getGoldunits() {
		return goldunits;
	}

	public void setGoldunits(Double goldunits) {
		this.goldunits = goldunits;
	}

	public Double getSilverunits() {
		return silverunits;
	}

	public void setSilverunits(Double silverunits) {
		this.silverunits = silverunits;
	}

	

	

	public Set<MutualFund> getFunds() {
		return funds;
	}

	public void setFunds(Set<MutualFund> funds) {
		this.funds = funds;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}

}
