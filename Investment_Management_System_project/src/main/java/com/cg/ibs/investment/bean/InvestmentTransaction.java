package com.cg.ibs.investment.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_extended")
@NamedQueries({
		@NamedQuery(name = "getTransactions", query = "select c from InvestmentTransaction c where c.account=?1 order by c.transactionDate"),
		@NamedQuery(name = "GET_PERIODIC", query = "select t from InvestmentTransaction t where t.account= :accNo AND t.transactionDate BETWEEN :startDate AND :endDate") })

public class InvestmentTransaction extends TransactionBean implements Serializable {
	@Column(name = "units", precision = 2)
	private Double units;
	@Column(name = "price_per_unit", precision = 2)
	private Double pricePerUnit;

	public InvestmentTransaction() {
		super();
	}

	public Double getUnits() {
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	@Override
	public String toString() {
		return "InvestmentTransaction [units=" + units + ", pricePerUnit=" + pricePerUnit + ", toString()="
				+ super.toString() + "]";
	}

}
