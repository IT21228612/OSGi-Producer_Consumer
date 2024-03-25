package com.mtit.SupplimentSubscriber;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mtit.SupplimentPublisher.Suppliment;
import com.mtit.SupplimentPublisher.SupplimentPublisher;

public class SupplimentSubscriberImpl implements SupplimentSubscriber {

	String input;
	String supplimentID;
	String brandName;
	String supplimentName;
	String quantity;
	String supplimentType;
	String expieryDate;
	Scanner sc = new Scanner(System.in);

	public static final String ADD = "add";
	public static final String All = "all";
	public static final String DELETE = "delete";
	public static final String UPDATE = "update";
	public static final String SEARCH_BRAND = "search_brand";
	public static final String EXPIRING = "expiring";

	@Override
	public void getService(SupplimentPublisher supplimentpublisher) {
		System.out.println();
		System.out.println("============== Suppliment Service ==============");
		System.out.println("                Gym Fitness 032                 ");
		System.out.println();
		System.out.println("Select the desired service from the menu. ");
		System.out.println();

		while (true) {
			input = getInput();

			if (input.equalsIgnoreCase(ADD)) {
				addRecord(supplimentpublisher);
			} else if (input.equalsIgnoreCase(All)) {
				getAllRecords(supplimentpublisher);
			} else if (input.equalsIgnoreCase(DELETE)) {
				deleteRecord(supplimentpublisher);
			} else if (input.equalsIgnoreCase(UPDATE)) { // Option for updating record
                updateRecord(supplimentpublisher);
            }else if (input.equalsIgnoreCase(SEARCH_BRAND)) {
                searchByBrandName(supplimentpublisher);
            }else if (input.equalsIgnoreCase(EXPIRING)) {
                displayExpiringSuppliments(supplimentpublisher);
            } 
			else {
				System.out.println("Invalid");
			}
		}

	}

	public String getInput() {
		System.out.println("                                                ");
		System.out.println("Add Suppliment:                                'Add'");
		System.out.println("View Suppliment Details:                       'All'");
		System.out.println("Remove Suppliment:                             'Delete'");
		System.out.println("Update Suppliment Details:                     'Update'");
		System.out.println("Search Suppliments by Brand Name:              'search_brand'");
		System.out.println("View Expiring Suppliments:                     'expiring'");
		System.out.println();
		System.out.println("Type the prefered Selection:                    ");
		String input = sc.nextLine();
		return input;

	}

	public void addRecord(SupplimentPublisher supplimentpublisher) {
		System.out.println();
		System.out.println("===========  Suppliment Adding Form  ============");
		System.out.println("                Gym Fitness 032                 ");
		System.out.println();
		System.out.println("Insert new Suppliment Details");
		System.out.println();
		System.out.println("Suppliment ID:");
		supplimentID = sc.nextLine();
		System.out.println();
		
		
	    List<Suppliment> suppliments = supplimentpublisher.getAllSuppliments();
	    for (Suppliment suppliment : suppliments) {
	        if (suppliment.getSupplimentID().equals(supplimentID)) {
	            System.out.println("Error: Suppliment ID already exists. Please enter a different ID.");
	            addRecord(supplimentpublisher); // Ask again to enter details
	            return;
	        }
	    }

		System.out.println("Brand Name:");
		brandName = sc.nextLine();
		System.out.println();

		System.out.println("Suppliment Name");
		supplimentName = sc.nextLine();
		System.out.println();
		
		System.out.println("Suppliment Type (Cerial/Protein,..):");
		supplimentType = sc.nextLine();
		System.out.println();

		System.out.println("Quantity:");
		quantity = sc.nextLine();
		System.out.println();


		System.out.println("Expiery Date (Y/M/D): ");
		expieryDate = sc.nextLine();
		System.out.println();

		String temp = supplimentpublisher.addSuppliment(supplimentID, brandName, supplimentName, quantity, supplimentType, expieryDate);
		System.out.println(temp);
		System.out.println();
	}

	public void getAllRecords(SupplimentPublisher supplimentpublisher) {
		List<Suppliment> suppliments = supplimentpublisher.getAllSuppliments();

		System.out.println();
		System.out.println("=============== Supliment List ====================");
		System.out.println("                Gym Fitness 032                 ");
		System.out.println();
		System.out.println();
		System.out.println("ID \t\t Suppliment Name \t Quantity \t Expirey Date");
		for (Suppliment suppliment : suppliments) {
			System.out.println();
			System.out
					.println(suppliment.getSupplimentID() + "\t\t" + suppliment.getBrandName() + " " + suppliment.getSupplimentName()+ "\t\t" + suppliment.getQuantity() + "\t\t" +suppliment.getExpieryDate());
			System.out.println();
		}

		System.out.println();
	}

