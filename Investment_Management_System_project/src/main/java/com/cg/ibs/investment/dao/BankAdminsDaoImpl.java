package com.cg.ibs.investment.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.ibs.investment.bean.BankAdmins;

@Repository("baObject")
public class BankAdminsDaoImpl  implements BankAdminsDao{
	@PersistenceContext
	private EntityManager entityManager;

	
	public BankAdmins addBankAdmins(BankAdmins bank) {
		entityManager.persist(bank);
		return bank;
	}

	public BankAdmins getBankById(String userId) {
		System.out.println(userId);
		return entityManager.find(BankAdmins.class, userId);
	}

}
