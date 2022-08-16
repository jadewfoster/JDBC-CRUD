package com.qa.singleresponsibility;

public class Runner {

	public static void main(String[] args) {
		Car bmw = new Car("Black", "BMW", 5000, 250, false, false, 30);
		
		//Constructed using default constructor
		Driver jade = new Driver();
		
		System.out.println("Current Mileage: " + bmw.getMileage());
		
		jade.drive(bmw, 500);
		
		System.out.println("New Mileage: " + bmw.getMileage());
		
		jade.changetyres(bmw, false);
		
		Mechanic mech1 = new Mechanic();
		mech1.setCar(bmw);
		mech1.addspoiler(true);
	}
}
