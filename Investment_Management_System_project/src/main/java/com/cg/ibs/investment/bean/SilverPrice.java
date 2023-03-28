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
@Table(name="silver_price")
@NamedQueries({
@NamedQuery(name ="viewsilverprice", query = "select g from SilverPrice g WHERE updateDate = ( SELECT MAX(g.updateDate) FROM SilverPrice g)")
})
public class SilverPrice implements Serializable {

	@Id
	private LocalDate updateDate;
	@Column(precision = 2)
	private Double silverPrice;
	
	public SilverPrice() {
		super();
	}
	public LocalDate getDate() {
		return updateDate;
	}
	public void setDate(LocalDate date) {
		this.updateDate = date;
	}
	public Double getSilverPrice() {
		return silverPrice;
	}
	public void setSilverPrice(Double silverPrice) {
		this.silverPrice = silverPrice;
	}
	
	
}
