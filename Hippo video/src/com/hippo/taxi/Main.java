package com.hippo.taxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hippo.taxi.controller.TaxiAvalibality;
import com.hippo.taxi.model.Taxi;
import com.hippo.taxi.model.TaxiBooking;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int i = 0, j = 0;
		List<TaxiBooking> bookingList = new ArrayList<>();
		System.out.println("Enter the number of taxies :");
		int numberOfTaxi = scanner.nextInt();
		Taxi[] taxi = new Taxi[numberOfTaxi];
		for (i = 0; i < numberOfTaxi; i++) {
			taxi[i] = new Taxi();
		}
		i = 0;
		while (true) {
			System.out.println("\n");
			System.out.println("***************HIPPO CAB SERVICE***************");
			System.out.println("1)Call taxi booking");
			System.out.println("2)Display the Taxi details");
			System.out
					.println("3)Display the current ongoing trips and its remaining time to reach\r\n" + "the destiny");
			System.out.println("4)Exit");
			System.out.println("Enter your choice");
			int ch = scanner.nextInt();

			if (ch > 4 || ch < 1) {
				System.out.println("Invalid Input");
				return;
			}
			if (ch == 1) {
				TaxiAvalibality taxiAvalibality = new TaxiAvalibality();
				System.out.println("Input " + (i + 1) + ":");
				System.out.println("Customer Id");
				int id = scanner.nextInt();
				System.out.println("Pickup Point:");
				scanner.nextLine();
				char pick = scanner.nextLine().charAt(0);
				System.out.println("Drop Point:");
				char drop = scanner.nextLine().charAt(0);
				System.out.println("Pickup Time: as hh:mm");
				String pickt = scanner.next();
				String[] temp1 = pickt.split(":");
				Double pickTime = Double.parseDouble(temp1[0]) + (Double.parseDouble(temp1[1]) / (double) 60);
				TaxiBooking taxiBooking = new TaxiBooking(id, pick, drop, pickTime);
				int a;
				a = taxiAvalibality.taxiAvailablity(taxi, taxiBooking);

				if (a != -1) {
					System.out.println("Taxi can be allotted.");
					System.out.println("Taxi-" + (a + 1) + " is alloted");

					taxi[a].calculateEarnings(taxiBooking.getPickupPoint(), taxiBooking.getDropPoint());

					taxiBooking.dropTime();
					taxiBooking.calculateEarnings();
					bookingList.add(taxiBooking);
				} else
					System.out.println("Booking is rejected");
				i++;
				}
				else if (ch == 2) {
				System.out.format("%-10s%-10s\n", "Taxi No:", "Total Earnings:");
				System.out.format("%-10s%-13s%-10s%-10s%-13s%-10s%-10s\n", "BookingID", "CustomerId", "From", "To",
						"PickupTime", "DropTime", "Amount");

				for (int k = 0; k < numberOfTaxi; k++) {
					if (taxi[k].getEarnings() != 0) {
						System.out.println(
								"Taxi-" + (k + 1) + "    " + "Total Earnings:" + "Rs . " + taxi[k].getEarnings());
						for (j = 0; j < bookingList.size(); j++) {
							if (bookingList.get(j).getTaxiNumber() == k) {

								System.out.format("%-10d", j + 1);
								System.out.println(bookingList.get(j));
							}

						}
					}
				}
			} 
				else if (ch == 3) {
				System.out.println("Enter the current time (hh:mm) :");
				String currentt = scanner.next();
				String[] temp2 = currentt.split(":");
				Double currentTime = Double.parseDouble(temp2[0]) + (Double.parseDouble(temp2[1]) / (double) 60);

				System.out.println("Taxi Number \t Source \t Destination \t Remaining Time(mins)");

				for (j = 0; j < bookingList.size(); j++) {

					if (currentTime >= bookingList.get(j).getPickupTime()
							&& currentTime <= bookingList.get(j).getDropTime()) {
						double temp6 = currentTime;
						double remainingTime = bookingList.get(j).getDropTime() - temp6;
						int temp7 = (int) remainingTime;
						double temp8 = (remainingTime - temp7) * (double) 60;
						temp7 = (temp7 * 60);
						temp7 += temp8;
						System.out.println(
								bookingList.get(j).getTaxiNumber() + 1 + "\t\t\t" + bookingList.get(j).getPickupPoint()
										+ "\t\t" + bookingList.get(j).getDropPoint() + "\t\t" + temp7 + " mins");

					}

				}

			} 
				else if (ch == 4) {
				System.out.println("***************Thank You***************");
				return;
			}
		}

	}

}
