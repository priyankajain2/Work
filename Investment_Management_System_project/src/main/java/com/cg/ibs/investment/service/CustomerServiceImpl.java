package com.cg.ibs.investment.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.bean.Frequency;
import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.InvestmentTransaction;
import com.cg.ibs.investment.bean.MFType;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.bean.TransactionBean;
import com.cg.ibs.investment.bean.TransactionMode;
import com.cg.ibs.investment.bean.TransactionType;
import com.cg.ibs.investment.dao.AccountDao;
import com.cg.ibs.investment.dao.AccountDaoImpl;
import com.cg.ibs.investment.dao.BankMutualFundDao;
import com.cg.ibs.investment.dao.BankMutualFundDaoImpl;
import com.cg.ibs.investment.dao.CustomerDao;
import com.cg.ibs.investment.dao.CustomerDaoImpl;
import com.cg.ibs.investment.dao.GoldPriceDao;
import com.cg.ibs.investment.dao.GoldPriceDaoImpl;
import com.cg.ibs.investment.dao.InvestmentDao;
import com.cg.ibs.investment.dao.InvestmentDaoImpl;
import com.cg.ibs.investment.dao.InvestmentTransactionDao;
import com.cg.ibs.investment.dao.InvestmentTransactionDaoImpl;
import com.cg.ibs.investment.dao.MutualFundDao;
import com.cg.ibs.investment.dao.MutualFundDaoImpl;
import com.cg.ibs.investment.dao.SilverPriceDao;
import com.cg.ibs.investment.dao.SilverPriceDaoImpl;
import com.cg.ibs.investment.exception.ErrorMessages;
import com.cg.ibs.investment.exception.IBSException;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static final Logger log = Logger.getLogger(CustomerServiceImpl.class);

	private BankMutualFundDao bkDao;

	private GoldPriceDao golDao;

	private SilverPriceDao silDao;

	private CustomerDao cs;

	private InvestmentDao invdao;

	private MutualFundDao mfDao;

	private AccountDao accDao;

	private InvestmentTransactionDao trxDao;

	@Autowired
	public void setBkDao(BankMutualFundDao bkDao) {
		this.bkDao = bkDao;
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
	public void setCs(CustomerDao cs) {
		this.cs = cs;
	}

	@Autowired
	public void setInvdao(InvestmentDao invdao) {
		this.invdao = invdao;
	}

	@Autowired
	public void setMfDao(MutualFundDao mfDao) {
		this.mfDao = mfDao;
	}

	@Autowired
	public void setAccDao(AccountDao accDao) {
		this.accDao = accDao;
	}

	@Autowired
	public void setTrxDao(InvestmentTransactionDao trxDao) {
		this.trxDao = trxDao;
	}

	@Override
	public HashMap<Integer, BankMutualFund> viewMFPlans() throws IBSException {

		List<BankMutualFund> bmf = bkDao.getAllBankMutualFunds();
		HashMap<Integer, BankMutualFund> bankMutualFund = new HashMap<>();
		for (BankMutualFund t : bmf) {
			bankMutualFund.put(t.getMfPlanId(), t);
		}
		log.info("Mutual Fund Plans Succesfully Received");
		return bankMutualFund;
	}

	@Override
	public double viewGoldPrice() throws IBSException {

		Double price = golDao.viewGoldPrice();
		log.info("Gold Price Returned");
		return price;
	}

	@Override
	public double viewSilverPrice() throws IBSException {

		Double price = silDao.viewSilverPrice();
		log.info("Silver Price Returned");
		return price;

	}

	@Override
	@Transactional
	public void buyGold(double gunits, String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (gunits > 0) {
			if (inv != null) {
				Double balance = Double.parseDouble(inv.getAccount().getBalance().toString());
				if (balance > gunits * viewGoldPrice()) {

					inv.setGoldunits(gunits + inv.getGoldunits());
					AccountBean acc = inv.getAccount();

					BigDecimal amount = inv.getAccount().getBalance()
							.subtract(new BigDecimal(gunits * viewGoldPrice()));
					acc.setBalance(amount);
					Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
					InvestmentTransaction tBean = new InvestmentTransaction();
					tBean.setTransactionAmount(new BigDecimal(gunits * viewGoldPrice()));
					tBean.setTransactionDate(LocalDateTime.now());
					tBean.setAccount(inv.getAccount());
					tBean.setTransactionDescription("gold is bought");
					tBean.setTransactionMode(TransactionMode.ONLINE);
					tBean.setTransactionType(TransactionType.DEBIT);
					tBean.setTrxBalance(amount);
					tBean.setUnits(gunits);
					tBean.setPricePerUnit(viewGoldPrice());
					tBeans.add(tBean);
					invdao.updateInvestment(inv);

				} else {
					log.error(ErrorMessages.INSUFF_BALANCE_MESSAGE);
					throw new IBSException(ErrorMessages.INSUFF_BALANCE_MESSAGE);
				}

			}
			log.info("Service buys gold");
		} else {
			log.error("Invalid units");
			throw new IBSException(ErrorMessages.INVALID_UNITS_MESSAGE);

		}
	}

	@Override
	@Transactional
	public void sellGold(double gunits, String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (gunits > 0) {
			if (inv != null) {
				Double units = inv.getGoldunits();
				if (units > gunits) {

					inv.setGoldunits(inv.getGoldunits() - gunits);
					AccountBean acc = inv.getAccount();

					BigDecimal amount = inv.getAccount().getBalance().add(new BigDecimal(gunits * viewGoldPrice()));
					acc.setBalance(amount);
					Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
					InvestmentTransaction tBean = new InvestmentTransaction();
					// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
					tBean.setTransactionAmount(new BigDecimal(gunits * viewGoldPrice()));
					tBean.setTransactionDate(LocalDateTime.now());
					tBean.setAccount(inv.getAccount());
					tBean.setTransactionDescription("gold is sold");
					tBean.setTrxBalance(amount);
					tBean.setTransactionMode(TransactionMode.ONLINE);
					tBean.setTransactionType(TransactionType.CREDIT);
					tBean.setUnits(gunits);
					tBean.setPricePerUnit(viewGoldPrice());
					tBeans.add(tBean);
					invdao.updateInvestment(inv);

				} else {
					log.error(ErrorMessages.INSUFF_GOLD_UNITS);
					throw new IBSException(ErrorMessages.INSUFF_GOLD_UNITS);
				}
			}
			log.info("Service sells gold");
		} else {
			log.error(ErrorMessages.INVALID_UNITS_MESSAGE);
			throw new IBSException(ErrorMessages.INVALID_UNITS_MESSAGE);
		}
	}

	@Override
	@Transactional
	public void buySilver(double sunits, String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (sunits > 0) {
			if (inv != null) {
				Double balance = Double.parseDouble(inv.getAccount().getBalance().toString());
				if (balance > sunits * viewSilverPrice()) {

					inv.setSilverunits(sunits + inv.getSilverunits());
					AccountBean acc = inv.getAccount();

					BigDecimal amount = inv.getAccount().getBalance()
							.subtract(new BigDecimal(sunits * viewSilverPrice()));
					acc.setBalance(amount);
					Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
					InvestmentTransaction tBean = new InvestmentTransaction();
					// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
					tBean.setTransactionAmount(new BigDecimal(sunits * viewSilverPrice()));
					tBean.setTransactionDate(LocalDateTime.now());
					tBean.setAccount(inv.getAccount());
					tBean.setTransactionDescription("Silver is bought");
					tBean.setTrxBalance(amount);
					tBean.setTransactionMode(TransactionMode.ONLINE);
					tBean.setTransactionType(TransactionType.DEBIT);
					tBean.setUnits(sunits);
					tBean.setPricePerUnit(viewSilverPrice());
					tBeans.add(tBean);
					invdao.updateInvestment(inv);

				} else {
					log.error(ErrorMessages.INSUFF_BALANCE_MESSAGE);
					throw new IBSException(ErrorMessages.INSUFF_BALANCE_MESSAGE);
				}

			}
			log.info("Service buys Silver");
		} else {
			log.error("Invalid units");
			throw new IBSException(ErrorMessages.INVALID_UNITS_MESSAGE);

		}
	}

	@Override
	@Transactional
	public void sellSilver(double sunits, String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (sunits > 0) {
			if (inv != null) {
				Double units = inv.getSilverunits();
				if (units > sunits) {

					inv.setSilverunits(inv.getSilverunits() - sunits);
					AccountBean acc = inv.getAccount();
					BigDecimal amount = inv.getAccount().getBalance().add(new BigDecimal(sunits * viewSilverPrice()));
					acc.setBalance(amount);
					Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
					InvestmentTransaction tBean = new InvestmentTransaction();
					// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
					tBean.setTransactionAmount(new BigDecimal(sunits * viewSilverPrice()));
					tBean.setTransactionDate(LocalDateTime.now());
					tBean.setAccount(inv.getAccount());
					tBean.setTrxBalance(amount);
					tBean.setTransactionDescription("silver is sold");
					tBean.setTransactionMode(TransactionMode.ONLINE);
					tBean.setTransactionType(TransactionType.CREDIT);
					tBean.setUnits(sunits);
					tBean.setPricePerUnit(viewSilverPrice());
					tBeans.add(tBean);
					invdao.updateInvestment(inv);

				} else {
					log.error(ErrorMessages.INSUFF_SILVER_UNITS);
					throw new IBSException(ErrorMessages.INSUFF_SILVER_UNITS);
				}

			}
			log.info("Service sells Silver");
		} else {
			log.error(ErrorMessages.INVALID_UNITS_MESSAGE);
			throw new IBSException(ErrorMessages.INVALID_UNITS_MESSAGE);
		}
	}

	@Override
	@Transactional
	public void investDirMF(double mfAmount, String userId, Integer mfPlanId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);
		if (viewMFPlans().get(mfPlanId) != null) {
			if (mfAmount >= viewMFPlans().get(mfPlanId).getMinAmtDir()) {
				if (viewMFPlans().containsKey(mfPlanId)) {

					InvestmentBean inv = invdao.getInvestmentByUci(uci);
					Double balance = Double.parseDouble(inv.getAccount().getBalance().toString());

					if (balance >= mfAmount) {

						MutualFund mutualFund = new MutualFund();
						mutualFund.setBankMutualFund(viewMFPlans().get(mfPlanId));
						mutualFund.setOpeningDate(LocalDate.now());
						mutualFund.setBuyDate(LocalDate.now());
						mutualFund.setMfAmount(mfAmount);
						mutualFund.setFolioNumber((int) Math.floor(Math.random() * 10000));
						Double mfUnits = mfAmount / (viewMFPlans().get(mfPlanId).getNav());
						mutualFund.setMfUnits(mfUnits);
						mutualFund.setStatus(true);
						mutualFund.setType(MFType.DIRECT);
						mutualFund.setInv(inv);
						BigDecimal amount = inv.getAccount().getBalance().subtract(new BigDecimal(mfAmount));
						inv.getAccount().setBalance(amount);
						inv.getFunds().add(mutualFund);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(mfAmount));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(amount);
						tBean.setTransactionDescription("invested in mutualfunds");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(mfUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mfPlanId).getNav());
						tBeans.add(tBean);
						invdao.updateInvestment(inv);

						log.info("Investment in MF successful");

					} else {
						log.error(ErrorMessages.INSUFF_BALANCE_MESSAGE);
						throw new IBSException(ErrorMessages.INSUFF_BALANCE_MESSAGE);
					}
				} else {
					log.error(ErrorMessages.INVALID_DETAILS_MESSAGE);
					throw new IBSException(ErrorMessages.INVALID_DETAILS_MESSAGE);
				}
			} else {
				log.error(ErrorMessages.INVALID_AMOUNT_MESSAGE);
				throw new IBSException(ErrorMessages.INVALID_MIN_AMOUNT);
			}
		} else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}

	}

	@Override
	@Transactional
	public Boolean autoSip(String userId) throws IBSException {

		Boolean status = false;
		LocalDate todayDate = LocalDate.now();
		BigInteger uci = cs.getUciByUserId(userId);
		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		Set<MutualFund> mfSet = inv.getFunds();
		ConcurrentHashMap<Integer, MutualFund> mfFunds=new ConcurrentHashMap<Integer, MutualFund>();
		for (MutualFund mf : mfSet) {
			mfFunds.put(mf.getFolioNumber(), mf);
		}
		
		MutualFund corrMf = new MutualFund();

		for (MutualFund mutualFund : mfFunds.values()) {
			mutualFund.getOpeningDate();
			Frequency freq = mutualFund.getFrequency();
			LocalDate dtOld = mutualFund.getNextInstallDate();
			if (freq != null && mutualFund.getClosingDate() == null) {
				switch (freq) {
				case DAILY:

					if (todayDate.compareTo(mutualFund.getNextInstallDate()) == 0) {

						Double amt = mutualFund.getMfAmount();
						BigDecimal newBal = inv.getAccount().getBalance().subtract(BigDecimal.valueOf(amt));
						inv.getAccount().setBalance(newBal);
						Double newUnits = amt
								/ viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
						mutualFund.setMfUnits(mutualFund.getMfUnits() + newUnits);
						mutualFund.setNextInstallDate(todayDate.plusDays(1));
						mutualFund.setInstallments(mutualFund.getInstallments() - 1);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						//tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(amt));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(newBal);
						tBean.setTransactionDescription("invested in mutualfunds sip");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(newUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav());
						tBeans.add(tBean);
						invdao.updateInvestment(inv);

					}
					break;
				case MONTHLY:

					if (todayDate.compareTo(mutualFund.getNextInstallDate()) == 0) {

						Double amt = mutualFund.getMfAmount();
						BigDecimal newBal = inv.getAccount().getBalance().subtract(BigDecimal.valueOf(amt));
						inv.getAccount().setBalance(newBal);
						Double newUnits = amt
								/ viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
						mutualFund.setMfUnits(mutualFund.getMfUnits() + newUnits);
						mutualFund.setNextInstallDate(todayDate.plusMonths(1));
						mutualFund.setInstallments(mutualFund.getInstallments() - 1);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						//tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(amt));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(newBal);
						tBean.setTransactionDescription("invested in mutualfunds sip");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(newUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav());
						tBeans.add(tBean);
						
						invdao.updateInvestment(inv);

					}
					break;

				case HALFYEARLY:
					if (todayDate.compareTo(mutualFund.getNextInstallDate()) == 0) {

						Double amt = mutualFund.getMfAmount();
						BigDecimal newBal = inv.getAccount().getBalance().subtract(BigDecimal.valueOf(amt));
						inv.getAccount().setBalance(newBal);
						Double newUnits = amt
								/ viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
						mutualFund.setMfUnits(mutualFund.getMfUnits() + newUnits);
						mutualFund.setNextInstallDate(todayDate.plusMonths(6));
						mutualFund.setInstallments(mutualFund.getInstallments() - 1);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						//tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(amt));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(newBal);
						tBean.setTransactionDescription("invested in mutualfunds sip");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(newUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav());
						tBeans.add(tBean);
						invdao.updateInvestment(inv);

					}
					break;

				case QUATERLY:
					if (todayDate.compareTo(mutualFund.getNextInstallDate()) == 0) {

						Double amt = mutualFund.getMfAmount();
						BigDecimal newBal = inv.getAccount().getBalance().subtract(BigDecimal.valueOf(amt));
						inv.getAccount().setBalance(newBal);
						Double newUnits = amt
								/ viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
						mutualFund.setMfUnits(mutualFund.getMfUnits() + newUnits);
						mutualFund.setNextInstallDate(todayDate.plusMonths(3));
						mutualFund.setInstallments(mutualFund.getInstallments() - 1);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						//tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(amt));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(newBal);
						tBean.setTransactionDescription("invested in mutualfunds sip");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(newUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav());
						tBeans.add(tBean);
						invdao.updateInvestment(inv);

					}
					break;

				case ANNUALLY:
					if (todayDate.compareTo(mutualFund.getNextInstallDate().plusYears(1)) == 0
							|| todayDate.compareTo(mutualFund.getOpeningDate()) == 0) {

						Double amt = mutualFund.getMfAmount();
						BigDecimal newBal = inv.getAccount().getBalance().subtract(BigDecimal.valueOf(amt));
						inv.getAccount().setBalance(newBal);
						Double newUnits = amt
								/ viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
						mutualFund.setMfUnits(mutualFund.getMfUnits() + newUnits);
						mutualFund.setNextInstallDate(todayDate);
						mutualFund.setInstallments(mutualFund.getInstallments() - 1);

						Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
						InvestmentTransaction tBean = new InvestmentTransaction();
						//tBean.setTransactionId((int) Math.round(Math.random() * 10000));
						tBean.setTransactionAmount(new BigDecimal(amt));
						tBean.setTransactionDate(LocalDateTime.now());
						tBean.setAccount(inv.getAccount());
						tBean.setTrxBalance(newBal);
						tBean.setTransactionDescription("invested in mutualfunds sip");
						tBean.setTransactionMode(TransactionMode.ONLINE);
						tBean.setTransactionType(TransactionType.DEBIT);
						tBean.setUnits(newUnits);
						tBean.setPricePerUnit(viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav());
						tBeans.add(tBean);
						invdao.updateInvestment(inv);

					}
					break;

				default:
					break;
				}
			}
		}

		return status;
	}
	@Override
	@Transactional
	public void investSipMF(String userId, MutualFund mutualFund) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		Double balance = Double.parseDouble(inv.getAccount().getBalance().toString());
		if(mutualFund.getOpeningDate().compareTo(LocalDate.now()) >= 0) {

		if (mutualFund.getBankMutualFund() != null) {
			if (balance >= mutualFund.getMfAmount()) {

				Double amount = mutualFund.getMfAmount();
				mutualFund.setBuyDate(LocalDate.now());

				mutualFund.setFolioNumber((int) Math.floor(Math.random() * 10000));
				mutualFund.setInstallments(mutualFund.getDuration());
				mutualFund.setNextInstallDate(mutualFund.getOpeningDate());
				mutualFund.setStatus(true);
				mutualFund.setMfUnits(new Double(0));
				mutualFund.setType(MFType.SIP);
				mutualFund.setInv(inv);
				inv.getFunds().add(mutualFund);
				mfDao.addMutualFund(mutualFund);
				invdao.updateInvestment(inv);

				log.info("Investment in MF successful");

			} else {
				log.error(ErrorMessages.INSUFF_BALANCE_MESSAGE);
				throw new IBSException(ErrorMessages.INSUFF_BALANCE_MESSAGE);
			}
		} else {
			throw new IBSException(ErrorMessages.INVALID_MF_MESSAGE);
		}
	}else {
		throw new IBSException(ErrorMessages.INVALID_STARTDATE);
	}

	}

	@Override
	@Transactional
	public void withdrawDirMF(String userId, MutualFund mutualFund) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (inv != null) {

			MutualFund mf = mfDao.getMutualFundById(mutualFund.getFolioNumber());
			mf.setClosingDate(LocalDate.now());
			mf.setStatus(false);
			Double mfAmount = mutualFund.getMfUnits()
					* viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
			BigDecimal amount = inv.getAccount().getBalance().add(new BigDecimal(mfAmount));
			inv.getAccount().setBalance(amount);
			Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
			InvestmentTransaction tBean = new InvestmentTransaction();
			// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
			tBean.setTransactionAmount(new BigDecimal(mfAmount));
			tBean.setTransactionDate(LocalDateTime.now());
			tBean.setAccount(inv.getAccount());
			tBean.setTrxBalance(amount);
			tBean.setTransactionDescription("mfPlan is withdrawn");
			tBean.setTransactionMode(TransactionMode.ONLINE);
			tBean.setTransactionType(TransactionType.CREDIT);
			tBean.setUnits(mutualFund.getMfUnits());
			tBean.setPricePerUnit(mf.getBankMutualFund().getNav());
			tBeans.add(tBean);
			invdao.updateInvestment(inv);
			log.info("MF withdrawn successfully");

		} else {
			log.error(ErrorMessages.INVALID_DETAILS_MESSAGE);
			throw new IBSException(ErrorMessages.INVALID_DETAILS_MESSAGE);
		}

	}

	@Override
	@Transactional
	public void withdrawSipMF(String userId, MutualFund mutualFund) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);
		if (inv != null) {

			MutualFund mf = mfDao.getMutualFundById(mutualFund.getFolioNumber());
			if (mf.getInstallments() == 0) {

				mf.setClosingDate(LocalDate.now());
				mf.setStatus(false);
				Double mfAmount = mutualFund.getMfUnits()
						* viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
				BigDecimal amount = inv.getAccount().getBalance().add(new BigDecimal(mfAmount));
				inv.getAccount().setBalance(amount);
				Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
				InvestmentTransaction tBean = new InvestmentTransaction();
				// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
				tBean.setTransactionAmount(new BigDecimal(mfAmount));
				tBean.setTransactionDate(LocalDateTime.now());
				tBean.setAccount(inv.getAccount());
				tBean.setTransactionDescription("mfPlan is withdrawn");
				tBean.setTransactionMode(TransactionMode.ONLINE);
				tBean.setTrxBalance(amount);
				tBean.setTransactionType(TransactionType.CREDIT);
				tBean.setUnits(mutualFund.getMfUnits());
				tBean.setPricePerUnit(mf.getBankMutualFund().getNav());
				tBeans.add(tBean);
				invdao.updateInvestment(inv);

				log.info("MF withdrawn successfully");
			} else {
				// Premature Sip Withdraw

				mf.setClosingDate(LocalDate.now());
				mf.setStatus(false);
				Double mfAmount = mutualFund.getMfUnits()
						* viewMFPlans().get(mutualFund.getBankMutualFund().getMfPlanId()).getNav();
				mfAmount = mfAmount * 0.95;
				BigDecimal amount = inv.getAccount().getBalance().add(new BigDecimal(mfAmount));
				inv.getAccount().setBalance(amount);
				Set<TransactionBean> tBeans = inv.getAccount().getTransaction();
				InvestmentTransaction tBean = new InvestmentTransaction();
				// tBean.setTransactionId((int) Math.round(Math.random() * 10000));
				tBean.setTransactionAmount(new BigDecimal(mfAmount));
				tBean.setTransactionDate(LocalDateTime.now());
				tBean.setAccount(inv.getAccount());
				tBean.setTransactionDescription("mfPlan is withdrawn");
				tBean.setTransactionMode(TransactionMode.ONLINE);
				tBean.setTrxBalance(amount);
				tBean.setTransactionType(TransactionType.CREDIT);
				tBean.setUnits(mutualFund.getMfUnits());
				tBean.setPricePerUnit(mf.getBankMutualFund().getNav());
				tBeans.add(tBean);
				invdao.updateInvestment(inv);

				log.info("MF withdrawn successfully");
				System.out.println("before SIP");
			}

		} else {
			log.error(ErrorMessages.INVALID_DETAILS_MESSAGE);
			throw new IBSException(ErrorMessages.INVALID_DETAILS_MESSAGE);
		}

	}

	@Override
	@Transactional
	public InvestmentBean viewInvestments(String userId) throws IBSException {
		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);

		for (MutualFund mf : inv.getFunds()) {
			if (mf.getType() == MFType.DIRECT) {
				mf.setMfAmount(mf.getMfUnits() * viewMFPlans().get(mf.getBankMutualFund().getMfPlanId()).getNav());
			} else {
				if (mf.getMfUnits() != 0) {
					mf.setMfAmount(mf.getMfUnits() * viewMFPlans().get(mf.getBankMutualFund().getMfPlanId()).getNav());
				} else {
					log.info("SIP not yet transacted");
				}
			}

		}

		log.info("Service calls for viewing investments");
		return inv;
	}

	@Override
	public boolean validateCustomer(String userId, String password) throws IBSException {
		boolean status=false;
		BigInteger uci = cs.getUciByUserId(userId);
		CustomerBean customer = new CustomerBean();
		if (uci != null) {
			customer = cs.getCustByUci(uci);

			if (customer != null && userId.equals(customer.getUserId())) {

				String correctPassword = customer.getPassword();
				if (password.equals(correctPassword)) {
					log.info("Customer Validated Successfully");
					status=true;
				}else {
					throw new IBSException(ErrorMessages.INVALID_USERNAME_MESSAGE);
				}
			}else {
				throw new IBSException(ErrorMessages.INSUFF_GOLD_UNITS);
			}
		}else {
			throw new IBSException(ErrorMessages.INTERNAL_ERROR);
			
		}
		return status;
	}

	@Override
	public List<InvestmentTransaction> getTransactions(String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);

		List<InvestmentTransaction> invtrnList = trxDao.getTransactionByAcc(inv.getAccount().getAccNo());
		List<InvestmentTransaction> lastTen = new ArrayList<InvestmentTransaction>();
		InvestmentTransaction trx = new InvestmentTransaction();
		for (int i = 1; i < 11; i++) {
			trx = invtrnList.get(invtrnList.size() - i);
			lastTen.add(trx);
		}

		return lastTen;

	}

	@Override
	public ArrayList<AccountBean> getAccountList(String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);
		ArrayList<AccountBean> list = new ArrayList<>();
		list = (ArrayList<AccountBean>) accDao.getAccByUci(uci);
		return list;
	}

	@Override
	@Transactional
	public void linkMyAccount(BigInteger accountNumber, String userId) throws IBSException {

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);

		AccountBean acc = accDao.getAccountByAccNo(accountNumber);
		inv.setAccount(acc);

	}

	@Override
	public List<InvestmentTransaction> getPeriodicStmt(LocalDateTime startDate, LocalDateTime endDate, BigInteger accNo)
			throws IBSException {
		List<InvestmentTransaction> transList = null;
		LocalDate startDate1 = startDate.toLocalDate();
		LocalDate endDate1 = endDate.toLocalDate();

		// Period period= Period.between(startDate1, endDate1);
		// int months = ((int) period.getDays()) / 30;
		long noOfDaysBetween = ChronoUnit.DAYS.between(startDate1, endDate1);
		int months = (int) (noOfDaysBetween / 30);
		// System.out.println(noOfDaysBetween);
		if (startDate.compareTo(endDate) < 0 && months <= 6 && startDate.compareTo(LocalDateTime.now()) < 0) {
			transList = trxDao.getPeriodicTransactions(startDate, endDate, accNo);
			// logger.info(" Periodic statement fetched");
		} else {
			throw new IBSException(ErrorMessages.INVALID_PERIOD);
		}
		return transList;
	}

	@Override
	public Set<MutualFund> getDirectMf(String userId) throws IBSException {
		Set<MutualFund> funds = viewInvestments(userId).getFunds();

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);

		Set<MutualFund> dirList = new HashSet<MutualFund>();
		InvestmentTransaction trx = new InvestmentTransaction();
		for (MutualFund mutualFund : funds) {
			if (mutualFund.getType() == MFType.DIRECT) {
				dirList.add(mutualFund);
			}
		}
		return dirList;

	}

	@Override
	public Set<MutualFund> getSipMf(String userId) throws IBSException {
		Set<MutualFund> funds = viewInvestments(userId).getFunds();

		BigInteger uci = cs.getUciByUserId(userId);

		InvestmentBean inv = invdao.getInvestmentByUci(uci);

		Set<MutualFund> dirList = new HashSet<MutualFund>();
		InvestmentTransaction trx = new InvestmentTransaction();
		for (MutualFund mutualFund : funds) {
			if (mutualFund.getType() == MFType.SIP) {
				dirList.add(mutualFund);
			}
		}
		return dirList;

	}

}
