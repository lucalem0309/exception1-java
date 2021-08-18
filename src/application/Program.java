package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("check-in date (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("check-out date (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());

		// test if departure date is not later than entry date
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Chech-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");

			System.out.print("check-in date (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("check-out date (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in Reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
		sc.close();
	}

}
