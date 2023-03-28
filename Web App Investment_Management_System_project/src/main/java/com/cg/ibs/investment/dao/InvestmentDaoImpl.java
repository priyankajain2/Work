package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.InvestmentBean;
@Repository("invdao")
public class InvestmentDaoImpl implements InvestmentDao {
	@PersistenceContext
	private EntityManager entityManager;

	
	public InvestmentBean addInvestment(InvestmentBean inv) {
		entityManager.persist(inv);
		return inv;
	}

	public InvestmentBean updateInvestment(InvestmentBean inv) {
		return entityManager.merge(inv);
	}

	public InvestmentBean getInvestmentByUci(BigInteger uci) {
		return entityManager.find(InvestmentBean.class, uci);
	}

	public List<InvestmentBean> getAllInvestmentBeans() {
		CriteriaQuery<InvestmentBean> query = entityManager.getCriteriaBuilder().createQuery(InvestmentBean.class);
		Root<InvestmentBean> root = query.from(InvestmentBean.class);
		query.select(root);

		return entityManager.createQuery(query).getResultList();
	}

	public boolean removeInvestmentBean(BigInteger uci) {
		boolean isDeleted = false;
		InvestmentBean bean = getInvestmentByUci(uci);
		if (null != bean) {
			entityManager.remove(bean);
			isDeleted = true;
		}
		return isDeleted;
	}

}
