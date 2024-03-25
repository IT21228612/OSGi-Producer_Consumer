package com.mtit.SupplimentPublisher;
import java.util.List;

public interface SupplimentPublisher {
	
	public String addSuppliment(String supplimentID, String brandName, String supplimentName, String quantity, String supplimentType, String expieryDate);
	public List <Suppliment> getAllSuppliments();
	public void deleteSuppliment(String supplimentID);
}
