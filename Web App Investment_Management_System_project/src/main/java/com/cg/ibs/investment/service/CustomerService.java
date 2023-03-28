package com.cg.ibs.investment.service;
//Customer Service Interface with all the methods 

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.InvestmentTransaction;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.exception.IBSException;

public interface CustomerService {
	public HashMap<Integer, BankMutualFund> viewMFPlans() throws IBSException;

	public double viewGoldPrice() throws IBSException;

	public double viewSilverPrice() throws IBSException;

	public void buyGold(double gunits, String userId) throws IBSException;

	public void sellGold(double gunits, String userId) throws IBSException;

	public void buySilver(double sunits, String userId) throws IBSException;

	public void sellSilver(double sunits, String userId) throws IBSException;

	public void investDirMF(double mfAmount, String userId, Integer mfId) throws IBSException;

	public void withdrawDirMF(String userId, MutualFund mutualFund) throws IBSException;

	public InvestmentBean viewInvestments(String userId) throws IBSException;

	public boolean validateCustomer(String userId, String password) throws IBSException ;

	public List<InvestmentTransaction> getTransactions(String userId) throws IBSException;

	public ArrayList<AccountBean> getAccountList(String userId) throws IBSException;

	void linkMyAccount(BigInteger accountNumber, String userId) throws IBSException;

	void investSipMF(String userId, MutualFund mutualFund) throws IBSException;

	void withdrawSipMF(String userId, MutualFund mutualFund) throws IBSException;

	List<InvestmentTransaction> getPeriodicStmt(LocalDateTime startDate, LocalDateTime endDate, BigInteger accNo)
			throws IBSException;

	Boolean autoSip(String userId) throws IBSException;

	Set<MutualFund> getSipMf(String userId) throws IBSException;

	Set<MutualFund> getDirectMf(String userId) throws IBSException;

}
