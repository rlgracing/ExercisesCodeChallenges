package com.rlg.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumTime {

	public static void main(String[] args) {
		
		int[] files = {1,2,5,10,35,89};
		
		Integer[] sizes = Arrays.stream(files)
								.boxed()
								.toArray(Integer[]::new);
		
		List<Integer> listSizes = new ArrayList<Integer>(Arrays.asList(sizes));
		
		List<Integer> listAux = new ArrayList<Integer>();
		while(listSizes.size() >= 2) {
			
			listSizes.sort(Comparator.comparing(x -> x));

			int aux = listSizes.get(0) + listSizes.get(1);
					
			listAux.add(aux);
			
			listSizes.remove(0);
			listSizes.remove(0);

			listSizes.add(aux);
		}

		int sum = listAux.stream()
							.mapToInt(x -> x.intValue())
							.sum();
		
		System.out.println(sum);
		
	}

}
