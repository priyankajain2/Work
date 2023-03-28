package com.cg.ibs.investment.service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityTransaction;

import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.dao.CustomerDao;
import com.cg.ibs.investment.dao.CustomerDaoImpl;
import com.cg.ibs.investment.exception.IBSException;



public class CSIMPL implements CS{

	private CustomerDao custDao;
	
	public CSIMPL() {
		custDao=new CustomerDaoImpl();
	}
	/*
	public CustomerBean addCustomer(CustomerBean cust) {
		//after validations
		EntityTransaction txn = JPAUtil.getTransaction();
		txn.begin();
		CustomerBean savedCustomerBean=custDao.addCustomer(cust);
		txn.commit();
		return savedCustomerBean;
	}

	public CustomerBean updateCustomer(CustomerBean cust) {
		//after validations
		EntityTransaction txn = JPAUtil.getTransaction();
		txn.begin();
		CustomerBean savedCustomerBean=custDao.updateCustomer(cust);
		txn.commit();
		return savedCustomerBean;
	}

	public CustomerBean getCustomerByUci(BigInteger uci) {
		return custDao.getCustByUci(uci);
	}

	public List<CustomerBean> getAllCustomers() {
		return custDao.getAllCustomerBeans();
	}

	public boolean removeCustomer(BigInteger uci) {
		EntityTransaction txn = JPAUtil.getTransaction();
		txn.begin();
		boolean isDeleted = custDao.removeCustomerBean(uci);
		txn.commit();
		return isDeleted;
	}

	public boolean validateCustomer(String userId, String password) throws IBSException {
		
		return false;
	}
	
*/

	@Override
	public CustomerBean addCustomer(CustomerBean cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerBean updateCustomer(CustomerBean cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerBean getCustomerByUci(BigInteger uci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCustomer(BigInteger uci) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateCustomer(String userId, String password) throws IBSException {
		// TODO Auto-generated method stub
		return false;
	}
	

}
