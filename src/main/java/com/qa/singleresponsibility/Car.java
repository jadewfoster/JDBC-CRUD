package com.qa.singleresponsibility;

//POJO - Plain Old Java Object
//Responsibility of this class is to define a car so we can make our objects

public class Car {

		//Class properties
	
	private String colour;
	private String mode;
	private int mileage;
	private int bhp;
	private Boolean changetyres;
	private Boolean spoiler;
	private int rideheight;
	
	public Car(String colour, String mode, int mileage, int bhp, Boolean changetyres, Boolean spoiler, int rideheight) {
		super();
		this.colour = colour;
		this.mode = mode;
		this.mileage = mileage;
		this.bhp = bhp;
		this.changetyres = changetyres;
		this.spoiler = spoiler;
		this.rideheight = rideheight;
	}
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getBhp() {
		return bhp;
	}
	public void setBhp(int bhp) {
		this.bhp = bhp;
	}
	public Boolean getChangetyres() {
		return changetyres;
	}
	public void setChangetyres(Boolean changetyres) {
		this.changetyres = changetyres;
	}
	public Boolean getSpoiler() {
		return spoiler;
	}
	public void setSpoiler(Boolean spoiler) {
		this.spoiler = spoiler;
	}
	public int getRideheight() {
		return rideheight;
	}
	public void setRideheight(int rideheight) {
		this.rideheight = rideheight;
	}
	
	
	
}
