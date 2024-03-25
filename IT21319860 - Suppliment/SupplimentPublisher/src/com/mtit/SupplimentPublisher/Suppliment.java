package com.mtit.SupplimentPublisher;

public class Suppliment {

	private String supplimentID;
	private String brandName;
	private String supplimentName;
	private String quantity;
	private String supplimentType;
	private String expieryDate;
	
	public Suppliment(String supplimentID, String brandName, String supplimentName, String quantity, String supplimentType, String expieryDate) {
		super();
		this.supplimentID = supplimentID;
		this.brandName = brandName;
		this.supplimentName = supplimentName;
		this.quantity = quantity;
		this.supplimentType = supplimentType;
		this.expieryDate = expieryDate;
	}
	
	//Getters 
	
	public String getSupplimentID() {
		return supplimentID;
	}
	public String getBrandName() {
		return brandName;
	}
	public String getSupplimentName() {
		return supplimentName;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getSupplimentType() {
		return supplimentType;
	}
	public String getExpieryDate() {
		return expieryDate;
	}
	
	//Setters
	
	public void setSupplimentID(String supplimentID) {
		this.supplimentID = supplimentID;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public void setSupplimentName(String supplimentName) {
		this.supplimentName = supplimentName;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setSupplimentType(String supplimentType) {
		this.supplimentType = supplimentType;
	}
	public void setExpieryDate(String expieryDate) {
		this.expieryDate = expieryDate;
	}
	
	


	


}
