package com.cg.ibs.investment.service;


import java.util.HashMap;

import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.exception.IBSException;

public interface ClientService {
	public HashMap<String, MutualFund> viewMFPlans();
	public double viewGoldPrice();
	public double viewSilverPrice();
	public void buyGold(double gunits, String userId) throws IBSException;
	public void sellGold(double gunits,String userId) throws IBSException;
	public void buySilver(double sunits,String userId) throws IBSException;
	public void sellSilver(double sunits,String userId) throws IBSException;
	public void investMF(double mfAmount,String userId, String mfId) throws IBSException;
	public void withdrawMF(double  mfAmount,String userId, String mfId) throws IBSException;
	public InvestmentBean viewInvestments(String userId)throws IBSException;
	public boolean validateCustomer(String userId,String password) throws IBSException;
}
