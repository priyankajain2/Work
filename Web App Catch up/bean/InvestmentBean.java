package com.cg.ibs.investment.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cg.ibs.common.bean.TransactionBean;

public class InvestmentBean extends MutualFund {
	
	private String UCI;
	private String userId;
	private String password;
	private double goldunits;
	private double silverunits;
	private double balance;
	private HashMap<String,MutualFund> funds;
	private List<TransactionBean> transactionList;
	
	public InvestmentBean() {
		super();
	}
	public InvestmentBean(String uCI, String userId, String password, double goldunits, double silverunits,
			double balance, HashMap<String, MutualFund> funds, List<TransactionBean> transactionList) {
		super();
		UCI = uCI;
		this.userId = userId;
		this.password = password;
		this.goldunits = goldunits;
		this.silverunits = silverunits;
		this.balance = balance;
		this.funds = funds;
		this.transactionList = transactionList;
	}
	public String getUCI() {
		return UCI;
	}
	public void setUCI(String uCI) {
		UCI = uCI;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getGoldunits() {
		return goldunits;
	}
	public void setGoldunits(double goldunits) {
		this.goldunits = goldunits;
	}
	public double getSilverunits() {
		return silverunits;
	}
	public void setSilverunits(double silverunits) {
		this.silverunits = silverunits;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public HashMap<String,MutualFund> getFunds() {
		return funds;
	}
	public void setFunds(HashMap<String, MutualFund> funds) {
		this.funds = funds;
	}
	public List<TransactionBean> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<TransactionBean> transactionList) {
		this.transactionList = transactionList;
	}
	@Override
	public String toString() {
		return "InvestmentBean [UCI=" + UCI + ", goldunits=" + goldunits + ", silverunits=" + silverunits + ", balance="
				+ balance + ", funds=" + funds + "]";
	}
	
}
