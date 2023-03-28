package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.CustomerBean;

public interface CustomerDao {

	CustomerBean addCustomer(CustomerBean cust);

	CustomerBean updateCustomer(CustomerBean cust);

	CustomerBean getCustByUci(BigInteger uci);

	List<CustomerBean> getAllCustomerBeans();

	boolean removeCustomerBean(BigInteger uci);
	
	BigInteger getUciByUserId(String userId);

}
