package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) { //significa que o método main n trata esse tipo de exceção
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("checkin date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("checkOut date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
				
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);
			
			System.out.println();
			System.out.println("Enter the data to update the reservation: ");
			System.out.print("checkIn Date: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("checkOut Date: ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}
		
		catch(ParseException e) {//tratar possiveis exceções que podem ocorrer
			System.out.println("Invalid date format!");
		}
		
		catch(DomainException e) { //caso seja uma
			System.out.println("Error in reservation " + e.getMessage()); //esse getMessage() é a mensagem em q nós passamos antes de instanciar a execeção
		}
		catch(RuntimeException e) { //consigo captar qualquer outra exeção colocando runtime exception ex: digitar letra ao inves do número pro quarto!
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
