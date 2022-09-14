package com.maveric.baristaapp;

public class Cream extends BeverageDecorator{
	
	private int cost;
	
	public Cream(Beverage beverage,int cost){
		this.beverage = beverage;
		this.cost = cost;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + "with Cream";
	}
	
	@Override
	public int getCost() {
		return beverage.getCost() + cost;
	}
}
