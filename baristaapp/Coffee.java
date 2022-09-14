package com.maveric.baristaapp;

public class Coffee implements Beverage{
	
	int cost;
	
	public Coffee(int cost) {
		this.cost = cost;
	}
	@Override
	public int getCost(){
		return cost;
	}
	
	@Override
	public String getDescription(){
		return "Coffee";
	}
}
