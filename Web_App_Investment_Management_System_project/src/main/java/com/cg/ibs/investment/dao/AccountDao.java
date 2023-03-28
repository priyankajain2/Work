package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.AccountBean;

public interface AccountDao {
	AccountBean addAccount(AccountBean account);

	AccountBean updateAccount(AccountBean account);

	AccountBean getAccountByAccNo(BigInteger accNo);

	List<AccountBean> getAllAccounts();

	boolean removeAccount(BigInteger accNo);

	List<AccountBean> getAccByUci(BigInteger uci);

}
