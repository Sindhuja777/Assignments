package com.maveric.baristaapp;

import java.util.Scanner;

public class BeverageDemo {
	public static void main(String args[]) {
		System.out.println("********* Welcome to Barrista *********");
        Beverage b = null;
        mainMenu(b);
	}
		private static void mainMenu(Beverage b) {
			//System.out.println("Main Menu:\n1 for Coffee(Rs 30) \n2 for Tea(Rs 15)");
			//System.out.println("Choose your option: ");
			
			boolean flag = true;
			while(flag) {
				
				System.out.println("Main Menu:\n1 for Coffee(Rs 30) \n2 for Tea(Rs 15)");
				System.out.println("Choose your option: ");
				Scanner sc = new Scanner(System.in);
				int option = sc.nextInt();
				if(option==1) {
					b = new Coffee(30);
					addOnsMenu(b);
					flag = false;
				}
				else if(option==2) {
					b = new Tea(15);
					addOnsMenu(b);
					flag = false;
				}
				else {
					System.out.println("Enter correct choice: ");
				}
			}
		}
		private static void addOnsMenu(Beverage b) {
			boolean flag = true;
			while(flag) {
				System.out.println("Select Addons:");
				Scanner sc = new Scanner(System.in);
	            System.out.println("1 for Caramel (Rs.20)" + "\n2 for Chocolate (Rs.30)" + "\n3 for Cream(Rs.35)"
	                    + "\n4 for Honey(Rs.10)" + "\n5 Exit");
	           int addon = sc.nextInt();
	           
	           if(addon==1) {
	        	   b = new Caramel(b,20);
	           }
	           else if(addon==2) {
	        	   b = new Chocolate(b,30);
	           }
	           else if(addon==3) {
	        	   b = new Chocolate(b,35);
	           }
	           else if(addon==4) {
	        	   b = new Chocolate(b,10);
	           }
	           else if(addon==5){
	        	   printDetails(b);
	        	   flag = false;
	           }
	           else
	        	   flag = false;
			}
		}
	private static void printDetails(Beverage c) {
		System.out.println("Cost:  "+ c.getCost() + ", Description: " + c.getDescription()+" ");
		System.out.println("Thank You..! Visit Again!!");
	}
}
