package com.mtit.MembershipRegisterSubscriber;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

import com.mtit.MembershipRegisterPublisher.Membership;
import com.mtit.MembershipRegisterPublisher.MembershipPublisher;



public class MembershipSubscriberImpl implements MembershipSubscriber {

	String input;
	String memberID;
	String fullName;
	String contactNo;
	String memType;
	LocalDate date;
	
	public static final String ADD = "add";
	public static final String All = "all";
	public static final String DELETE = "delete";
	public static final String SEARCH = "search";

	
	Scanner sc = new Scanner(System.in);

	@Override
	public void getService(MembershipPublisher membershippublisher) {
		System.out.println();
		System.out.println("============== Membership Service ==============");
		System.out.println();
		System.out.println("Select the desired service ");
		System.out.println();

		while (true) {
			input = getChoice();

			if (input.equalsIgnoreCase(ADD)) {
				addRecord(membershippublisher);
			} else if (input.equalsIgnoreCase(All)) {
				getAllRecords(membershippublisher);
			} else if (input.equalsIgnoreCase(DELETE)) {
				deleteRecord(membershippublisher);
			} else if (input.equalsIgnoreCase(SEARCH)) {
                searchMemberById(membershippublisher);
			} else {
				System.out.println("Invalid");
			}
		}

	}

	private void searchMemberById(MembershipPublisher membershippublisher) {
		 System.out.println();
	        System.out.println("============== Search Member by ID ================");
	        System.out.println();
	        System.out.println("Enter Member ID to search: ");
	        String memberId = sc.nextLine();
	        Membership member = membershippublisher.getMemberById(memberId);
	        int remainingMonths = calculateRemainingMonths(member);
	        if (member != null) {
	            System.out.println("Member Found:");
	            System.out.println("ID: " + member.getmember_ID());
	            System.out.println("Full Name: " + member.getFullName());
	            System.out.println("Contact Number: " + member.getContact_no());
	            System.out.println("Membership Package: " + member.getmem_type());
	            System.out.println("Remaining months for membership ID " + member.getmember_ID() + ": " + remainingMonths);
	        } else {
	            System.out.println("Member with ID " + memberId + " not found.");
	        }
		
	}

	public String getChoice() {
		System.out.println("                                                ");
		System.out.println("Register Members:                             'Add'");
		System.out.println("View Member Details:                          'All'");
		System.out.println("Remove Members:                               'Delete'");
		System.out.println("Search Member By ID:                          'Search'");
		System.out.println();
		System.out.println("Type the prefered Selection:                    ");
		String input = sc.nextLine();
		return input;

	}

	public void addRecord(MembershipPublisher membershippublisher) {
		
		List<Membership> memberships = membershippublisher.getAllMembers();
		
		System.out.println();
		System.out.println("=========== Membership Registration ============");
		System.out.println();
		System.out.println("Insert new Member Details");
		System.out.println();
		
		 	boolean uniqueID = false;
		    while (!uniqueID) {
		        System.out.println("Member ID:");
		        memberID = sc.nextLine();
		        System.out.println();
		        
		        // Check if the member ID already exists
		        boolean exists = memberships.stream().anyMatch(membership -> membership.getmember_ID().equals(memberID));
		        if (exists) {
		            System.out.println("Member with ID " + memberID + " already exists. Please enter a unique ID.");
		        } else {
		            uniqueID = true; // Set uniqueID to true to exit the loop
		        }
		    }
		System.out.println("Full Name:");
		fullName = sc.nextLine();
		System.out.println();

		System.out.println("Contact Number:");
		contactNo = sc.nextLine();
		System.out.println();

		System.out.println("Membership Package (MONTHLY or YEARLY):");
	    memType = sc.nextLine().toUpperCase(); // Convert to uppercase for enum matching
	    System.out.println();
	    
	    Membership.MembershipType membershipType = Membership.MembershipType.valueOf(memType);
	    
	    System.out.println("Registration Date (YYYY-MM-DD):");
	    LocalDate registrationDate = LocalDate.parse(sc.nextLine());
	    System.out.println();
	    
	    
		Membership newMembership = new Membership(memberID, fullName,contactNo, memType, date);
	    newMembership.setmember_ID(memberID);
	    newMembership.setFullName(fullName);
	    newMembership.setContact_no(contactNo);
	    newMembership.setmem_type(membershipType.toString());
	    newMembership.setRegisteredDate(registrationDate);

	   
		
		String temp = membershippublisher.addMember(newMembership);
		System.out.println(temp);
		System.out.println();
	}

	public void getAllRecords(MembershipPublisher membershippublisher) {
		
		List<Membership> memberships = membershippublisher.getAllMembers();

		System.out.println();
		System.out.println("=================== Members ====================");
		System.out.println();
		System.out.println();
		System.out.println("ID \t\t Full Name");
		for (Membership membership : memberships) {
			System.out.println();
			System.out.println(membership.getmember_ID() + "\t\t" + membership.getFullName());
			System.out.println();
		}

		System.out.println();
	}

	private void deleteRecord(MembershipPublisher membershippublisher) {
		
		String id;

		System.out.println();
		System.out.println("============== Members Deletion ================");
		System.out.println();
		System.out.println(" Member's ID to be deleted: ");
		id = sc.nextLine();
		membershippublisher.deleteMember(id);
	
	}
	
	
	public int calculateRemainingMonths(Membership membership) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expiryDate;
        if (Membership.MembershipType.valueOf(membership.getmem_type()) == Membership.MembershipType.MONTHLY) {
            expiryDate = membership.getRegisteredDate().plusMonths(1);
        } else {
            expiryDate = membership.getRegisteredDate().plusYears(1);
        }
        return (int) ChronoUnit.MONTHS.between(currentDate, expiryDate);
    }
	
	
}
