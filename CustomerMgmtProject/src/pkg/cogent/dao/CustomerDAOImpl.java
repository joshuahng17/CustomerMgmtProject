package pkg.cogent.dao;

import java.time.LocalDate;
import java.util.Scanner;

import pkg.cogent.exceptions.MandatoryFieldException;
import pkg.cogent.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	Customer customers[];
	Scanner sc=new Scanner(System.in);
	@Override
	public void create() {
		
		System.out.println("How many customer you want to store?");
		int size=sc.nextInt();
		customers=new Customer[size];
		for(int i=0;i<customers.length;i++)
		{
			Customer cust=new Customer();
			System.out.println("Please enter customer ID:");
			String cid=sc.next();		
			System.out.println("Please enter customer name:");
			String cname=sc.next();
			System.out.println("Please enter customer email ");
			String eMail=sc.next();
			System.out.println("Please enter customer DOB ");
			String cdob=sc.next();
			cust.setcId(cid);
			cust.setcName(cname);
			cust.setcEmail(eMail);
			cust.setcDob(cdob);
			validateMandatoryField(cust);
			customers[i]=cust;
		}
	}
	
	public void validateMandatoryField(Customer customer)
	{
		if(customer==null)
		{
			throw new MandatoryFieldException("Customer object can not be left blank");
		}
		else if(customer.getcId()==null)
		{
			throw new MandatoryFieldException("Customer ID can not be left blank");
		}
	}

	@Override
	public void read() {
		for(int i=0;i<customers.length;i++)
		{
			System.out.println("Customer ID:"+customers[i].getcId());
			System.out.println("Customer  name:"+customers[i].getcName());
			System.out.println("Customer e-mail:"+customers[i].getcEmail());
		}
	}

	@Override
	public void update(String customerId) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i]!=null && customers[i].getcId().equals(customerId)) {	
				System.out.println("Please enter the new customer name:");
				String newname=sc.next();
				System.out.println("Please enter the new customer email ");
				String newemail=sc.next();
				System.out.println("Please enter the new customer DOB ");
				String newdob=sc.next();
				customers[i].setcName(newname);
				customers[i].setcEmail(newemail);
				customers[i].setcDob(newdob);
				return;
			}
		}
	}

	@Override
	public void delete(String customerId) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i]!=null && customers[i].getcId().equals(customerId)) {
				customers[i] = null;
				return;
			}
		}

	}
	@Override
	public void findCustomerById(String customerId) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i]!=null && customers[i].getcId().equals(customerId)) {
				String cname = customers[i].getcName() ;
				String cemail = customers[i].getcEmail();
				String cdob = customers[i].getcDob();
				System.out.println("Customer Name: "+cname);
				System.out.println("Customer Email: "+cemail);
				System.out.println("Customer DOB: "+cdob);
				return;
			}
		}
	}
	
	@Override
	public void findYoungestCustomer() {
		String youngestId = customers[0].getcId();
		String youngestName = customers[0].getcName();
		String youngestEmail = customers[0].getcEmail();
		LocalDate youngestAge = LocalDate.parse(customers[0].getcDob());
		for(int i=0;i<customers.length;i++) {
			if(customers[i]!=null) {
				LocalDate currentAge = LocalDate.parse(customers[i].getcDob());
				if(currentAge.isAfter(youngestAge)) {
					youngestId = customers[i].getcId();
					youngestName = customers[i].getcName();
					youngestEmail = customers[i].getcEmail();
					youngestAge = currentAge;
				}
			}
		}
		System.out.println("Youngest Customer:");
		System.out.println("Customer ID: "+youngestId);
		System.out.println("Customer Name: "+youngestName);
		System.out.println("Customer Email: "+youngestEmail);
	}

}
