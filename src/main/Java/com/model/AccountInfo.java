package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AccountInfo {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	long accountNumber;
	String email;
	String type;
	double balance;
	@OneToMany(mappedBy = "accountNumber",fetch =FetchType.EAGER)
	List<Activities> activities;
	
	
	
	public List<Activities> getActivities() {
		return activities;
	}
	public void setActivities(List<Activities> activities) {
		this.activities = activities;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double amt) {
		this.balance = amt;
	}
	
	

}
