package com.cg.ibs.investment.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.bean.InvestmentBean;
import com.cg.ibs.investment.bean.InvestmentTransaction;
import com.cg.ibs.investment.bean.MFType;
import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.bean.ViewInvestmentBean;
import com.cg.ibs.investment.exception.IBSException;
import com.cg.ibs.investment.service.CustomerService;

@RestController
public class CustomerController {
	private String userId = "somebody";

	@Autowired
	private CustomerService customerService;

	/*
	 * @RequestMapping("/customer") public ModelAndView showDeptsHome() { return new
	 * ModelAndView("customerLogin"); }
	 */
	@RequestMapping(value = "/custLogin/{userId}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> customerLogin(@PathVariable String userId,
			@PathVariable String password) {

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		try {
			if (customerService.validateCustomer(userId, password)) {
				responseEntity = new ResponseEntity<String>("User Logged in", HttpStatus.OK);
				customerService.autoSip(userId);
			} else {
				String msg = "No Such User exists";
				responseEntity = new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

			}
		} catch (IBSException e) {

			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
		return responseEntity;
	}

	@GetMapping("/viewMyInvestment")
	public ResponseEntity<ViewInvestmentBean> viewMyInvestments() {

		ViewInvestmentBean invBean = new ViewInvestmentBean();
		Set<MutualFund> dirset = new HashSet<MutualFund>();
		Set<MutualFund> sipset = new HashSet<MutualFund>();
		try {
			InvestmentBean bean = customerService.viewInvestments("user1");
			System.out.println(bean.getUCI());
			invBean.setUci(bean.getUCI());
			invBean.setAccountNumber(bean.getAccount().getAccNo());
			invBean.setGoldUnits(bean.getGoldunits());
			invBean.setBalance(bean.getAccount().getBalance());
			invBean.setSilverUnits(bean.getSilverunits());

			for (MutualFund mf : bean.getFunds()) {
				if (mf.getType() == MFType.DIRECT) {
					dirset.add(mf);
				} else {
					sipset.add(mf);
				}
			}
			invBean.setDirFunds(dirset);
			invBean.setSipfunds(sipset);

		} catch (IBSException e) {

		}
		return new ResponseEntity<ViewInvestmentBean>(invBean, HttpStatus.OK);
	}

	@PostMapping("/directInvest/{userId}/{mfPlanId}/{mfAmount}")
	public ResponseEntity<String> investDirect(@PathVariable String userId, @PathVariable Integer mfPlanId,
			@PathVariable Double mfAmount) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		try {
			customerService.investDirMF(mfAmount, userId, mfPlanId);
			entity = new ResponseEntity<String>("Direct Investment Bought successfully", HttpStatus.OK);
		} catch (IBSException e) {
			System.out.println(e.getMessage());
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return entity;
	}

	@PostMapping("/buyGold/{userId}/{gUnits}")
	public ResponseEntity<String> buyGold(@PathVariable String userId, @PathVariable Double gUnits) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		try {
			customerService.buyGold(gUnits, userId);
			entity=new ResponseEntity<String>("You successfully completed your gold purchase", HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity ;
	}
	

	@PostMapping("/buySilver/{userId}/{sUnits}")
	public ResponseEntity<String> buySilver(@PathVariable String userId, @PathVariable Double sUnits) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		try {
			customerService.buySilver(sUnits, userId);
			entity=new ResponseEntity<String>("You successfully completed your silver purchase", HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@PostMapping("/sellGold/{userId}/{gUnits}")
	public ResponseEntity<String> sellGold(@PathVariable String userId, @PathVariable Double gUnits) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		try {
			customerService.sellGold(gUnits, userId);
			entity= new ResponseEntity<String>("You successfully sold your gold units", HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@PostMapping("/sellSilver/{userId}/{sUnits}")
	public ResponseEntity<String> sellSilver(@PathVariable String userId, @PathVariable Double sUnits) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		
		try {
			customerService.sellSilver(sUnits, userId);
			entity=new ResponseEntity<String>("You successfully sold your silver units", HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}


	@PostMapping("/investSipMf/{userId}/{mfPlanId}")
	public ResponseEntity<String> investSip(@PathVariable String userId, @RequestBody MutualFund fund,
			@PathVariable Integer mfPlanId) {
		ResponseEntity<String> entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		try {
			BankMutualFund bankMutualFund = customerService.viewMFPlans().get(mfPlanId);
			fund.setBankMutualFund(bankMutualFund);
			customerService.investSipMF(userId, fund);
			entity=new ResponseEntity<String>("You successfully invested in the Mutual fund", HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@GetMapping("/viewSipMf")
	public ResponseEntity<List<BankMutualFund>> viewSIPMfPlans() {
		List<BankMutualFund> sipList = null;
		ResponseEntity<List<BankMutualFund>> entity=new ResponseEntity<List<BankMutualFund>>(HttpStatus.OK);
		try {
			HashMap<Integer, BankMutualFund> bkmap = customerService.viewMFPlans();
			List<BankMutualFund> bankList = new ArrayList<BankMutualFund>(bkmap.values());
			sipList = new ArrayList<BankMutualFund>();
			for (BankMutualFund bk : bankList) {
				if (bk.getSipStatus() == true) {
					sipList.add(bk);
				}
			}
			entity=new ResponseEntity<List<BankMutualFund>>(sipList, HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}
	@GetMapping("/viewTrans/{userId}")
	public ResponseEntity<List<InvestmentTransaction>> viewTrans(@PathVariable String userId) {
		List<InvestmentTransaction> transList = null;
		ResponseEntity<List<InvestmentTransaction>> entity = new ResponseEntity<List<InvestmentTransaction>>(HttpStatus.BAD_REQUEST);
		try {
			transList = customerService.getTransactions(userId);
			entity=new ResponseEntity<List<InvestmentTransaction>>(transList, HttpStatus.OK);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity ;
	}
	@GetMapping("/viewDirectMf")
	public ResponseEntity<List<BankMutualFund>> viewDirMfplans() {
		List<BankMutualFund> dirList = null;
		ResponseEntity<List<BankMutualFund>> entity=new ResponseEntity<List<BankMutualFund>>(HttpStatus.OK);
		try {
			HashMap<Integer, BankMutualFund> bkmap = customerService.viewMFPlans();
			List<BankMutualFund> bankList = new ArrayList<BankMutualFund>(bkmap.values());
			dirList = new ArrayList<BankMutualFund>();
			for (BankMutualFund bk : bankList) {
				if (bk.getDirStatus() == true) {
					dirList.add(bk);
				}
			}
			entity=new ResponseEntity<List<BankMutualFund>>(dirList, HttpStatus.OK);
		} catch (IBSException e) {
		}
		return entity;
	}

	@PostMapping("/withdrawDirMf/{userId}/{folioNumber}")
	public ResponseEntity<String> withdrawDirMf(@PathVariable String userId, @PathVariable Integer folioNumber) {
		String message = null;
		ResponseEntity<String> entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		try {
			Set<MutualFund> mutual = customerService.viewInvestments(userId).getFunds();
		    Map<Integer, MutualFund> dirMap=new HashMap<Integer, MutualFund>();
			for (MutualFund mutualFund : mutual) {
				if(mutualFund.getType().compareTo(MFType.DIRECT)==0) {
				dirMap.put(mutualFund.getFolioNumber(), mutualFund);
			}
				}
				if (dirMap.containsKey(folioNumber)) {
						customerService.withdrawDirMF(userId, dirMap.get(folioNumber));
						message = "Direct Mutual Fund successfully withdrawn";
						entity=new ResponseEntity<String>(message, HttpStatus.OK);
				}else {
					entity=new ResponseEntity<String>("No Mutual Fund found", HttpStatus.BAD_REQUEST);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	@PostMapping("/withdrawSipMf/{userId}/{folioNumber}")
	public ResponseEntity<String> withdrawSipMf(@PathVariable String userId, @PathVariable Integer folioNumber) {
		String message = null;
		ResponseEntity<String> entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		 Map<Integer, MutualFund> sipMap=new HashMap<Integer, MutualFund>();
		try {
			Set<MutualFund> mutual = customerService.viewInvestments(userId).getFunds();
			for (MutualFund mutualFund : mutual) {
				if(mutualFund.getType().compareTo(MFType.SIP)==0) {
				sipMap.put(mutualFund.getFolioNumber(), mutualFund);
				}
			}
				if (sipMap.containsKey(folioNumber)) {
						customerService.withdrawSipMF(userId, sipMap.get(folioNumber));
						message = "SIP Mutual Fund successfully withdrawn";
						entity=new ResponseEntity<String>(message, HttpStatus.OK);
				}else {
					entity=new ResponseEntity<String>("No such SIP exists",HttpStatus.BAD_REQUEST);
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	@PostMapping("linkAccount/{accNum}/{userId}")
	public ResponseEntity<String> linkAccount(@PathVariable BigInteger accNum, @PathVariable String userId){
		ResponseEntity<String> entity=new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		try {
			customerService.linkMyAccount(accNum, userId);
			entity=new ResponseEntity<String>("Account Linked successfully", HttpStatus.OK);
		} catch (IBSException e) {
			entity=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	

}


