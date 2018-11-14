package com.cg.mba.ui;

import java.util.Scanner;

import com.cg.dto.Customer;
import com.cg.exception.WalletException;
import com.cg.service.WalletServiceImpl;



public class Client {

	public static void main(String[] args) throws WalletException {
		WalletServiceImpl service = new WalletServiceImpl();

		Scanner sc = new Scanner(System.in);

		String customerName,customerMobileNo;
		float customerAge;
		double amount;
		int ch = 0;
		do{
			System.out.println("1.Add Customer\n2.Deposit amount\n3.Withdraw Amount\n4.Fund transfer\n5.Check balance\n6.Print Transaction\n7.Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			Customer customer = new Customer();
			switch(ch){
			case 1 :
										

				do{
					System.out.println("Enter customer name : ");
					customerName = sc.next();
					if(!service.validateName(customerName))
						System.err.println("Name not valid\n");
					else
						break;
				}while(true);
				
				do{
					System.out.println("Enter mobile no. : ");
					customerMobileNo = sc.next();
					if(!service.validateMoileNo(customerMobileNo))
						System.out.println("Mobile number not valid!!!");
					else if(service.validateAccount(customerMobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;								
				}while(true);
				
				do{
					System.out.println("Enter age : ");
					customerAge = sc.nextFloat();
					if(service.validateAge(customerAge))
						break;
				}while(true);
				
				do{
					System.out.println("Enter initial amount : ");
					amount = sc.nextDouble();
					if(!service.validateAmount(amount))
						System.out.println("Amount not valid!!!");
					else
						break;							
				}while(true);



				customer.setName(customerName);
				customer.setMobileNo(customerMobileNo);
				customer.setAge(customerAge);
				customer.setInitialBalance(amount);

				service.createAccount(customer);						

				break;

			case 2 :
				do{
					System.out.println("Enter your mobile number : ");
					customerMobileNo = sc.next();
					if(!service.validateMoileNo(customerMobileNo))
						System.out.println("Please enter valid mobile number!!!");
					else if(!service.validateAccount(customerMobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;
				}while(true);
				
				do{
					System.out.println("Enter the amount you want to deposit");
					amount = sc.nextDouble();
					if(!service.validateAmount(amount))
						System.out.println("Amount not valid!!!");														
					else
						break;

				}while(true);

				service.deposit(customerMobileNo, amount);					

				break;

			case 3 :
				do{
					System.out.println("Enter your mobile number : ");
					customerMobileNo = sc.next();
					if(!service.validateMoileNo(customerMobileNo))
						System.out.println("Please enter a valid mobile number!!!!!");
					else if(!service.validateAccount(customerMobileNo))
						System.out.println("Account already exist with this number!\nPlease try again!!");
					else
						break;
				}while(true);
				do{
					System.out.println("Enter the amount you want to withdraw : ");
					amount = sc.nextDouble();
					if(service.validateMoileNo(customerMobileNo) && service.validateAmount(amount)){
						if(service.validateAccount(customerMobileNo))
							break;
					}
				}while(true);

				service.withdraw(customerMobileNo, amount);

				break;

			case 4 :
				String mobileNoReciever;
				do{
					System.out.println("Enter your mobile number : ");
					customerMobileNo = sc.next();

					System.out.println("Enter the amount you want to transfer : ");
					amount = sc.nextDouble();

					System.out.println("Enter receivers mobile number : ");
					mobileNoReciever = sc.next();
					if(customerMobileNo.equals(mobileNoReciever)){								
						System.out.println("Both numbers are same!\nPlease enter unique numbers...");
						continue;
					}
					if(service.validateMoileNo(customerMobileNo) && service.validateMoileNo(mobileNoReciever) && service.validateAmount(amount)){
						if(service.validateAccount(mobileNoReciever) && service.validateAccount(customerMobileNo))
							break;
					}
				}while(true);
				service.fundTransfer(customerMobileNo, mobileNoReciever, amount);

				break;

			case 5 :
				do{
					System.out.println("Enter the moible id to check balance");
					customerMobileNo = sc.next();
					if(service.validateMoileNo(customerMobileNo)){
						if(service.validateAccount(customerMobileNo))																	
							break;
						else
							System.out.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.out.println("Mobile number not valid!!!");
					}
				}while(true);

				System.out.println("Current Amount is Rs."+service.checkBalance(customerMobileNo));

				break;

			case 6 :
				do{
					System.out.println("Enter the moible id to get transaction");
					customerMobileNo = sc.next();
					if(service.validateMoileNo(customerMobileNo)){
						if(service.validateAccount(customerMobileNo))																	
							break;
						else
							System.out.println("Mobile number not found.\nPlease enter correct mobile number.");
					}
					else{
						System.out.println("Please enter valid mobile number!!!");
					}
				}while(true);

				service.getTransactionList(customerMobileNo);
				break;

			case 7 :
				System.exit(0);
				break;
			default : System.out.println("Invalid input!");
			}

		}while(ch != 7);



	}

}
