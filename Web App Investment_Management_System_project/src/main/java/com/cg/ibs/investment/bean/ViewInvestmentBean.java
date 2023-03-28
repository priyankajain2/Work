package com.cg.ibs.investment.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public class ViewInvestmentBean {
	  private BigInteger Uci;
	    private Double goldUnits;
	    private Double silverUnits;
	    private Set<MutualFund> sipfunds;
	    private Set<MutualFund> dirFunds;
	    private BigInteger accountNumber;
	    private BigDecimal balance;
	    public ViewInvestmentBean() {
	        super();
	    }
	    public BigInteger getUci() {
	        return Uci;
	    }
	    public void setUci(BigInteger uci) {
	        Uci = uci;
	    }
	    public Double getGoldUnits() {
	        return goldUnits;
	    }
	    public void setGoldUnits(Double goldUnits) {
	        this.goldUnits = goldUnits;
	    }
	    public Double getSilverUnits() {
	        return silverUnits;
	    }
	    public void setSilverUnits(Double silverUnits) {
	        this.silverUnits = silverUnits;
	    }
	    
	    public BigInteger getAccountNumber() {
	        return accountNumber;
	    }
	    public void setAccountNumber(BigInteger accountNumber) {
	        this.accountNumber = accountNumber;
	    }
	    public BigDecimal getBalance() {
	        return balance;
	    }
	    public void setBalance(BigDecimal balance) {
	        this.balance = balance;
	    }
	    public Set<MutualFund> getSipfunds() {
	        return sipfunds;
	    }
	    public void setSipfunds(Set<MutualFund> sipfunds) {
	        this.sipfunds = sipfunds;
	    }
	    public Set<MutualFund> getDirFunds() {
	        return dirFunds;
	    }
	    public void setDirFunds(Set<MutualFund> dirFunds) {
	        this.dirFunds = dirFunds;
	    }
	    
}
