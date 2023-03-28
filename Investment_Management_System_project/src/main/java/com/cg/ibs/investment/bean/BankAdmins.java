package com.cg.ibs.investment.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bank_Admins")
public class BankAdmins implements Serializable {
    
    @Id
    @Column(name = "admin_id", nullable = false)
    String adminId;
    @Column(name = "password", nullable = false)
    String password;
	public BankAdmins() {
		super();
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}