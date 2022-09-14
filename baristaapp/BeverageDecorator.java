package com.maveric.baristaapp;

abstract class BeverageDecorator implements Beverage{
	protected Beverage beverage;
	
	@Override
	public abstract String getDescription();
	
}
