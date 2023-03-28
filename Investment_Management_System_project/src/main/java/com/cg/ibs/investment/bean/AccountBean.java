package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@NamedQueries({
	@NamedQuery(name = "getAccByUci", query = "select c from AccountBean c where c.uci=?1")
})
public class AccountBean implements Serializable {
	@Id
	@Column(name = "account_number", nullable = false, length = 11)
	private BigInteger accNo;
	@Column(name = "uci", nullable = false, length = 16)
	private BigInteger uci;
	@Column(name = "balance", nullable = false, length = 20)
	private BigDecimal balance;
	@Column(name = "transac_pass", nullable = false, length = 15)
	private String trans_Pwd;
	@Column(name = "acc_creation_date", nullable = false)
	private LocalDate accCreationDate;
	@Column(name = "open_balance", nullable = false, length = 20)
	private BigDecimal openBalance;
	@Column(name = "acc_status", nullable = false, length = 7)
	@Enumerated(EnumType.STRING)
	private AccountStatus accStatus;
	@Column(name = "account_type", nullable = false, length = 7)
	@Enumerated(EnumType.STRING)
	private AccountType accType;
	@OneToMany(mappedBy = "account", cascade = CascadeType.PERSIST)
	private Set<AccountHoldingBean> accountHoldings;
	@Column(name = "tenure", length = 7)
	private double tenure = -1;
	@Column(name = "maturity_amt", length = 20)
	private BigDecimal maturityAmt = new BigDecimal(-1);

	@OneToMany(cascade = CascadeType.ALL)
	private Set<TransactionBean> transaction = new HashSet<TransactionBean>();

	public AccountBean() {
		super();
	}

	public BigInteger getAccNo() {
		return accNo;
	}

	public void setAccNo(BigInteger accNo) {
		this.accNo = accNo;
	}

	public BigInteger getUci() {
		return uci;
	}

	public void setUci(BigInteger uci) {
		this.uci = uci;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getTrans_Pwd() {
		return trans_Pwd;
	}

	public void setTrans_Pwd(String trans_Pwd) {
		this.trans_Pwd = trans_Pwd;
	}

	public LocalDate getAccCreationDate() {
		return accCreationDate;
	}

	public void setAccCreationDate(LocalDate accCreationDate) {
		this.accCreationDate = accCreationDate;
	}

	public BigDecimal getOpenBalance() {
		return openBalance;
	}

	public void setOpenBalance(BigDecimal openBalance) {
		this.openBalance = openBalance;
	}

	public AccountStatus getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(AccountStatus accStatus) {
		this.accStatus = accStatus;
	}

	public AccountType getAccType() {
		return accType;
	}

	public void setAccType(AccountType accType) {
		this.accType = accType;
	}

	public Set<AccountHoldingBean> getAccountHoldings() {
		return accountHoldings;
	}

	public void setAccountHoldings(Set<AccountHoldingBean> accountHoldings) {
		this.accountHoldings = accountHoldings;
	}

	public Set<TransactionBean> getTransaction() {
		return transaction;
	}

	public void setTransaction(Set<TransactionBean> transaction) {
		this.transaction = transaction;
	}

	public double getTenure() {
		return tenure;
	}

	public void setTenure(double tenure) {
		this.tenure = tenure;
	}

	public BigDecimal getMaturityAmt() {
		return maturityAmt;
	}

	public void setMaturityAmt(BigDecimal maturityAmt) {
		this.maturityAmt = maturityAmt;
	}

}
