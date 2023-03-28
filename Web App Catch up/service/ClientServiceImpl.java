package com.cg.ibs.investment.service;
//import com.cg.ibs.investment.exception;

import java.util.HashMap;

//import java.util.HashMap;

import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.dao.ClientDao;
import com.cg.ibs.investment.dao.InvestmentDaoImpl;
import com.cg.ibs.investment.exception.IBSException;

public class ClientServiceImpl implements ClientService {
	ClientDao clientdao = new InvestmentDaoImpl();

	@Override
	public HashMap<String, MutualFund> viewMFPlans() {
		return (clientdao.viewMF());
	}

	@Override
	public double viewGoldPrice() {
		return (clientdao.viewGoldPrice());

	}

	@Override
	public double viewSilverPrice() {
		return (clientdao.viewSilverPrice());

	}

	@Override
	public void buyGold(double gunits, String userId) throws IBSException {
		if (gunits > 0) {
			InvestmentBean investmentBean = clientdao.viewInvestments(userId);
			if (investmentBean.getBalance() >= gunits * clientdao.viewGoldPrice()) {

				investmentBean.setGoldunits(investmentBean.getGoldunits() + gunits);
				investmentBean.setBalance(investmentBean.getBalance() - gunits * clientdao.viewGoldPrice());

			} else {
				
				throw new IBSException("Insufficient balance in your account");
			}

		} else {
			throw new InvalidUnitsException("Please enter a valid number of Gold units");
		}
	}

	@Override
	public void sellGold(double gunits, String userId) throws IBSException {
		if (gunits > 0) {
			InvestmentBean investmentBean = clientdao.viewInvestments(userId);

			investmentBean.setGoldunits(investmentBean.getGoldunits() - gunits);
			investmentBean.setBalance(investmentBean.getBalance() + gunits * clientdao.viewGoldPrice());

		} else {
			throw new IBSException("Please enter a valid number of Gold units");
		}

	}

	@Override
	public void buySilver(double sunits, String userId)  throws IBSException  {

		if (sunits > 0) {
			InvestmentBean investmentBean = clientdao.viewInvestments(userId);
			if (investmentBean.getBalance() >= sunits * clientdao.viewSilverPrice()) {

				investmentBean.setSilverunits(investmentBean.getSilverunits() + sunits);
				investmentBean.setBalance(investmentBean.getBalance() - sunits * clientdao.viewSilverPrice());

			} else {
				throw new IBSException("Insufficient balance in your account");
			}

		} else {
			throw new IBSException("Please enter a valid number of Silver units");
		}

	}

	@Override
	public void sellSilver(double sunits, String userId)  throws IBSException {
		if (sunits > 0) {
			InvestmentBean investmentBean = clientdao.viewInvestments(userId);

			investmentBean.setSilverunits(investmentBean.getSilverunits() - sunits);
			investmentBean.setBalance(investmentBean.getBalance() + sunits * clientdao.viewSilverPrice());

		} else {
			throw new IBSException("Please enter a valid number of Silver units");
		}
	}

	@Override
	public void investMF(double mfAmount, String userId, String mfId)  throws IBSException {
		if (mfAmount > 0) {
			if (clientdao.viewMF().containsKey(mfId)) {
				InvestmentBean investmentBean = clientdao.viewInvestments(userId);
				double nav = clientdao.viewMF().get(mfId).getNav();
				if (investmentBean.getBalance() >= mfAmount) {
					if(investmentBean.getFunds().containsKey(mfId)){
					double mfunits=investmentBean.getFunds().get(mfId).getMfunits()+(mfAmount / nav);
					investmentBean.getFunds().get(mfId).setMfunits(mfunits);
					
					
					investmentBean.setBalance(investmentBean.getBalance() - mfAmount);}
					else{
						
						investmentBean.getFunds().put(mfId, new MutualFund(mfId,nav,0));
						double mfunits=investmentBean.getFunds().get(mfId).getMfunits()+(mfAmount / nav);
						investmentBean.getFunds().get(mfId).setMfunits(mfunits);
						
						
						investmentBean.setBalance(investmentBean.getBalance() - mfAmount);}
						
					

				} else {
					throw new IBSException("Insufficient balance in your account");
				}
			}
		} else {
			throw new IBSException("Please enter a valid Amount");
		}
	}

	@Override
	public void withdrawMF(double mfamount, String userId, String mfId) throws IBSException  {
		if (mfamount > 0) {
			InvestmentBean investmentBean = clientdao.viewInvestments(userId);
			if (investmentBean.getFunds().containsKey(mfId)) {
				
				double nav = clientdao.viewMF().get(mfId).getNav();
				double mfunits=investmentBean.getFunds().get(mfId).getMfunits() - mfamount / nav;
				investmentBean.getFunds().get(mfId).setMfunits(mfunits);

				investmentBean.setBalance(investmentBean.getBalance() + mfamount);
			}
		} else {
			throw new IBSException("Please enter a valid amount");
		}

	}

	@Override
	public InvestmentBean viewInvestments(String userId) throws IBSException {
		if(clientdao.viewInvestments(userId)!=null){
		return clientdao.viewInvestments(userId);}
		else{
			throw new IBSException("Account not available");
		}

	}

	@Override
	public boolean validateCustomer(String userId, String password) throws IBSException {
		if(clientdao.viewInvestments(userId)!=null){
		if (userId.equals(clientdao.viewInvestments(userId).getUserId())) {

			String correctPassword = clientdao.viewInvestments(userId).getPassword();
			if (password.equals(correctPassword)) {
				return true;
			}
		}
		}
		else{
			throw new IBSException("Invalid Username or Password");
		}
		return false;

	}

}
