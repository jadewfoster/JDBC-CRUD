package com.qa.singleresponsibility;

public class Mechanic {
	
	public void addspoiler(Boolean spoiler) {
		car.setSpoiler(spoiler) ;
		System.out.println("\n Spoiler has been added.");
	}
	
	private Car car;

	public void setCar(Car car) {
		this.car = car;
	}
	
	
}
