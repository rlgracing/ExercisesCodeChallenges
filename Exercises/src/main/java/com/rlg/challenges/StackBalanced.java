package com.rlg.challenges;

import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.standard.MediaSize.Other;

public class StackBalanced {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String value = in.nextLine();
		
		in.close();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < value.length() ; i++) {
			if(!stack.isEmpty()) {
				switch(value.charAt(i)) {
					case '}':
					{
						if(stack.peek() == '{') {
							stack.pop();
						}
						break;
					}
					case ')':
					{
						if(stack.peek() == '(') {
							stack.pop();
						}
						break;
					}
					case ']':
					{
						if(stack.peek() == '[') {
							stack.pop();
						}
						break;
					}
					default :
					{
						stack.push(value.charAt(i));
						break;
					}
				}
			} else {
				stack.push(value.charAt(i));
			}
		}
		
		System.out.println(stack.isEmpty());

	}

}
