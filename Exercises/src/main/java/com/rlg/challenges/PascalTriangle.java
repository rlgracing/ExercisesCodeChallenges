package com.rlg.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalTriangle {

	public static void main(String[] args) {
		int rows = 5;
		int[] cel = {2,1};
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for(int i = 1 ; i <= rows ; i++) {
			
			List<Integer> list = new ArrayList<Integer>();
			for(int j = 0; j < i ; j++) {
				
				if(j == 0 || j == i-1) {
					list.add(1);
				} else {
					
					List<Integer> tempList = map.get(i-1);

					int sum = tempList.get(j-1) + tempList.get(j);
					
					list.add(sum);
				}
			}

			map.put(i , list);
		}
		
		System.out.println(map.toString());
	}

}
