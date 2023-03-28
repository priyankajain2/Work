package com.cg.ibs.investment.dao;
import java.util.Map;

import com.cg.ibs.investment.bean.*;
import com.cg.ibs.investment.exception.IBSException;

public interface BankDao {
	 void updateGoldPrice(double x) throws IBSException;
	 void updateSilverPrice(double y) throws IBSException;
	 void updateMF(MutualFund mutualFund);
	
}
