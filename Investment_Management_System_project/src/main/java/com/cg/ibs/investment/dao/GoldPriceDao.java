package com.cg.ibs.investment.dao;

import java.time.LocalDate;

import com.cg.ibs.investment.bean.GoldPrice;

public interface GoldPriceDao {
	Boolean addGoldPrice(Double price);

	GoldPrice getPriceByDate(LocalDate dt);
	Double viewGoldPrice(); 

}
