package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.MutualFund;

public interface MutualFundDao {

	MutualFund addMutualFund(MutualFund mf);

	MutualFund updateMutualFund(MutualFund mf);

	MutualFund getMutualFundById(Integer mfId);

	List<MutualFund> getAllMutualFunds();

	boolean removeMutualFund(Integer mfId);

}
