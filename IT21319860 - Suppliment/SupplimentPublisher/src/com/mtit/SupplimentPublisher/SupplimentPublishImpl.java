package com.mtit.SupplimentPublisher;

import java.util.ArrayList;
import java.util.List;

public class SupplimentPublishImpl implements SupplimentPublisher {

	public List<Suppliment> suppliments = new ArrayList<Suppliment>();

	// adding a new record
	@Override
	public String addSuppliment(String supplimentID, String brandName, String supplimentName, String quantity, String supplimentType,
			String expieryDate) {
		Suppliment suppliment = new Suppliment(supplimentID, brandName, supplimentName, quantity, supplimentType, expieryDate);
		suppliments.add(suppliment);
		return suppliment.getBrandName() + " " + suppliment.getSupplimentName() + " " + "Added successfully \nSuppliment Type: "
				+ suppliment.getSupplimentType();

	}

	// Get all records
	@Override
	public List<Suppliment> getAllSuppliments() {
		return suppliments;

	}

	// Delete Record
	@Override
	public void deleteSuppliment(String supplimentID) {
		for (Suppliment suppliment : suppliments) {
			if (suppliment.getSupplimentID().equalsIgnoreCase(supplimentID)) {
				int id = suppliments.indexOf(suppliment);
				suppliments.remove(id);
				System.out.println();
				System.out.println("Suppliment Details Deleted Successfully");
				return;
			}
		}

	}

}
