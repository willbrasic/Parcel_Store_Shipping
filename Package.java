package assignment3;

// Author: William Brasic
// The purpose of this class is to create a class for package objects used in the PackageShipmentDemo method class.

import java.lang.*;

public class Package {
	
	// fields
	private double weight;
	private double length;
	private double width;
	private double height;
	private double sizeDimension;
	private double weightDimension;
	
	// weight getter
	public double getWeight() {
		return weight;
	}
	
	// weight setter
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	// length getter
	public double getLength() {
		return length;
	}
	
	// length setter
	public void setLength(double length) {
		this.length = length;
	}
	
	// width getter
	public double getWidth() {
		return width;
	}
	
	// width setter
	public void setWidth(double width) {
		this.width = width;
	}
	
	// height getter
	public double getHeight() {
		return height;
	}
	
	// height setter
	public void setHeight(double height) {
		this.height = height;
	}
	
	// size dimension getter
	public double getSizeDimension() {
		return sizeDimension;
	}
	
	// size dimension setter
	public void setSizeDimension(double length, double width, double height) {
		sizeDimension = length + width + height;
	}
	
	// weight dimension setter
	public void setWeightDimension(double length, double width, double height) {
		weightDimension = Math.ceil((Math.ceil(length) * Math.ceil(width) * Math.ceil(height)) / (double)166);
	}
	
	public double getWeightDimension() {
		return weightDimension;
	}
	
	// method for determining if package is overweight
	public boolean overweight(){
		if (this.getWeight() > 150)
			return true;
		else
			return false;
	}
	
	// method for determining if package is oversize
	public boolean oversize() {
		if (this.getSizeDimension() > 110)
			return true;
		else
			return false;
	}
	
	// using toString method to output information regarding object of class Package
	public String toString() {
		return "The package's actual weight is " + this.weight + " pounds. The dimensional weight is " + this.getWeightDimension()
				+ "(" + Math.ceil(length) + " x " + Math.ceil(width) + " x " + Math.ceil(height) + ").";
	}
	
	// package shipping cost calculator
	public double shippingCost() {
		double billableWeight;
		final double PRICEPERPOUND = 2.5;
		
		// determining whether the regular weight or dimensional weight is greater. Billable weight is the greater of the two.
		if(this.weight > this.weightDimension)
			billableWeight = this.weight;
		else
			billableWeight = this.getWeightDimension();
		
		return billableWeight * PRICEPERPOUND;
		
	}
	
	
	
	
	
	
	
	
	

}
