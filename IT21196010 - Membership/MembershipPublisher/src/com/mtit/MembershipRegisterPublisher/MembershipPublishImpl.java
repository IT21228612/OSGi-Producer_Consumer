package com.mtit.MembershipRegisterPublisher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MembershipPublishImpl implements MembershipPublisher {

	public List<Membership> memberships = new ArrayList<Membership>();

	// adding a new record
/*@Override
	public String addMember(String member_ID, String fullName, String contact_no, String mem_type,LocalDate date) {
		
		Membership membership = new Membership(member_ID, fullName,contact_no, mem_type,date);
		memberships.add(membership);
		return membership.getFullName() + " " + "registered successfully \nMembership Type: "
				+ membership.getmem_type();

	}
*/
	// Get all records
	@Override
	public List<Membership> getAllMembers() {
		return memberships;

	}

	// Delete Record
	@Override
	public void deleteMember(String member_ID) {
		for (Membership membership : memberships) {
			if (membership.getmember_ID().equalsIgnoreCase(member_ID)) {
				int id = memberships.indexOf(membership);
				memberships.remove(id);
				System.out.println();
				System.out.println("Member Details Deleted Successfully");
				return;
			}
		}

	}

	@Override
	public Membership getMemberById(String memberId) {
		 for (Membership member : memberships) {
	            if (member.getmember_ID().equals(memberId)) {
	                return member;
	            }
	        }
	        return null;
	}

	@Override
	public String addMember(Membership newMembership) {
		memberships.add(newMembership);
		return newMembership.getFullName() + " " + "registered successfully \nMembership Type: "
				+ newMembership.getmem_type();

	} 
	
	
	

}
