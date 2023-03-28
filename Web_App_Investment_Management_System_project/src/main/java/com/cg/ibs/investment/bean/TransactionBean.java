package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Transaction")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name = "GET_MINI1", query = "select t from TransactionBean t where t.account.accNo= :accNo order by t.transactionDate"),
		@NamedQuery(name = "GET_PERIODIC1", query = "select t from TransactionBean t where t.account.accNo= :accNo AND t.transactionDate BETWEEN :startDate AND :endDate") })
public class TransactionBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "txnIdSeq")
	@GenericGenerator(name = "txnIdSeq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "txnid_sequence"),
			@Parameter(name = "initial_value", value = "4"), @Parameter(name = "increment_size", value = "1") })

	// @SequenceGenerator(name="txnIdSeq", sequenceName = "txnId_Seq",
	// allocationSize=10)
	@Column(name = "TRANS_ID", length = 10)
	private int transactionId;

	@Column(name = "TRANS_TYPE", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	@Column(name = "TRANS_DATE_TIME", nullable = false, length = 20)
	private LocalDateTime transactionDate;

	@Column(name = "AMOUNT", nullable = false, length = 10)
	private BigDecimal transactionAmount;

	@Column(name = "TRANS_MODE", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private TransactionMode transactionMode;

	@Column(name = "TRANS_DESC", nullable = false, length = 40)
	private String transactionDescription;

	@Column(name = "REFERENCE_ID", length = 20)
	private String referenceId;

	@ManyToOne
	private AccountBean account;
	private BigDecimal trxBalance;

	public TransactionBean(int transactionId, TransactionType transactionType, LocalDateTime transactionDate,
			BigDecimal transactionAmount, TransactionMode transactionMode, String transactionDescription,
			String referenceId, AccountBean account) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.transactionMode = transactionMode;
		this.transactionDescription = transactionDescription;
		this.referenceId = referenceId;
		this.account = account;
	}

	public TransactionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTransactionId() {
		return transactionId;
	}

	public BigDecimal getTrxBalance() {
		return trxBalance;
	}

	public void setTrxBalance(BigDecimal trxBalance) {
		this.trxBalance = trxBalance;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public TransactionMode getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public AccountBean getAccount() {
		return account;
	}

	public void setAccount(AccountBean account) {
		this.account = account;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

}