package assignment3;

// Author: William Brasic
// The purpose of this class is to create a class for shipment objects used in the PackageShipmentDemo method class.


import java.util.ArrayList;

import assignment3.Package; 

public class Shipment {
	
	//fields
	private int frequentShipperNumber;
	private double packageCost;
	private ArrayList<Package> detailedPackage;
	
	// constructor
	public Shipment(){
		this.detailedPackage = new ArrayList<Package>();
	}
	
	// frequent shipper number getter
	public int getFrequentShipperNumber() {
		return frequentShipperNumber;
	}

	// frequent shipper number setter
	public void setFrequentShipperNumber(int frequentShipperNumber) {
		this.frequentShipperNumber = frequentShipperNumber;
	}
	
	// package cost getter
	public double getPackageCost() {
		return packageCost;
	}
	
	// package cost setter
	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}

	// package ArrayList getter
	public ArrayList<Package> getDetailedPackage() {
		return detailedPackage;
	}
	
	// adding package items to the detailedPackage ArrayList
	public void addPackageDetails(Package item) {
		detailedPackage.add(item);
	}
	
	// determine user is a frequent shipper 
	public boolean frequentShipper() {
		if (this.getFrequentShipperNumber() == 0)
			return false;
		else
			return true;
	}
	
	// determine bulk discount
	public boolean bulkDiscount() {
		if (this.getPackageCost() > 250)
			return true;
		else
			return false;
	}
	
	// determine grand total
	public double grandTotal() {
		if (this.frequentShipper())
			this.setPackageCost(this.getPackageCost() * 0.94);
		if (this.bulkDiscount())
			this.setPackageCost(this.getPackageCost() - 20.00);
		
		return this.getPackageCost();
			
	}
	
	
	
}
