package com.rlg.challenges;
import java.util.StringTokenizer;

public class RPNMyWrongApproach {
	
	public static void main(String[] args) {
		
		String rpn = "3 4 + 5 - 6 + 10 * 4 /";
		
		System.out.println(calculate(rpn));
	}
	
	public static int calculate(String rpn) {
		
		StringTokenizer stn = new StringTokenizer(rpn, " ");
		
		int result = 0;
		
		while(stn.hasMoreTokens()) {

			int a = result != 0 ? result : Integer.parseInt(stn.nextToken());
			int b = Integer.parseInt(stn.nextToken());
			String operator = stn.nextToken();
			
			switch(operator) {
			case "+"	:	result = a+b; break;
			case "-"	:	result = a-b; break;
			case "*"	:	result = a*b; break;
			case "/"	:	result = a/b; break;
			default		:	result = 0; break;
			}
		}
		
		return result;
	}
}
