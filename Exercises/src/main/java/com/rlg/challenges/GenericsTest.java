package com.rlg.challenges;

import java.util.Arrays;

public class GenericsTest {

	public static void printArray(Object[] values) {
		System.out.println(Arrays.asList(values));
	}
	
	public static void main(String[] args) {
		String[] values = {"ssda", "sdasd", "hghfghfg", "dfdsf"};
		Integer[] nums	= {1,2,3,4,5};
		
		printArray(values);
		printArray(nums);
	}

}
