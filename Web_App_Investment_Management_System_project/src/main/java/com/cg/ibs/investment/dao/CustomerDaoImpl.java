package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.CustomerBean;

@Repository("cs")
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;

	public CustomerBean addCustomer(CustomerBean cust) {
		entityManager.persist(cust);
		return cust;
	}

	public CustomerBean updateCustomer(CustomerBean cust) {
		return entityManager.merge(cust);
	}

	public CustomerBean getCustByUci(BigInteger uci) {
		return entityManager.find(CustomerBean.class, uci);
	}

	public List<CustomerBean> getAllCustomerBeans() {
		CriteriaQuery<CustomerBean> query = entityManager.getCriteriaBuilder().createQuery(CustomerBean.class);
		Root<CustomerBean> CustomerBeanRoot = query.from(CustomerBean.class);
		query.select(CustomerBeanRoot);

		return entityManager.createQuery(query).getResultList();
	}

	public boolean removeCustomerBean(BigInteger uci) {
		boolean isDeleted = false;
		CustomerBean CustomerBean = getCustByUci(uci);
		if (null != CustomerBean) {
			entityManager.remove(CustomerBean);
			isDeleted = true;
		}
		return isDeleted;
	}

	public BigInteger getUciByUserId(String userId) {

		TypedQuery<CustomerBean> query = (TypedQuery<CustomerBean>) entityManager.createNamedQuery("getUciByUserId",
				CustomerBean.class);
		query.setParameter(1, userId);
		BigInteger uci = null;
		try {
			CustomerBean cs = query.getSingleResult();
			uci = cs.getUci();
		} catch (NoResultException e) {

		}

		return uci;
	}

}
