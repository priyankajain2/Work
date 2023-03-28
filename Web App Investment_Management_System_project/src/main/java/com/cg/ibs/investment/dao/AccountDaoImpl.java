package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.bean.GoldPrice;
@Repository("accDao")
public class AccountDaoImpl implements AccountDao {
	@PersistenceContext
	private EntityManager entityManager;

	

	public AccountBean addAccount(AccountBean account) {
		entityManager.persist(account);
		return account;
	}

	public AccountBean updateAccount(AccountBean account) {
		return entityManager.merge(account);
	}

	public AccountBean getAccountByAccNo(BigInteger accNo) {
		return entityManager.find(AccountBean.class, accNo);
	}

	public List<AccountBean> getAllAccounts() {
		CriteriaQuery<AccountBean> query = entityManager.getCriteriaBuilder().createQuery(AccountBean.class);
		Root<AccountBean> root = query.from(AccountBean.class);
		query.select(root);

		return entityManager.createQuery(query).getResultList();
	}

	public boolean removeAccount(BigInteger accNo) {
		boolean isDeleted = false;
		AccountBean bean = getAccountByAccNo(accNo);
		if (null != bean) {
			entityManager.remove(bean);
			isDeleted = true;
		}
		return isDeleted;
	}
	public List<AccountBean> getAccByUci(BigInteger uci) {
		TypedQuery<AccountBean> query = (TypedQuery<AccountBean>) entityManager.createNamedQuery("getAccByUci",AccountBean.class);
	   query.setParameter(1, uci);
	   List<AccountBean> list=query.getResultList();
		return list;
	}
	

}
