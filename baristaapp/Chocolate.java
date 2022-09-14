package com.maveric.baristaapp;

public class Chocolate extends BeverageDecorator{

	private int cost;
	
	public Chocolate(Beverage beverage,int cost){
		this.beverage = beverage;
		this.cost = cost;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + "with Chocolate";
	}
	
	@Override
	public int getCost() {
		return beverage.getCost() + cost;
	}

}
