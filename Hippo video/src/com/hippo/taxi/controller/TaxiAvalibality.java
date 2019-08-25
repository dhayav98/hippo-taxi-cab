package com.hippo.taxi.controller;

import com.hippo.taxi.model.Taxi;
import com.hippo.taxi.model.TaxiBooking;

public class TaxiAvalibality {

	   public int taxiAvailablity(Taxi[] t,TaxiBooking booking) 
	   {
		   
	       int j,min=6,temp=-1;
	       for(j=0;j<t.length;j++)
	       {
	          if(Math.abs(booking.getPickupPoint()-t[j].getInitialPoint())<=min && t[j].getDepartureTime()<=booking.getPickupTime())
	          {
	                if(temp==-1 || Math.abs(booking.getPickupPoint()-t[j].getInitialPoint())<min ) 
	                 temp=j;
	             if(Math.abs(booking.getPickupPoint()-t[j].getInitialPoint())==min)  
	             {
	                 if(t[temp].getEarnings()>t[j].getEarnings()) 
	                 temp=j;
	             }
	             min= Math.abs(booking.getPickupPoint()-t[j].getInitialPoint());
	             
	          }
	       }
	       if(min!=6){
	           t[temp].departureTime(booking.getPickupTime(),booking.getPickupPoint(),booking.getDropPoint());
	           t[temp].setInitialPoint(booking.getDropPoint());
	           booking.setTaxiNumber(temp);
	           return temp;
	           } 
	       return -1;
	   }
	
}
