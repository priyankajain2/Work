package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.InvestmentTransaction;

@Repository("trxDao")
public class InvestmentTransactionDaoImpl implements InvestmentTransactionDao {
	@PersistenceContext
	private EntityManager entityManager;

@Autowired
private AccountDao accDao;

	public InvestmentTransaction getInvestmentTrxById(Integer id) {
		return entityManager.find(InvestmentTransaction.class, id);
	}

	public List<InvestmentTransaction> getAllInvestmentTrx() {
		CriteriaQuery<InvestmentTransaction> query = entityManager.getCriteriaBuilder()
				.createQuery(InvestmentTransaction.class);
		Root<InvestmentTransaction> root = query.from(InvestmentTransaction.class);
		query.select(root);

		return entityManager.createQuery(query).getResultList();
	}

	public List<InvestmentTransaction> getTransactionByAcc(BigInteger accNo) {
		//
		AccountBean account = accDao.getAccountByAccNo(accNo);
		TypedQuery<InvestmentTransaction> query = (TypedQuery<InvestmentTransaction>) entityManager
				.createNamedQuery("getTransactions", InvestmentTransaction.class);
		query.setParameter(1, account);
		List<InvestmentTransaction> invtrxnList = query.getResultList();
		return invtrxnList;

	}

	public List<InvestmentTransaction> getPeriodicTransactions(LocalDateTime startDate, LocalDateTime endDate,
			BigInteger accNo) {
		//AccountDao acd = new AccountDaoImpl();
		AccountBean account = accDao.getAccountByAccNo(accNo);
		List<InvestmentTransaction> tranList = null;
		TypedQuery<InvestmentTransaction> query = entityManager.createNamedQuery("GET_PERIODIC",
				InvestmentTransaction.class);
		query.setParameter("accNo", accNo);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		tranList = query.getResultList();
		// logger.info(" Periodic statement returned");
		return tranList;
	}
}
