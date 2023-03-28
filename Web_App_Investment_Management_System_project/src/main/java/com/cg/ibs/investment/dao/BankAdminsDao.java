package com.cg.ibs.investment.dao;

import com.cg.ibs.investment.bean.BankAdmins;

public interface BankAdminsDao {
	BankAdmins addBankAdmins(BankAdmins id);

	BankAdmins getBankById(String id);

}
