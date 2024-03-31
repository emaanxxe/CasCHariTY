package Beans;


import java.util.*;

public class Donation {
	
	private int id;
	private String donorEmail;
	private String donorName;
	private String CasID;
	private double Amount;
	private String paymentMode;
	private Date date;
	private String To_CAS;
	
	
	public Donation(int Id,String DE, String DN, String CI,double Am ,String payM ,Date da,String TCAS) {
		this.id=Id;
		this.donorEmail=DE;
		this.donorName=DN;
		this.CasID=CI;
		this.Amount=Am;
		this.paymentMode=payM;
		this.date=da;	
		this.To_CAS=TCAS;
	}
	
	public Donation() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getTo_CAS() {
		return To_CAS;
	}

	public void setTo_CAS(String to_CAS) {
		To_CAS = to_CAS;
	}

	public String getDonorEmail() {
		return donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getCasID() {
		return CasID;
	}

	public void setCasID(String casID) {
		CasID = casID;
	}
	
	
}
