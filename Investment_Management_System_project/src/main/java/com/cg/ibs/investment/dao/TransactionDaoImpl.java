package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.TransactionBean;
@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao {
	@PersistenceContext
	private EntityManager entityManager;


	public TransactionBean addTransaction(TransactionBean trxn) {
		entityManager.persist(trxn);
		return trxn;
	}

	public List<TransactionBean> getAllTransactionByAccno(BigInteger accno) {
		CriteriaQuery<TransactionBean> query = entityManager.getCriteriaBuilder().createQuery(TransactionBean.class);
		Root<TransactionBean> root = query.from(TransactionBean.class);
		query.select(root);

		return entityManager.createQuery(query).getResultList();
	}

}
