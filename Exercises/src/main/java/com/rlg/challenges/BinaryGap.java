package com.rlg.challenges;

public class BinaryGap {

	public static void main(String[] args) {
		String binary = Integer.toBinaryString(1041);
		System.out.println(binary);
		
		int sum = 0;
		int indexFirst = -1;
		int indexNext = -1;
		for(int i = 0 ; i < binary.length() ; i++) {
			
			if(binary.charAt(i) == '1') {
				if(indexFirst == -1) {
					indexFirst = i;
				} else {
					indexNext = i;
					
					if((indexNext - indexFirst)-1 > sum) {
						sum = (indexNext - indexFirst)-1;
					}

					indexFirst = indexNext;
					indexNext = -1;
				}
			}
		}
		
		System.out.println(sum);

	}

}
