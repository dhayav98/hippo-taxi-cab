package com.hippo.taxi.model;

public class TaxiBooking {
	private int customerId;
	private char pickupPoint;
	private char dropPoint;
	private double pickupTime;
	private double dropTime;
	private int earnings;
	private int taxiNumber;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public char getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public char getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}

	public double getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(double pickupTime) {
		this.pickupTime = pickupTime;
	}

	public double getDropTime() {
		return dropTime;
	}

	public void setDropTime(double dropTime) {
		this.dropTime = dropTime;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public int getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(int taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public TaxiBooking() {
		super();
	}

	public TaxiBooking(int id, char pick, char drop, double PickTime) {
		customerId = id;
		pickupPoint = pick;
		dropPoint = drop;
		pickupTime = PickTime;
	}

	public void dropTime() {
		this.dropTime = (pickupTime + (Math.abs(pickupPoint - dropPoint)));
	}

	public void calculateEarnings() {
		int dist = (Math.abs(pickupPoint - dropPoint) * 15);
		this.earnings = ((dist - 5) * 10) + 100;

	}

	@Override
	public String toString() {
		int temp=(int)pickupTime;
		double temp1=(pickupTime-temp)*(double)0.6;
		double temp2=(double)temp+temp1;
		String temp3=String.format("%.02f", temp2);
		String[] temp4=temp3.split("\\.");
		String pickString=temp4[0]+":"+temp4[1];
		temp=(int)dropTime;
		 temp1=(dropTime-temp)*(double)0.6;
		 temp2=(double)temp+temp1;
		 temp3=String.format("%.02f", temp2);
		 temp4=temp3.split("\\.");
		  String dropString=temp4[0]+":"+temp4[1];
		return String.format("%-10d%-10c%-10c%-10s%-10s%-10d\n", customerId, pickupPoint, dropPoint, pickString,
				dropString, earnings);
	}

}