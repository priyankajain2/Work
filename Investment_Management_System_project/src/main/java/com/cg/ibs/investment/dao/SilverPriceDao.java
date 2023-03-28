package com.cg.ibs.investment.dao;

import java.time.LocalDate;

import com.cg.ibs.investment.bean.SilverPrice;

public interface SilverPriceDao {

	Boolean addSilverPrice(Double price);

	
	SilverPrice getPriceByDate(LocalDate dt);
	Double viewSilverPrice();

	

}
