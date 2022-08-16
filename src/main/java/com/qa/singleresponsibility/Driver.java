package com.qa.singleresponsibility;

public class Driver {
	// Driving the car and setting the mileage is not a responsibility of the car class
		//Drivers need a car to drive, connects to car class
		public void drive (Car car, int milesDriven) {
			car.setMileage(car.getMileage() + milesDriven);
		}
		
		public void changetyres(Car car, Boolean changetyres) {
			changetyres = true;
			System.out.println("\n Tyres have been changed.");
		}
}
