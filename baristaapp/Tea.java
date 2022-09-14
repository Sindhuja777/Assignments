package com.maveric.baristaapp;

public class Tea implements Beverage{
	int cost;
	
	public Tea(int cost) {
		this.cost = cost;
	}
	@Override
	public int getCost(){
		return cost;
	}
	
	@Override
	public String getDescription(){
		return "Tea";
	}

}
