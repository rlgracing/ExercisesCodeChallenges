package com.rlg.challenges;

public class BuildingStringCost {

	public static void main(String[] args) {
		
		String	s			= "acbbqbbqbb";
		int		appendCost	= 1;
		int		copyCost	= 3;
		
		StringBuffer	result		= new StringBuffer(s.length());
		int				totalCost	= 0;
		int				i			= 0;
		while(i < s.length()) {
			
			if(result.length() < 3) {
				result.append(s.charAt(i));
				totalCost += appendCost;
				System.out.println(appendCost + " " + s.charAt(i));
				i++;
			} else {
				
				int k = (s.length() - i) > 3 ? 3 : s.length() - i;
				String aux = s.substring(i, i+k);
				System.out.println(aux);
				
				while(k > 1 && result.indexOf(aux) < 0) {
					
					k--;

					aux = s.substring(i, i+k);
					
					System.out.println(aux);
				}

				if(aux.length() > 1) {
					totalCost += copyCost;
					System.out.println(copyCost + " " + aux);
				} else {
					totalCost += appendCost;
					System.out.println(appendCost + " " + aux);
				}

				i += k;
				result.append(aux);
			}
		}
		
		System.out.println(s.length() + " " + appendCost + " " + copyCost);
		System.out.println(s);
		System.out.println(totalCost);
	}
}
