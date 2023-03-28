package com.cg.ibs.investment.dao;
import java.util.HashMap;
import com.cg.ibs.common.bean.TransactionBean;
import com.cg.ibs.investment.bean.*;
import com.cg.ibs.investment.exception.IBSException;

public interface ClientDao {
	double viewGoldPrice();
	double viewSilverPrice();
	InvestmentBean viewInvestments(String userId) throws IBSException;
	HashMap<String, MutualFund> viewMF();
	void updateTransaction(String userId, TransactionBean trxn);
	boolean validateCustomer (String userId,String password);
}