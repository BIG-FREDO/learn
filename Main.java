package learn;

public class Main {

	public static void main(String[] args) {

		CarRentalSystem rentalSystem = new CarRentalSystem();

		Car car1 = new Car("C001", "Toyota", "Camry", 60.0);
		Car car2 = new Car("C002", "Honda", "Accord", 70.0);
		Car car3 = new Car("C003", "Sonata", "Mercedes", 100.0);
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);

		rentalSystem.manu();






	}


}
