package assignment3;

// Author: William Brasic
/* The purpose of this program is compute the cost of shipping packages at a parcel store.
 * Weight and size of the packages will be checked accordingly.
 * Discounts will be applied were appropriate.
 * The cost before discounts, the quantity of the discounts themselves, and the grand total will be displayed to the user.
 */

// import necessary classes
import java.text.DecimalFormat;
import java.util.Scanner;

public class PackageShipmentDemo {

	public static void main(String[] args) {
		
		// number formatter
		DecimalFormat formatter = new DecimalFormat("##0.00");
		
		// user response for the do-while loop 
		String userResponse = "Y";
		
		// creating new shipment object
		Shipment shipment = new Shipment();
		
		// creating scanner object for keyboard entry
		Scanner kb = new Scanner(System.in);
		
		// welcome message for user
		System.out.println("Welcome to the parcel service station. Please enter the weight and the size of your packages.");
		
		// package counter
		int packageCount = 0;
		
		// begin do-while loop for package information
		do {
			// create new package object
			Package pack = new Package();
			
			// message for user about package i
			System.out.println("==Please enter the data for package " + (packageCount + 1) + "==");
			
			// prompt user for package weight
			System.out.println("Please enter the weight of the package in pounds: ");
			pack.setWeight(kb.nextDouble());
			
			// input validation for weight variable
			while(pack.getWeight() <= 0) {
				System.out.println("The number should be greater than 0. Please enter again: ");
				pack.setWeight(kb.nextDouble());
			}
			
			// if package is overweight, do not proceed and move to potential next package. Otherwise, keep gathering info on current package
			if (pack.overweight())
				System.out.println("Cannot accept overweight package.");
			else {
				// prompt user to enter package length
				System.out.println("Please enter the length of the package in inches: ");
				pack.setLength(kb.nextDouble());
				
				// input validation for length variable
				while(pack.getLength() <= 0) {
					System.out.println("The number should be greater than 0. Please enter again: ");
					pack.setLength(kb.nextDouble());
				}
				
				// prompt user to enter package width
				System.out.println("Please enter the width of the package in inches: ");
				pack.setWidth(kb.nextDouble());
				
				// input validation for width
				while(pack.getWidth() <= 0) {
					System.out.println("The number should be greater than 0. Please enter again: ");
					pack.setWidth(kb.nextDouble());
				}
				
				// prompt user to enter package height
				System.out.println("Please enter the height of the package in inches: ");
				pack.setHeight(kb.nextDouble());
				
				// input validation for height
				while(pack.getHeight() <= 0) {
					System.out.println("The number should be greater than 0. Please enter again: ");
					pack.setHeight(kb.nextDouble());
				}
				
				// setting package size dimension
				pack.setSizeDimension(pack.getLength(), pack.getWidth(), pack.getHeight());
				
				// if package is oversized, do not proceed and move to potential next package. Otherwise, keep gathering info on current package
				if (pack.oversize()) 
					System.out.println("Cannot accept oversize package.");
				else {
					// setting package dimensional weight
					pack.setWeightDimension(pack.getLength(), pack.getWidth(), pack.getHeight());
					
					// package object is not oversized or overweight so print the information of the package and shipping cost
					System.out.print(pack);
					System.out.println("");
					System.out.println("The shipping cost is $" + pack.shippingCost() + ".");
					
					// add package to shipment
					shipment.addPackageDetails(pack);
					
					// adding one to the package count
					packageCount += 1;
				}
			}
					
			// consume next line character
			kb.nextLine();
			
			// ask user to enter another package
			System.out.println("Do you have more packages to ship? (Y/N)" );
			userResponse = kb.nextLine();
			
			// input validation
			while(!(userResponse.equalsIgnoreCase("Y") || userResponse.equalsIgnoreCase("N"))) {
				System.out.println("Only enter a 'Y' or a 'N'. Please try again: ");
				userResponse = kb.nextLine();
			}
			
		// keep doing the do-while loop while userResponse = Y	
		} while(userResponse.equalsIgnoreCase("Y"));
		
		// prompt user to enter frequent shipper number
		System.out.println("Please enter your frequent-shipper number (enter 0 if you do not have one): ");
		shipment.setFrequentShipperNumber(kb.nextInt());
		
		// print total number of packages to ship
		System.out.println("Total " + packageCount + " package(s) to ship.");
		
		// loop through ArrayList of package objects to get the total cost of packages before discounts
		double packageCost =0;
		for(int i=0; i<shipment.getDetailedPackage().size(); i++){
			
			// add to the package cost
			packageCost += shipment.getDetailedPackage().get(i).shippingCost();
		}
		
		// setting the package cost to the shipment object
		shipment.setPackageCost(packageCost);
		
		// printing the total cost of packages before discounts
		System.out.println("Package cost: " + formatter.format(shipment.getPackageCost()) + ".");
		
		// print discount if user is a frequent shipper
		if (shipment.frequentShipper())
			System.out.println("Frequent shipper discount -" + formatter.format(shipment.getPackageCost() * 0.06) + ".");
		
		// print discount if user is shipping a bulk order
		if (shipment.bulkDiscount())
			System.out.println("Bulk discount: -20.00");
		
		// printing grand total after discounts
		System.out.println("Grand total: " + formatter.format(shipment.grandTotal()) + ".");
		
		// closing Scanner object
		kb.close();
		
	}

}
