package com.cg.ibs.investment.service;

import java.math.BigInteger;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.dao.AccountDao;
import com.cg.ibs.investment.dao.AccountDaoImpl;
import com.cg.ibs.investment.dao.BankMutualFundDao;
import com.cg.ibs.investment.dao.BankMutualFundDaoImpl;
import com.cg.ibs.investment.dao.CustomerDao;
import com.cg.ibs.investment.dao.CustomerDaoImpl;
import com.cg.ibs.investment.dao.MutualFundDao;
import com.cg.ibs.investment.dao.MutualFundDaoImpl;

public class FetchService {
	private AccountDao accountDao;
	private CustomerDao custDao;
	private BankMutualFundDao bankMutualFundDao;
	private MutualFundDao mutualFundDao;  
	
	public FetchService() {
		accountDao=new AccountDaoImpl();
		custDao=new CustomerDaoImpl();
		bankMutualFundDao=new BankMutualFundDaoImpl();
		mutualFundDao=new MutualFundDaoImpl();
	}
	
	public CustomerBean getCustomerByUci(BigInteger uci) {
		return custDao.getCustByUci(uci);
	}
	public AccountBean getAccByAccNum(BigInteger accNo) {
		return accountDao.getAccountByAccNo(accNo);
	}
	public BankMutualFund getBMFbyPlanId(Integer mfPlanId) {
		return bankMutualFundDao.getMfById(mfPlanId);
	}
	public MutualFund getMFbyId(Integer mfId) {
		return mutualFundDao.getMutualFundById(mfId);
	}
}
