package com.cg.ibs.investment.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.exception.IBSException;

public interface CS {

	CustomerBean addCustomer(CustomerBean cust);
	CustomerBean updateCustomer(CustomerBean cust);
	CustomerBean getCustomerByUci(BigInteger uci);
	List<CustomerBean> getAllCustomers();
	boolean removeCustomer(BigInteger uci);
	public boolean validateCustomer(String userId, String password) throws IBSException ;

}
