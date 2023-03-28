package com.cg.ibs.investment.dao;

import java.math.BigInteger;
import java.util.List;

import com.cg.ibs.investment.bean.InvestmentBean;

public interface InvestmentDao {
	InvestmentBean addInvestment(InvestmentBean inv);

	InvestmentBean updateInvestment(InvestmentBean inv);

	InvestmentBean getInvestmentByUci(BigInteger uci);

	List<InvestmentBean> getAllInvestmentBeans();

	boolean removeInvestmentBean(BigInteger uci);

}
