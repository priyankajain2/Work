package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import com.cg.ibs.investment.bean.InvestmentTransaction;

public interface InvestmentTransactionDao {

	InvestmentTransaction getInvestmentTrxById(Integer id);

	List<InvestmentTransaction> getAllInvestmentTrx();

	List<InvestmentTransaction> getTransactionByAcc(BigInteger accNo);

	List<InvestmentTransaction> getPeriodicTransactions(LocalDateTime startDate, LocalDateTime endDate,
			BigInteger accNo);

}
