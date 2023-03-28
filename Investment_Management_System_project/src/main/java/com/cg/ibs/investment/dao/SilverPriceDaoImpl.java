package com.cg.ibs.investment.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.SilverPrice;
@Repository("silDao")
public class SilverPriceDaoImpl implements SilverPriceDao {
	@PersistenceContext
	private EntityManager entityManager;

	

	public Boolean addSilverPrice(Double price) {
		boolean status = false;
		TypedQuery<SilverPrice> query = (TypedQuery<SilverPrice>) entityManager.createNamedQuery("viewsilverprice",
				SilverPrice.class);

		SilverPrice temp = (SilverPrice) query.getSingleResult();
		if (temp != null) {

			if (!temp.getDate().equals(LocalDate.now())) {
				SilverPrice silverPrice = new SilverPrice();
				silverPrice.setDate(LocalDate.now());
				silverPrice.setSilverPrice(price);				
				entityManager.persist(silverPrice);				
				status = true;
			}
		}

		return status;
	}

	public SilverPrice getPriceByDate(LocalDate dt) {
		return entityManager.find(SilverPrice.class, dt);
	}

	public Double viewSilverPrice() {
		TypedQuery<SilverPrice> query = (TypedQuery<SilverPrice>) entityManager.createNamedQuery("viewsilverprice",
				SilverPrice.class);
		SilverPrice temp = (SilverPrice) query.getSingleResult();
		Double price = temp.getSilverPrice();
		return price;

	}
}
