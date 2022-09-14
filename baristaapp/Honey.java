package com.maveric.baristaapp;

public class Honey extends BeverageDecorator{
	
	private int cost;
	
	public Honey(Beverage beverage,int cost){
		this.beverage = beverage;
		this.cost = cost;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + "with Honey";
	}
	
	@Override
	public int getCost() {
		return beverage.getCost() + cost;
	}
}
