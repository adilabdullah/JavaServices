package com.java.model;

public class Accounts {
String Acct_no,Acct_title,Acct_type,Acct_status,dop;
public String getDop() {
	return dop;
}
public void setDop(String dop) {
	this.dop = dop;
}
int Tran_limit;
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
double max_limit,min_limit,max_tran_limit,balance;


public Accounts() {
	super();
	// TODO Auto-generated constructor stub
}
public Accounts(String acct_no, String acct_title, String acct_type,
		String acct_status, int tran_limit, double max_limit, double min_limit,
		double balance,double max_tran_limit) {
	super();
	Acct_no = acct_no;
	Acct_title = acct_title;
	Acct_type = acct_type;
	Acct_status = acct_status;
	Tran_limit = tran_limit;
	this.balance = balance;
	this.max_limit = max_limit;
	this.min_limit = min_limit;
	this.max_tran_limit = max_tran_limit;
}
public String getAcct_no() {
	return Acct_no;
}
public void setAcct_no(String acct_no) {
	Acct_no = acct_no;
}
public String getAcct_title() {
	return Acct_title;
}
public void setAcct_title(String acct_title) {
	Acct_title = acct_title;
}
public String getAcct_type() {
	return Acct_type;
}
public void setAcct_type(String acct_type) {
	Acct_type = acct_type;
}
public String getAcct_status() {
	return Acct_status;
}
public void setAcct_status(String acct_status) {
	Acct_status = acct_status;
}
public int getTran_limit() {
	return Tran_limit;
}
public void setTran_limit(int tran_limit) {
	Tran_limit = tran_limit;
}
public double getMax_limit() {
	return max_limit;
}
public void setMax_limit(double max_limit) {
	this.max_limit = max_limit;
}
public double getMin_limit() {
	return min_limit;
}
public void setMin_limit(double min_limit) {
	this.min_limit = min_limit;
}
public double getMax_tran_limit() {
	return max_tran_limit;
}
public void setMax_tran_limit(double max_tran_limit) {
	this.max_tran_limit = max_tran_limit;
}


}
