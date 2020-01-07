package com.rlg.challenges;

public class GCDRecursive {

	public static int gcd(int a, int b) {
		
		if (a == 0)
			return b;
		
		return gcd(b % a, a);
	}
	
	public static int arrayGcd(int[] values) {
		
		int res = values[0];
		
		for (int i = 1; i < values.length; i++) {
			
			res = gcd(values[i], res);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] values = {25, 41};
		
		System.out.println(arrayGcd(values));
		
	}

}
