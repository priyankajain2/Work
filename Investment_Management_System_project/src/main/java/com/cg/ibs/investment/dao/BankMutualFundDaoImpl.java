package com.cg.ibs.investment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.BankMutualFund;
@Repository("bkDao")
public class BankMutualFundDaoImpl implements BankMutualFundDao {
	@PersistenceContext
	private EntityManager entityManager;

	

	public BankMutualFund addBankMutFund(BankMutualFund mf) {
		entityManager.persist(mf);
		return mf;
	}

	public BankMutualFund updateBankMutFund(BankMutualFund mf) {
		return entityManager.merge(mf);
	}

	public BankMutualFund getMfById(Integer mfPlanId) {
		return entityManager.find(BankMutualFund.class, mfPlanId);
	}

	public List<BankMutualFund> getAllBankMutualFunds() {
		CriteriaQuery<BankMutualFund> query = entityManager.getCriteriaBuilder().createQuery(BankMutualFund.class);
		Root<BankMutualFund> Root = query.from(BankMutualFund.class);
		query.select(Root);

		return entityManager.createQuery(query).getResultList();
	}

	public boolean removeBankMutualFund(Integer mfPlanId) {
		boolean isDeleted = false;
		BankMutualFund bankMutualFund = getMfById(mfPlanId);
		if (null != bankMutualFund) {
			entityManager.remove(bankMutualFund);
			isDeleted = true;
		}
		return isDeleted;
	}

}
