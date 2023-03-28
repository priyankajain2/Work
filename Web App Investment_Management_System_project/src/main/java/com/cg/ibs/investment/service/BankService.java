package com.cg.ibs.investment.service;
//Bank Service Interface with all the methods 

import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.exception.IBSException;

public interface BankService {
	public boolean updateGoldPrice(Double goldPrice) throws IBSException;

	public boolean updateSilverPrice(Double silverPrice) throws IBSException;

	public void addMF(BankMutualFund mutualFund) throws IBSException;

	public boolean validateBank(String userId, String password) throws IBSException;

	void updateNav(Integer mfPlanId, Double nav) throws IBSException;

	void updateMinDir(Integer mfPlanId, Double amt) throws IBSException;

	void updateMinSip(Integer mfPlanId, Double amt) throws IBSException;

	void updateSipStatus(Integer mfPlanId, Boolean status) throws IBSException;

	void updateDirStatus(Integer mfPlanId, Boolean status) throws IBSException;

	Boolean removeMF(Integer mfPlanId) throws IBSException;

	
}