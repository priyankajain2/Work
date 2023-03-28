package com.cg.ibs.investment.bean;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="gold_price")
@NamedQueries({
@NamedQuery(name ="viewgoldprice", query = "select g from GoldPrice g WHERE updateDate = ( SELECT MAX(g.updateDate) FROM GoldPrice g)")
})
public class GoldPrice implements Serializable {
	@Id
	private LocalDate updateDate;
	@Column(precision = 2)
	private Double goldPrice;
	public GoldPrice() {
		super();
	}
	public LocalDate getDate() {
		return updateDate;
	}
	public void setDate(LocalDate date) {
		this.updateDate = date;
	}
	public Double getGoldPrice() {
		return goldPrice;
	}
	public void setGoldPrice(Double goldPrice) {
		this.goldPrice = goldPrice;
	}
	

}