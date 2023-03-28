package com.cg.ibs.investment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.MutualFund;
@Repository("mfDao")
public class MutualFundDaoImpl implements MutualFundDao {
	@PersistenceContext
	private EntityManager entityManager;

	
	public MutualFund addMutualFund(MutualFund mf) {
		entityManager.persist(mf);
		return mf;
	}

	public MutualFund updateMutualFund(MutualFund mf) {
		return entityManager.merge(mf);
	}

	public MutualFund getMutualFundById(Integer mfId) {
		return entityManager.find(MutualFund.class, mfId);
	}

	public List<MutualFund> getAllMutualFunds() {
		CriteriaQuery<MutualFund> query = entityManager.getCriteriaBuilder().createQuery(MutualFund.class);
		Root<MutualFund> root = query.from(MutualFund.class);
		query.select(root);

		return entityManager.createQuery(query).getResultList();
	}

	public boolean removeMutualFund(Integer mfId) {
		boolean isDeleted = false;
		MutualFund bean = getMutualFundById(mfId);
		if (null != bean) {
			entityManager.remove(bean);
			isDeleted = true;
		}
		return isDeleted;
	}

}
