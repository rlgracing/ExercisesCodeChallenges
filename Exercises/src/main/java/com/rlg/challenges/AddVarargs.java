package com.rlg.challenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddVarargs {

	public static void add(int... values) {
		String lista = Arrays.stream(values)
							.boxed()
							.map(a -> a.toString())
							.collect(Collectors.joining("+","","="));
		
		int sum = Arrays.asList(values)
						.stream()
						.flatMapToInt(value -> IntStream.of(value))
						.sum();
		
		System.out.println(lista + sum);
		
		sum = 0;
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i]);
			
			sum+=values[i];
			
			if(i < values.length-1)
				System.out.print("+");
		}
		System.out.println("="+sum);
		
	}
	public static void main(String[] args) {
		add(1);
		add(1,2);
		add(1,2,3);
		add(1,2,3,4);
		add(1,2,3,4,5);

	}

}
