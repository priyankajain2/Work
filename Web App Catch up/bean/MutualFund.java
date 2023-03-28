package com.cg.ibs.investment.bean;

public class MutualFund {
	private String id;
	private double nav;
	private double mfunits;
	public MutualFund(){
		
	}
	
	public MutualFund(String id, double nav, int mfunits) {
		super();
		this.id = id;
		this.nav = nav;
		this.mfunits = mfunits;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getNav() {
		return nav;
	}

	public void setNav(double nav) {
		this.nav = nav;
	}

	public double getMfunits() {
		return mfunits;
	}

	public void setMfunits(double mfunits) {
		this.mfunits = mfunits;
	}

	@Override
	public String toString() {
		return "MutualFund [id=" + id + ", nav=" + nav + ", mfunits=" + mfunits + "]";
	}
	
}
