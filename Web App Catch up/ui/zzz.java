package com.cg.ibs.investment.ui;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.ibs.common.bean.TransactionBean;
import com.cg.ibs.common.bean.TransactionType;
import com.cg.ibs.investment.dao.ClientDao;
import com.cg.ibs.investment.dao.InvestmentDaoImpl;

public class zzz {
public static void main(String[] args) {
	List<TransactionBean> transactionBeans=new ArrayList<TransactionBean>();
	TransactionBean trxn1=new TransactionBean(new BigInteger("100100100"), TransactionType.CREDIT, LocalDate.now() , new BigDecimal("2000"));
	TransactionBean trxn2=new TransactionBean(new BigInteger("100100100"),TransactionType.DEBIT , LocalDate.now() ,new BigDecimal("2000") );
	transactionBeans.add(trxn1);
	transactionBeans.add(trxn2);
	System.out.println(transactionBeans.toString());
	HashMap<Integer,String>hash=new HashMap<>();
	hash.put(10, "manvi");
	hash.put(10, "kaustubh");
	
	System.out.println(hash.values());
	String userId="manvi";
	ClientDao clientdao = new InvestmentDaoImpl();
	System.out.println(userId.equals(clientdao.viewInvestments(userId).getUserId()));
	
}
}
