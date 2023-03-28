package com.cg.ibs.investment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.AccountHoldingBean;

@Repository("accHoldDao")
public class AccHoldDaoImpl implements AccHoldDao {
	@PersistenceContext
	private EntityManager entityManager;

	
	public AccountHoldingBean addAccountHold(AccountHoldingBean accHold) {		
		entityManager.persist(accHold);
		return accHold;
	}

	public AccountHoldingBean updateAccountHold(AccountHoldingBean accHold) {
		
		return null;
	}

	public AccountHoldingBean getAccountByAccNo(Long aHId) {
		
		return null;
	}

	public List<AccountHoldingBean> getAllAccounts() {
		
		return null;
	}

	public boolean removeAccountHold(Long aHId) {
		// TODO Auto-generated method stub
		return false;
	}

}
