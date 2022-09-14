package com.maveric.baristaapp;

public class Caramel extends BeverageDecorator{
	private int cost;
	
	public Caramel(Beverage beverage, int cost) {
		this.beverage = beverage;
		this.cost = cost;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + "with Caramel";
	}
	
	@Override
	public int getCost() {
		return beverage.getCost() + cost;
	} 
}
