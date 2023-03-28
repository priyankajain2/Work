package com.cg.ibs.investment.ui;

import java.util.Scanner;

import com.cg.ibs.investment.bean.MutualFund;
import com.cg.ibs.investment.exception.IBSException;
import com.cg.ibs.investment.service.BankService;
import com.cg.ibs.investment.service.BankServiceImpl;
import com.cg.ibs.investment.service.ClientService;
import com.cg.ibs.investment.service.ClientServiceImpl;


public class InvestmentUI {
	static Scanner sc;
	static double goldUnits=0;
	static double silverUnits=0;
	static int status=3;
	public void doIt(){
		
	while(status==3){
		System.out.println("	Press 1 for customer and 2 for bank representative");
		System.out.println("----------------------------------------------------------");
		status= sc.nextInt();
		
			Menu choice = null;
			BankMenu option=null;
		System.out.println("Enter the userId");
		String userId= sc.next();
		System.out.println("Enter the password");
		String password= sc.next();
		ClientService service= new ClientServiceImpl();
		if(status==1){
		try {
			if(service.validateCustomer(userId, password)){
			while (choice != Menu.Quit) {
			System.out.println("Choice");
			System.out.println("--------------------");
			for (Menu menu : Menu.values()) {
				System.out.println(menu.ordinal() + "\t" + menu.toString().replace("_", " "));
			}

			
			int ordinal = sc.nextInt();
			if (ordinal >= 0 && ordinal < Menu.values().length) {
				choice = Menu.values()[ordinal];

				switch (choice) {
				case VIEW_MY_INVESTMENT:
					System.out.println(service.viewInvestments(userId));
					break;
					
				case viewGoldPrice:
					System.out.println(service.viewGoldPrice());
					
					break;
				case viewSilverPrice:
					System.out.println(service.viewSilverPrice());
					break;
				case viewMFplans:
					System.out.println(service.viewMFPlans());
					break;
				case buyGold:
					System.out.println("Enter number of gold units to buy:");
					double goldUnits=sc.nextDouble();
				
					service.buyGold(goldUnits, userId);
					
					System.out.println("transaction completed");
										
					break;
			    case sellGold:
			    	System.out.println("Enter number of gold units to sell:");
					 goldUnits=sc.nextDouble();
					service.sellGold(goldUnits, userId);
					System.out.println("transaction completed");
					
					break;
			    case buySilver:
			    	System.out.println("Enter number of silver units to buy:");
					 silverUnits=sc.nextDouble();
					service.buySilver(silverUnits, userId);
					System.out.println("transaction completed");
					break;
			   case sellSilver:
				   System.out.println("Enter number of silver units to sell:");
					 silverUnits=sc.nextDouble();
					service.sellGold(silverUnits, userId);
					System.out.println("transaction completed");
					
					break;
			   case depositMFplan:
				   System.out.println(service.viewMFPlans());
				   System.out.println("Enter the mutual fund Id:");
				   String mfId=sc.next();
				   System.out.println("Enter the amount to invest");
				   double mfAmount=sc.nextDouble();
				   service.investMF(mfAmount, userId, mfId);
				   System.out.println("transaction completed");
					
					break;
			   case WithdrawMFplan:
				   System.out.println(service.viewInvestments(userId).getFunds());
				   System.out.println("Enter the mutual fund Id:");
				   String mfId1=sc.next();
				   System.out.println("Enter the amount to invest");
				   double mfAmount1=sc.nextDouble();
				   service.withdrawMF(mfAmount1, userId, mfId1);
				   System.out.println("transaction completed");
					
					break;
			   case Quit:
				   System.out.println("You are successfully logged out");
				   break;
				}
			} else {
				System.out.println("Invalid Option!!");
			

			}

}}
		} catch (IBSException e) {
		System.out.println("An error occurred");
		}
		
}
		else if(status==2){
			
			BankService bankservice= new BankServiceImpl();
			while(option!=BankMenu.Quit){
				
				System.out.println("Choice");
				System.out.println("--------------------");
				for (BankMenu menu : BankMenu.values()) {
					System.out.println(menu.ordinal() + "\t" + menu);
				}
				System.out.println("Choice");
				
				int ordinal = sc.nextInt();
				if (ordinal >= 0 && ordinal < BankMenu.values().length) {
					option = BankMenu.values()[ordinal];

					switch (option) {
					case updateGoldPrice:
						System.out.println("Enter the updated gold price");
						double goldPrice= sc.nextDouble();
						try {
							bankservice.updateGoldPrice(goldPrice);
						} catch (IBSException e) {
													e.printStackTrace();
						}
						
						
						break;
					case updateSilverPrice:
						System.out.println("Enter the updated silver price");
						double silverPrice= sc.nextDouble();
						try {
							bankservice.updateSilverPrice(silverPrice);
						} catch (IBSException e) {
							System.out.println("Invalid silver price");
						}
						
						
						break;
					case updateMFplans :
						
						System.out.println("Enter mutualfundId");
						String mfId= sc.next();
						System.out.println("Enter nav value");
						double nav=sc.nextDouble();
						try {
							bankservice.updateMF(new MutualFund(mfId,nav,0));
						} catch (IBSException e) {
							
						}
						
						break;
					
					case Quit:
						System.out.println("You are successfully logged out");
						
						break;
			
		}}}}
		System.out.println("Press 3 to continue");
		status= sc.nextInt();
		
	}	}
	
				
	public static void main(String[] args) throws IBSException {
		sc= new Scanner(System.in);
		InvestmentUI investmentUI=new InvestmentUI();
		investmentUI.doIt();
		System.out.println("The program has ended");
		sc.close();
		
		
	}}
		
	