	private void deleteRecord(SupplimentPublisher supplimentpublisher) {
		String supplimentID;

		System.out.println();
		System.out.println("============= Supliment Deletion ================");
		System.out.println("                Gym Fitness 032                 ");
		System.out.println();
		System.out.println("Enter Suppliment's ID to be deleted: ");
		supplimentID = sc.nextLine();
		supplimentpublisher.deleteSuppliment(supplimentID);
		System.out.println();
	}
	public void updateRecord(SupplimentPublisher supplimentpublisher) {
        System.out.println();
        System.out.println("===========  Suppliment Update Form  ============");
        System.out.println("                Gym Fitness 032                 ");
        System.out.println();
        System.out.println("Enter Suppliment ID to update:");
        String supplimentIDToUpdate = sc.nextLine();
        System.out.println();

        
        boolean found = false;
        List<Suppliment> suppliments = supplimentpublisher.getAllSuppliments();
        for (Suppliment suppliment : suppliments) {
            if (suppliment.getSupplimentID().equals(supplimentIDToUpdate)) {
                found = true;
                System.out.println("Suppliment Found. Enter the new details:");
                System.out.println("Brand Name:");
                brandName = sc.nextLine();
                suppliment.setBrandName(brandName);
                System.out.println("Suppliment Name:");
                supplimentName = sc.nextLine();
                suppliment.setSupplimentName(supplimentName);
                System.out.println("Suppliment Type (Cereal/Protein,..):");
                supplimentType = sc.nextLine();
                suppliment.setSupplimentType(supplimentType);
                System.out.println("Quantity:");
                quantity = sc.nextLine();
                suppliment.setQuantity(quantity);
                System.out.println("Expiry Date (Y/M/D):");
                expieryDate = sc.nextLine();
                suppliment.setExpieryDate(expieryDate);
                System.out.println("Suppliment details updated successfully.");
                break;
            }
        }
        if (!found) {
        	System.out.println("Suppliment with ID " + supplimentIDToUpdate + " not found.");
        }
	}
	public void searchByBrandName(SupplimentPublisher supplimentpublisher) {
        System.out.println();
        System.out.println("===========  Search Suppliments by Brand Name  ============");
        System.out.println("                Gym Fitness 032                 ");
        System.out.println();
        System.out.println("Enter Brand Name to search:");
        String brandNameToSearch = sc.nextLine();
        System.out.println();

        List<Suppliment> suppliments = supplimentpublisher.getAllSuppliments();
        boolean found = false;
        for (Suppliment suppliment : suppliments) {
            if (suppliment.getBrandName().equalsIgnoreCase(brandNameToSearch)) {
                found = true;
                System.out.println("Suppliment found:");
                System.out.println("Suppliment ID: " + suppliment.getSupplimentID());
                System.out.println("Brand Name: " + suppliment.getBrandName());
                System.out.println("Suppliment Name: " + suppliment.getSupplimentName());
                System.out.println("Suppliment Type: " + suppliment.getSupplimentType());
                System.out.println("Quantity: " + suppliment.getQuantity());
                System.out.println("Expiry Date: " + suppliment.getExpieryDate());
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No suppliments found for the brand name: " + brandNameToSearch);
        }
    }
	public void displayExpiringSuppliments(SupplimentPublisher supplimentpublisher) {
        System.out.println();
        System.out.println("===========  Expiring Suppliments  ============");
        System.out.println("                Gym Fitness 032                 ");
        System.out.println();

        List<Suppliment> suppliments = supplimentpublisher.getAllSuppliments();
        boolean found = false;
        for (Suppliment suppliment : suppliments) {
            
            LocalDate expiryDate = LocalDate.parse(suppliment.getExpieryDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            LocalDate currentDate = LocalDate.now();
            if (expiryDate.isBefore(currentDate.plusDays(30))) { 
                found = true;
                System.out.println("Suppliment ID: " + suppliment.getSupplimentID());
                System.out.println("Brand Name: " + suppliment.getBrandName());
                System.out.println("Suppliment Name: " + suppliment.getSupplimentName());
                System.out.println("Expiry Date: " + suppliment.getExpieryDate());
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("No expiring suppliments found.");
        }
    }


}
