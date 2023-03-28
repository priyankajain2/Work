package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.BankMutualFund;

public interface BankMutualFundDao {
	BankMutualFund addBankMutFund(BankMutualFund mf);

	BankMutualFund updateBankMutFund(BankMutualFund mf);

	BankMutualFund getMfById(Integer mfPlanId);

	List<BankMutualFund> getAllBankMutualFunds();

	boolean removeBankMutualFund(Integer mfPlanId);

}
