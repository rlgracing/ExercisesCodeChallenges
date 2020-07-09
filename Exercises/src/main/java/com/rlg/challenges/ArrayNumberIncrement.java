package com.rlg.challenges;

import java.util.Arrays;

public class ArrayNumberIncrement {

	public static void main(String[] args) {
		
		int digits[] = {1,2,3};
		increment(digits, 7);

	}
	
	public static int[] increment(int[] digits, int amount) {

		if(amount <= 0 || amount >= 10) {
			return digits;
		}
		
		int paramDigitsLength = digits.length;
		int[] temp = new int[paramDigitsLength];
		for(int i = 0 ; i < paramDigitsLength ; i++) {
			temp[i] = digits[i];
		}
		
		int incrementPrior = amount;
		for(int i = paramDigitsLength-1 ; i >= 0 && incrementPrior > 0 ; i--) {
			
			int subtotal = temp[i] + incrementPrior;
			if(subtotal < 10) {
				
				temp[i] = subtotal; 
				incrementPrior = 0;			
			} else { 
				
				temp[i] = subtotal % 10;
				incrementPrior = subtotal / 10;
			}
		}

		int[] result;
		if(incrementPrior > 0) {
			
			result = new int[paramDigitsLength + 1];
			result[0] += incrementPrior;
		} else {

			result = new int[paramDigitsLength];
		}

		int startFrom = result.length - paramDigitsLength;
		for(int i = startFrom ; i < result.length ; i++) {
			result[i] = temp[i-startFrom];
		}
		
		System.out.println(Arrays.toString(digits) + " - " + Arrays.toString(result));
		
		return result;
	}

}
