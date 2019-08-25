package com.hippo.taxi.model;
public class Taxi {
   private char initialPoint;
   private double departureTime;
    private int earnings;
    
    public char getInitialPoint() {
		return initialPoint;
	}
	public void setInitialPoint(char initialPoint) {
		this.initialPoint = initialPoint;
	}
	
	public double getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(double departureTime) {
		this.departureTime = departureTime;
	}
	public int getEarnings() {
		return earnings;
	}
	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}
	
	public Taxi()
    {
        initialPoint='A';
    }
    public void departureTime(double pickTime,char pick,char drop)
    {
        this.departureTime=(pickTime+(Math.abs(pick-drop)));
    }
    public void calculateEarnings(char pick,char drop)
    {
        int dist=(Math.abs(pick-drop)*15);
        int amount=((dist-5)*10)+100;
        this.earnings=earnings+amount;
    }
      
  
}