
package learn;

public class Car {

String carId;
String brand;
String model;
double basePricePerDay;
boolean isAvailable;

public Car(String carId, String brand, String model, double basePricePerDay){

this.carId = carId;
this.brand = brand;
this.model = model;
this.basePricePerDay = basePricePerDay;
this.isAvailable = true;

}


public String getCarId(){
return carId;
}


public String getBrand(){
return brand;
}


public String getModel(){
return model;
}


public double calculatePrice(int rentalDays){
return basePricePerDay * rentalDays;
}


public boolean isAvailable(){
return isAvailable;
}


public void rentCar(){
isAvailable = false;
}

public void returnCar(){
isAvailable = true; 
}






}
