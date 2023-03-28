package com.cg.ibs.investment;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.ibs.investment.bean.AccountBean;
import com.cg.ibs.investment.bean.AccountHoldingBean;
import com.cg.ibs.investment.bean.AccountHoldingType;
import com.cg.ibs.investment.bean.AccountStatus;
import com.cg.ibs.investment.bean.AccountType;
import com.cg.ibs.investment.bean.CustomerBean;
import com.cg.ibs.investment.bean.Gender;
import com.cg.ibs.investment.service.AdditionService;

@SpringBootApplication
public class InvestmentSprint7Application {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentSprint7Application.class, args);
		
		
	}
	

}
