package com.cg.ibs.investment.service;

import java.time.LocalDate;

import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ibs.investment.bean.BankAdmins;
import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.dao.BankAdminsDao;
import com.cg.ibs.investment.dao.BankMutualFundDao;
import com.cg.ibs.investment.dao.GoldPriceDao;
import com.cg.ibs.investment.dao.SilverPriceDao;
import com.cg.ibs.investment.exception.ErrorMessages;
import com.cg.ibs.investment.exception.IBSException;

@Service("bankservice")
public class BankServiceImpl implements BankService {
	static Logger log = Logger.getLogger(BankServiceImpl.class.getName());
	
	/*
	GoldPriceDao golDao = new GoldPriceDaoImpl() ;
	SilverPriceDao silDao = new SilverPriceDaoImpl();
	
	BankAdminsDao baObject=new BankAdminsDaoImpl();

	BankMutualFundDao bkDao = new BankMutualFundDaoImpl();
	*/
	private GoldPriceDao golDao  ;
	private SilverPriceDao silDao;
	
	private BankAdminsDao baObject;

	private BankMutualFundDao bkDao;
	private CustomerService service;
	/*
	@Autowired
	private GoldPriceDao golDao ;
	@Autowired
	private SilverPriceDao silDao;
	@Autowired
	private BankAdminsDao baObject;
	@Autowired
	private BankMutualFundDao bkDao;
	*/
	
	@Autowired
	public void setService(CustomerService service) {
		this.service = service;
	}
	@Autowired
	public void setGolDao(GoldPriceDao golDao) {
		this.golDao = golDao;
	}
	@Autowired
	public void setSilDao(SilverPriceDao silDao) {
		this.silDao = silDao;
	}
	@Autowired
	public void setBaObject(BankAdminsDao baObject) {
		this.baObject = baObject;
	}
	@Autowired
	public void setBkDao(BankMutualFundDao bkDao) {
		this.bkDao = bkDao;
	}
	@Transactional
	public Boolean removeMF(Integer mfPlanId) throws IBSException {
		Boolean status=false;
		BankMutualFund bk=bkDao.getMfById(mfPlanId);
		if(bk!=null) {
		bk.setDirStatus(false);
		bk.setSipStatus(false);
		bk.setExpiryDate(LocalDate.now());
		bkDao.updateBankMutFund(bk);
		status=true;
		}else {
			
			throw new IBSException(ErrorMessages.INVALID_MFPLAN_MESSAGE);
		}
		
		
		return status;
	}
	// To check whether Gold/Silver price is valid
	public boolean isValidGoldSilver(double price) {
		boolean check = false;
		if (price > 0) {
			check = true;
		}
		log.info("Service Validates gold and silver price");
		return check;
	}

	// To check whether Mutual Fund is valid
	public boolean isValidMutualFund(BankMutualFund mutualFund) {
		boolean check = false;
		if (mutualFund.getNav() > 0) {
			check = true;
		}
		log.info("Service validates mutual fund");
		return check;

	}

	// To update Gold price
	@Transactional
	public boolean updateGoldPrice(Double goldPrice) throws IBSException {
		boolean status = false;
		if (isValidGoldSilver(goldPrice)) {

		

			status = golDao.addGoldPrice(goldPrice);
			
		} else {
			log.error("Gold Price not updated");
			throw new IBSException(ErrorMessages.INVALID_PRICE_MESSAGE);

		}
		return status;

	}

	// To update Silver price
	@Transactional
	public boolean updateSilverPrice(Double silverPrice) throws IBSException {
		boolean status = false;

		if (isValidGoldSilver(silverPrice)) {


			status = silDao.addSilverPrice(silverPrice);
			
		} else {
			log.error("Silver price not updated");
			throw new IBSException(ErrorMessages.INVALID_PRICE_MESSAGE);
		}
		return status;

	}

	// To validate login details of Bank representative
	public boolean validateBank(String userId, String password) throws IBSException {

		BankAdmins ba  = baObject.getBankById(userId);
		if (ba != null && userId.equals(ba.getAdminId())) {

			String correctPassword = ba.getPassword();
			if (password.equals(correctPassword)) {
				return true;

			}
		}
		log.error("Bank validated by service");
		return false;

	}
	@Transactional
	public void addMF(BankMutualFund mutualFund) throws IBSException {
		if (isValidMutualFund(mutualFund)) {
			mutualFund.setDirStatus(true);
			mutualFund.setLaunchDate(LocalDate.now());
			bkDao.addBankMutFund(mutualFund);
			
		} else {
			log.error("Mutual Fund not added");
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}

	}
	@Transactional
	public void updateNav(Integer mfPlanId, Double nav) throws IBSException {
		if(service.viewMFPlans().get(mfPlanId)!=null) {
		if (isValidGoldSilver(nav)) {

			

			BankMutualFund fund = bkDao.getMfById(mfPlanId);
			fund.setNav(nav);
			
		} else {
			log.error("NOT A VALID nav VALUE");
			throw new IBSException(ErrorMessages.VALID_NAV);

		}
	}else {
		throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
	}

	}
	@Transactional
	public void updateMinDir(Integer mfPlanId, Double amt) throws IBSException {
		if(service.viewMFPlans().get(mfPlanId)!=null) {
		if (isValidGoldSilver(amt)) {

			BankMutualFund fund = bkDao.getMfById(mfPlanId);
			fund.setMinAmtDir(amt);;
			
		} else {
			log.error("NOT A VALID AMOUNT VALUE");
			throw new IBSException(ErrorMessages.INVALID_AMOUNT_MESSAGE);

		}
		}else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}
	}
	@Transactional
	public void updateMinSip(Integer mfPlanId, Double amt) throws IBSException {
		if(service.viewMFPlans().get(mfPlanId)!=null) {
		if (isValidGoldSilver(amt)) {

			BankMutualFund fund = bkDao.getMfById(mfPlanId);
			fund.setMinAmtSip(amt);;
			
		} else {
			log.error("NOT A VALID nav VALUE");
			throw new IBSException(ErrorMessages.VALID_NAV);

		}
		}else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}
	}
	@Transactional
	public void updateSipStatus(Integer mfPlanId, Boolean status) throws IBSException {
		
			if(service.viewMFPlans().get(mfPlanId)!=null) {

			BankMutualFund fund = bkDao.getMfById(mfPlanId);
			fund.setSipStatus(status);
			}else {
				throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
			}
		
	}
	@Transactional
	public void updateDirStatus(Integer mfPlanId, Boolean status) throws IBSException {
		

		if(service.viewMFPlans().get(mfPlanId)!=null) {

			BankMutualFund fund = bkDao.getMfById(mfPlanId);
			fund.setDirStatus(status);
		}else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}
		

	}
}