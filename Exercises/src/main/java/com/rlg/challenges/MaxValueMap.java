package com.rlg.challenges;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxValueMap {

	public static void main(String[] args) {

		int ar[] = {3, 2, 1, 3,};
		
		Map<Integer, Long> candles = Arrays.stream(ar)
											.boxed()
											.collect(Collectors.groupingBy(x -> x, Collectors.counting()));
		
		//System.out.println(candles.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());
		
		System.out.println(candles.values()
							.stream()
							.max(Comparator.comparingInt(x -> x.intValue())).get()) ;
		
	}

}
