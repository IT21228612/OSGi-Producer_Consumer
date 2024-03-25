package com.mtit.MembershipRegisterPublisher;

import java.time.LocalDate;

public class Membership {

	private String member_ID;
	private String fname;
	private String contact_no;
	private String mem_type;
	private LocalDate registeredDate;
	
	public Membership(String member_ID, String fname,String contact_no, String mem_type,LocalDate Date) {
		super();
		this.member_ID = member_ID;
		this.fname = fname;
		this.contact_no = contact_no;
		this.mem_type = mem_type;
		this.registeredDate = Date;
	
	}
	
	public enum MembershipType {
        MONTHLY,
        YEARLY
    }
	
	//Getters 
	
	public String getmember_ID() {
		return member_ID;
	}
	public String getFullName() {
		return fname;
	}
	
	public String getContact_no() {
		return contact_no;
	}
	public String getmem_type() {
		return mem_type;
	}
	
	public LocalDate getRegisteredDate() {
        return registeredDate;
    }
	
	
	//Setters
	
	public void setmember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public void setFullName(String fname) {
		this.fname = fname;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public void setmem_type(String membershipType) {
		this.mem_type = membershipType;
	}

	public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

	
	


	


}
