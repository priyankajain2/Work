package com.cg.ibs.investment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ibs.investment.bean.BankMutualFund;
import com.cg.ibs.investment.exception.IBSException;
import com.cg.ibs.investment.service.BankService;
import com.cg.ibs.investment.service.CustomerService;

@RestController
public class BankController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private BankService bankService;
	
	@PostMapping("/bankLogin/{userId}/{password}")
	public ResponseEntity<String> bankLogin(@PathVariable String userId, @PathVariable String password){
		Boolean status = null;
		try {
			status = bankService.validateBank(userId, password);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		if(status) {
			return new ResponseEntity<>("welcome",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Invalid Username or Password",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/viewGPrice")
	public ResponseEntity<Double> viewGPrice(){
		ResponseEntity<Double> entity=new ResponseEntity<Double>(HttpStatus.BAD_GATEWAY);
		try {
			entity= new ResponseEntity<>(customerService.viewGoldPrice() ,HttpStatus.OK );
		} catch (IBSException e) {
			entity=new ResponseEntity<Double>(HttpStatus.CONFLICT);
		}
		return entity;
	}
	
	@GetMapping("/viewSPrice")
	public ResponseEntity<Double> viewSPrice(){
		ResponseEntity<Double> entity=new ResponseEntity<Double>(HttpStatus.BAD_REQUEST);
		try {
			entity= new ResponseEntity<>(customerService.viewSilverPrice() ,HttpStatus.OK );
		} catch (IBSException e) {
			entity= new ResponseEntity<>(HttpStatus.CONFLICT );
		}
		return entity;
	}
	
	@PostMapping("/updateGPrice/{gPrice}")
	public ResponseEntity<String> updateGPrice(@PathVariable Double gPrice){
		ResponseEntity<String> entity = null;
		try {
			Boolean result;
			result = bankService.updateGoldPrice(gPrice);
			if(result) {
				 entity = new ResponseEntity<>("Gold Price updated successfully",HttpStatus.OK);
			}else {
				entity =  new ResponseEntity<>("Gold Price is already updated today",HttpStatus.OK);
			}
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	@PostMapping("/updateSPrice/{sPrice}")
	public ResponseEntity<String> updateSPrice(@PathVariable Double sPrice){
		ResponseEntity<String> entity = null;
		try {
			Boolean result;
			result = bankService.updateSilverPrice(sPrice);
			if(result) {
				 entity = new ResponseEntity<>("Silver Price updated successfully",HttpStatus.OK);
			}else {
				entity =  new ResponseEntity<>("Silver Price is already updated today",HttpStatus.OK);
			}
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@GetMapping("/viewMf")
	public ResponseEntity<HashMap<Integer, BankMutualFund>> viewMf(){
		HashMap<Integer, BankMutualFund> mutualFunds = null;
		try {
			mutualFunds = customerService.viewMFPlans();
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<HashMap<Integer,BankMutualFund>>(mutualFunds,HttpStatus.OK);
	}
	
	@PostMapping("/addMf")
	public ResponseEntity<String> addMf(@RequestBody BankMutualFund bankMutualFund){
		try {
			bankService.addMF(bankMutualFund);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("You successfully added a Mutual Fund", HttpStatus.OK);
	}
	@PutMapping("/updateNav/{mfPlanId}/{nav}")
	public ResponseEntity<String> updateNav(@PathVariable Integer mfPlanId, @PathVariable Double nav){
		try {
			bankService.updateNav(mfPlanId, nav);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully updated Nav of the Mutual Fund plan",HttpStatus.OK);
	}
	
	@PutMapping("/updateSipStatus/{mfPlanId}/{sipStatus}")
	public ResponseEntity<String> updateSipStatus(@PathVariable Integer mfPlanId, @PathVariable Boolean sipStatus){
		
		try {
			bankService.updateSipStatus(mfPlanId, sipStatus);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully updated SIP status of the selected Mutual Fund",HttpStatus.OK);
	}
	
	@PutMapping("/updateDirStatus/{mfPlanId}/{dirStatus}")
	public ResponseEntity<String> updateDirStatus(@PathVariable Integer mfPlanId, @PathVariable Boolean dirStatus){
		
		try {
			bankService.updateDirStatus(mfPlanId, dirStatus);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully updated DIR status of the selected Mutual Fund",HttpStatus.OK);
	}
	
	@PutMapping("/updateMinDirAmt/{mfPlanId}/{minAmtDir}")
	public ResponseEntity<String> updateMinDirAmt(@PathVariable Integer mfPlanId, @PathVariable Double minAmtDir){
		try {
			bankService.updateMinDir(mfPlanId, minAmtDir);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully updated minimum amount for Direct Investment for the selected Mutual Fund",HttpStatus.OK);
	}
	
	@PutMapping("/updateMinSipAmt/{mfPlanId}/{minAmtSip}")
	public ResponseEntity<String> updateMinSipAmt(@PathVariable Integer mfPlanId, @PathVariable Double minAmtSip){
		try {
			bankService.updateMinSip(mfPlanId, minAmtSip);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully updated minimum amount for SIP Investment for the selected Mutual Fund",HttpStatus.OK);
	}
	
	@PatchMapping("/removeMf/{mfPlanId}")
	public ResponseEntity<String> removeMf(@PathVariable Integer mfPlanId){
		try {
			bankService.removeMF(mfPlanId);
		} catch (IBSException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("You successfully removed the Mutual Fund plan",HttpStatus.OK);
	}
}
