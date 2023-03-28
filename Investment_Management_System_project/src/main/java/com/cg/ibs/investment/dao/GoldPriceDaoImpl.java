package com.cg.ibs.investment.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.GoldPrice;
@Repository("golDao")
public class GoldPriceDaoImpl implements GoldPriceDao {
	@PersistenceContext
	private EntityManager entityManager;

	public Boolean addGoldPrice(Double price) {
		boolean status = false;
		TypedQuery<GoldPrice> query = (TypedQuery<GoldPrice>) entityManager.createNamedQuery("viewgoldprice",GoldPrice.class);
		
		GoldPrice temp = (GoldPrice) query.getSingleResult();
		if(temp != null) {
			
			if (!temp.getDate().equals( LocalDate.now())) {
				GoldPrice goldPrice = new GoldPrice();
				goldPrice.setDate(LocalDate.now());
				goldPrice.setGoldPrice(price);				
				entityManager.persist(goldPrice);			
				status = true;
			}
		}
		
		return status;
	}

	public GoldPrice getPriceByDate(LocalDate dt) {
		return entityManager.find(GoldPrice.class, dt);
	}

	public Double viewGoldPrice() {
		TypedQuery<GoldPrice> query = (TypedQuery<GoldPrice>) entityManager.createNamedQuery("viewgoldprice",GoldPrice.class);
		GoldPrice temp = (GoldPrice) query.getSingleResult();
		Double price = temp.getGoldPrice();
		return price;

	}

}
