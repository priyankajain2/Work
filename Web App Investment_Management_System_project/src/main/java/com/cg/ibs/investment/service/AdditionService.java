package com.cg.ibs.investment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.AccountHoldingBean;
import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.dao.AccHoldDao;
import com.cg.ibs.investment.dao.AccountDao;
import com.cg.ibs.investment.dao.BankMutualFundDao;
import com.cg.ibs.investment.dao.CustomerDao;
import com.cg.ibs.investment.dao.GoldPriceDao;
import com.cg.ibs.investment.dao.InvestmentDao;
import com.cg.ibs.investment.dao.InvestmentTransactionDao;
import com.cg.ibs.investment.dao.MutualFundDao;
import com.cg.ibs.investment.dao.SilverPriceDao;

@Service
public class AdditionService {
	private BankMutualFundDao bkDao;

	private GoldPriceDao golDao;

	private SilverPriceDao silDao;

	private CustomerDao cs;

	private InvestmentDao invdao;

	private MutualFundDao mfDao;

	private AccountDao accDao;

	private InvestmentTransactionDao trxDao;

	private AccHoldDao accHoldDao;
	
	@Autowired
	public void setAccHoldDao(AccHoldDao accHoldDao) {
		this.accHoldDao = accHoldDao;
	}

	@Autowired
	public void setBkDao(BankMutualFundDao bkDao) {
		this.bkDao = bkDao;
	}

	@Autowired
	public void setGolDao(GoldPriceDao golDao) {
		this.golDao = golDao;
	}

	@Autowired
	public void setSilDao(SilverPriceDao silDao) {
		this.silDao = silDao;
	}

	@Autowired
	public void setCs(CustomerDao cs) {
		this.cs = cs;
	}

	@Autowired
	public void setInvdao(InvestmentDao invdao) {
		this.invdao = invdao;
	}

	@Autowired
	public void setMfDao(MutualFundDao mfDao) {
		this.mfDao = mfDao;
	}

	@Autowired
	public void setAccDao(AccountDao accDao) {
		this.accDao = accDao;
	}

	@Autowired
	public void setTrxDao(InvestmentTransactionDao trxDao) {
		this.trxDao = trxDao;
	}
	@Transactional
	public CustomerBean addCustomer(CustomerBean cust) {
		
		CustomerBean savedCustomerBean=cs.addCustomer(cust);
		
		return savedCustomerBean;
	}
	@Transactional
	public AccountBean addAccount(AccountBean account) {
	
		AccountBean savedBean=accDao.addAccount(account);
	
		return savedBean;
	}
	@Transactional
	public Boolean addGoldPrice(Double price) {
		//after validations
		
		Boolean boll=golDao.addGoldPrice(price);
		
		return boll;
		
	}
	@Transactional
	public Boolean addSilverPrice(Double price) {
		
		Boolean boll=silDao.addSilverPrice(price);
		
		return boll;
	}
	
	@Transactional
	public MutualFund addMutualFund(MutualFund mf) {
	
		MutualFund savedBean=mfDao.addMutualFund(mf);
	
		return savedBean;
	}
	@Transactional
	public BankMutualFund addBankMutualFund(BankMutualFund fund) {
		
		BankMutualFund savedBean=bkDao.addBankMutFund(fund);
		
		return savedBean;
	}
	@Transactional
	public InvestmentBean addInvestment(InvestmentBean inv) {
		
		InvestmentBean savedBean=invdao.addInvestment(inv);
		
		return savedBean;
	}
	@Transactional
	public AccountHoldingBean addAccHold(AccountHoldingBean accHold) {
		
		AccountHoldingBean savedBean=accHoldDao.addAccountHold(accHold);
	
		return savedBean;
	}
	
	
}
