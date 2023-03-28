package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.TransactionBean;

public interface TransactionDao {

	TransactionBean addTransaction(TransactionBean trxn);

	List<TransactionBean> getAllTransactionByAccno(BigInteger accno);

}
