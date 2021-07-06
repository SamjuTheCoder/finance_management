package com.savings.app.dto;

public class CustomerResponse {
	
	String fullname;
	String sex;
	String phone;
	String email;
	String address;
	
	
	public CustomerResponse(String fullname, String sex, String phone, String email, String address) {
		super();
		this.fullname = fullname;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
