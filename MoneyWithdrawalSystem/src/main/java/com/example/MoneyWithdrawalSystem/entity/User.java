package com.example.MoneyWithdrawalSystem.entity;

import java.util.Random;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	
	private long accountId;
	
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
    private String name;  
    
    @Email(message= "email id seems incorrect")
    private String emailId;
    
    @Pattern(regexp="^[0-9]{10}", message="Mobile no. must be of 10 digits")
    private String mobile;
    private int age;
    private char gender;
    
    @NotNull(message = "is required")
    private double monthlySal;
    
    public User(){
    	this.accountId=new Random().nextInt(50000);
    }
    
	public User(String name, String emailId, String mobile, int age, char gender, double monthlySal) {
		this.name = name;
		this.emailId = emailId;
		this.mobile = mobile;
		this.age = age;
		this.gender = gender;
		this.monthlySal = monthlySal;
	}

	@Override
	public String toString() {
		return "User [ accountId=" + accountId + ", Name=" + name + ", emailId=" + emailId + ", mobile="
				+ mobile + ", age=" + age + ", gender=" + gender + ", monthlySal=" + monthlySal + "]";
	}

	public long getAccountId() {
		return accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
			this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getMonthlySal() {
		return monthlySal;
	}

	public void setMonthlySal(double balanceAmount) {
		this.monthlySal = balanceAmount;
	}
	
    
    
}
