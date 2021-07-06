package com.savings.app.dto;

import java.util.Date;

public class CustomerTransaction {

	String fullname;
	int customerid;
	double credit;
	double debit;
	Date transactionDate;
	
	public CustomerTransaction(String fullname, int customerid, double credit, double debit, Date transactionDate) {
		super();
		this.fullname = fullname;
		this.customerid = customerid;
		this.credit = credit;
		this.debit = debit;
		this.transactionDate = transactionDate;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getDebit() {
		return debit;
	}
	public void setDebit(double debit) {
		this.debit = debit;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
