
	package com.cg.ibs.investment.dao;
	import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
	import java.util.HashMap;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	import java.math.BigDecimal;
	import java.math.BigInteger;
	import java.time.LocalDate;

	import com.cg.ibs.common.bean.TransactionBean;
	import com.cg.ibs.common.bean.TransactionType;
	import com.cg.ibs.investment.bean.InvestmentBean;
	import com.cg.ibs.investment.bean.MutualFund;
	import com.cg.ibs.investment.exception.IBSException;

	public class InvestmentDaoImpl implements BankDao, ClientDao {
		
		private static double goldPrice;
		private static double silverPrice;
		private LocalDate date;
		private static HashMap<String,MutualFund> mutualFunds=new HashMap<>();
		private static HashMap<String,MutualFund> mutualFundscust1=new HashMap<>();
		private static HashMap<String,MutualFund> mutualFundscust2=new HashMap<>();
		private static HashMap<String, InvestmentBean> investmentBeans=new HashMap<>();
		private HashMap<String, String> userIDMap=new HashMap<>();
		public static List<TransactionBean> transactionBeans=new ArrayList<TransactionBean>();
		
		static {
			MutualFund hdfc=new MutualFund("HDFC",250,0);
			MutualFund sbi=new MutualFund("SBI",300,0);
			MutualFund icici=new MutualFund("ICICI",450,0);
			mutualFunds.put("HDFC", hdfc);
			mutualFunds.put("SBI", sbi);
			mutualFunds.put("ICICI", icici);
			mutualFundscust1.put("HDFC", new MutualFund("HDFC",250,150));
			mutualFunds.put("ICICI", new MutualFund("ICICI",250,100));			
			LocalDate date;
			
			TransactionBean trxn1=new TransactionBean(new BigInteger("100100100"), TransactionType.CREDIT, LocalDate.now() , new BigDecimal("2000"));
			TransactionBean trxn2=new TransactionBean(new BigInteger("100100100"),TransactionType.DEBIT , LocalDate.now() ,new BigDecimal("2000") );
			transactionBeans.add(trxn1);
			transactionBeans.add(trxn2);
			
		
			InvestmentBean cust1=new InvestmentBean("4100101", "Sachin", "mumbai", 220.0, 2000.0, 50000.0, mutualFundscust1, transactionBeans);
			InvestmentBean cust2=new InvestmentBean("4100102", "Gautam", "delhi", 300.0, 3000.0, 40000.0, mutualFundscust2, transactionBeans);	
			investmentBeans.put("Sachin", cust1);
			investmentBeans.put("Gautam", cust2);
			
			goldPrice=35000;
			silverPrice=29000;
					
		}

		@Override
		public double viewGoldPrice() {
			
			return goldPrice;
		}

		@Override
		public double viewSilverPrice() {
			
			return silverPrice;
		}

		@Override
		public InvestmentBean viewInvestments(String uCI)throws IBSException {
			
			return investmentBeans.get(uCI);
		}

		@Override
		public HashMap<String, MutualFund> viewMF() {
			
			return mutualFunds ;
		}

		@Override
		public void updateTransaction(String uCI, TransactionBean trxn) {
			
			investmentBeans.get(uCI).getTransactionList().add(trxn);
			
		}

		@Override
		public void updateGoldPrice(double x) throws IBSException {
			this.goldPrice=x;
			
		}

		@Override
		public void updateSilverPrice(double y) throws IBSException {
			this.silverPrice=y;
			
		}

		@Override
		public void updateMF(MutualFund mutualFund) {
			mutualFunds.put(mutualFund.getId(), mutualFund);
			
		}

		@Override
		public boolean validateCustomer(String userId, String password) {
			// TODO Auto-generated method stub
			return false;
		}
		

}
