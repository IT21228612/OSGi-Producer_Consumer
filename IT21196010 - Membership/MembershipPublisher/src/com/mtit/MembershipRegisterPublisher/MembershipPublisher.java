package com.mtit.MembershipRegisterPublisher;
import java.time.LocalDate;
import java.util.List;

public interface MembershipPublisher {
	
	//public String addMember(String member_ID, String fullName,String contact_no, String mem_type,LocalDate date);
	public List <Membership> getAllMembers();
	public void deleteMember(String member_ID);
	public Membership getMemberById(String memberId);
	public String addMember(Membership newMembership);
}
