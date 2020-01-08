package com.rlg.challenges;

public class AppleOrangeHouseDistance {

	public static void main(String[] args) {
		//House region
		int s = 7; 
		int t = 11;
		
		//Apple tree location
		int a = 5; 
		
		//Orange tree location
		int b = 15;
		
		//Apples thrown in units distance
		int[] apples = {-2, 2, 1};  

		//Oranges thrown in units distance
		int[] oranges = {5, -6};
		
		int applesCount = 0;
		int orangesCount = 0;
		
		for(int app : apples) {
			
			if(app + a >= s && app + a <= t) {
				applesCount++;
			}
		}
		
		System.out.println(applesCount);

		for(int ora : oranges) {
			
			if(ora + b >= s && ora + b <= t) {
				orangesCount++;
			}
		}

		System.out.println(orangesCount);

	}

}
