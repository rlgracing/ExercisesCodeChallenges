package com.rlg.challenges;
import java.util.Stack;
import java.util.StringTokenizer;

public class RPNJavaStackApproach {
	
	public static void main(String[] args) {
		
		String rpn = "5 1 2 + 4 * + 3 -";
		
		try {
			System.out.println(calculate(rpn));
		
		} catch(Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}
	
	public static int calculate(String rpn) throws Exception{
		
		StringTokenizer stn = new StringTokenizer(rpn, " ");
		
		Stack<String> stack = new Stack<String>();
		
		while(stn.hasMoreTokens()) {
			
			String item = stn.nextToken();

			if("+-*/".contains(item)) {
				
				if(stack.isEmpty()) {
					throw new Exception("Empty stack!!!");
				}
				
				if(stack.size() < 2) {
					throw new Exception("Missing operand!!!");
				}
				
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				int result = 0;

				switch(item) {
					case "+"	:	result = a+b; break;
					case "-"	:	result = a-b; break;
					case "*"	:	result = a*b; break;
					case "/"	:	result = a/b; break;
				}
				
				item = String.valueOf(result);
			}
			
			try {

				Integer.parseInt(item);
				
			} catch(Exception ex) {
				throw new Exception("Operand not a number!!!");
			}
			
			stack.push(item);
		}
		
		if(stack.isEmpty()) {
			return 0;
		} else {
			return Integer.parseInt(stack.pop());
		}
	}
}
