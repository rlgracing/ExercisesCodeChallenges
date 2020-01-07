package com.rlg.challenges;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Palindrome {

	public static void main(String[] args) {


		String word = "rotor";
		
		String value = word;
		
		boolean palindrome = true;

		while(value.length() > 1) {
			
			if(value.charAt(0) == value.charAt(value.length() - 1)) {
				value = value.substring(1, value.length() -1);
			} else {
				
				palindrome = false;
				break;
			}
		}
		
		System.out.println(word + " is palindrome: " + palindrome);
		System.out.println(word + " is palindrome StringBuilder: " + new StringBuilder(word).reverse().toString().equals(word));

		System.out.println(new BigInteger(String.valueOf(173)).isProbablePrime(1));
	}

}
