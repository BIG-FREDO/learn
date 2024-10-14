package learn;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CarRentalSystem {

List<Car> cars;
List<Rental> rentals;
List<Customer> customers;

public CarRentalSystem(){

cars = new ArrayList<>();
rentals = new ArrayList<>();
customers = new ArrayList<>();

}


public void addCar(Car car){

cars.add(car);

}



public void addRental(Rental rental){

rentals.add(rental);

}



public void addCustomer(Customer customer){

customers.add(customer);

}



public void rentCar(Car car, Customer customer, int days){

if(car.isAvailable()){

car.rentCar();
rentals.add(new Rental(car, customer, days));

}
else{System.out.println("Car is not available for rent.");}

}



public void returnCar(Car car){

car.returnCar();
Rental rentalToRemove = null;


for(Rental rental: rentals){


if(rental.getCar() == car){

rentalToRemove = rental;
break;

}
}


if(rentalToRemove != null){

rentals.remove(rentalToRemove);
System.out.println("Car returned successfully.");

}
else{System.out.println("Car was not returned.");}

}


public void manu() {

Scanner in = new Scanner(System.in);

while(true) {

System.out.println("\n==== Car Rental System ====\n");
System.out.println("1. Rent a Car");
System.out.println("2. Return a Car");
System.out.println("3. Exit");
System.out.print("Enter your choice: " );

int choice = in.nextInt();
in.nextLine();

if(choice == 1) {

System.out.println("\n==== Rent a Car ====\n");
System.out.print("Enter your name: " );
String customerName = in.nextLine();


System.out.println("\n====== Available Cars ======");

	for(Car car : cars) {

		if(car.isAvailable()) {

			System.out.println(car.getCarId() + " " + car.getBrand() + " " + car.getModel());
		}
	}


System.out.print("Enter the car's ID you want to rent: " );
String carId = in.nextLine();

System.out.print("Enter the number of days for rental: " );
int rentalDays = in.nextInt();
in.nextLine();

Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
addCustomer(newCustomer);

	Car selectedCar = null;
	for(Car car : cars) {

		if(car.getCarId().equals(carId) && car.isAvailable()) {

			selectedCar = car;
			break;
		}
	}


	if(selectedCar != null) {

		double totalPrice = selectedCar.calculatePrice(rentalDays);
		System.out.println("\n== Rental Information ==\n");
		System.out.println("Customer ID: " + newCustomer.getCustomerId());
		System.out.println("Customer Name: " + newCustomer.getName());
		System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
		System.out.println("Rental Days: " + rentalDays);
		System.out.printf("Total Price: $%.2f%n", totalPrice);

		System.out.print("\nConfirm Rental (Y/N): ");
		String confirm = in.nextLine();

			if(confirm.equalsIgnoreCase("Y")) {

				rentCar(selectedCar, newCustomer, rentalDays);
			}
			else {
				System.out.println("\nIvalid car selection or car not available for rent.");
			}

	}

}
else if(choice == 2) {

System.out.println("\n== Return a Car ==\n");
System.out.print("Enter the car ID you want to return: " );
String carId = in.nextLine();

Car carToReturn = null;

	for(Car car : cars) {

		if(car.getCarId().equals(carId) && !car.isAvailable()){

			carToReturn = car;
			break;
		}
	}


	if(carToReturn != null) {

		Customer customer = null;

	for(Rental rental: rentals) {

		if(rental.getCar() == carToReturn) {

			customer = rental.getCustomer();
			break;
		}
	}


	if(customer != null) {

		returnCar(carToReturn);
		System.out.println("Car returned successfully by: " + customer.getName());

	} else {

		System.out.println("Car was not rented or rental information missing.");
	}

	} else {
		System.out.println("Invalid ID or car is not rented.");
	}


}

else if(choice == 3) {

break;

} else { 

System.out.println("Invalid choice. Please enter a valid option.");

}

}
System.out.println("Thank you for using the Car rental System!");

}

}









