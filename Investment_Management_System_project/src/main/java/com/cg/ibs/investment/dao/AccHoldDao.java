package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.AccountHoldingBean;

public interface AccHoldDao {
	AccountHoldingBean addAccountHold(AccountHoldingBean accHold);

	AccountHoldingBean updateAccountHold(AccountHoldingBean accHold);

	AccountHoldingBean getAccountByAccNo(Long aHId);

	List<AccountHoldingBean> getAllAccounts();

	boolean removeAccountHold(Long aHId);
}
