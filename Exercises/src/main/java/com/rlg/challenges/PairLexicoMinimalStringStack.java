package com.rlg.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PairLexicoMinimalStringStack {

	public static List<Character> convStringToCharacterList(String value) {
		
		StringBuilder rev = new StringBuilder(value).reverse();
		
		return Arrays.asList(rev.chars()
									.mapToObj(letter -> (char) letter)
									.toArray(Character[]::new)
							);
	}
	
	public static void main(String[] args) {
		String a = "DANIEL";
		String b = "JACK";
		String res = "";
		
		Stack<Character> stackA = new Stack<Character>();
		stackA.addAll(convStringToCharacterList(a.toUpperCase()));

		Stack<Character> stackB = new Stack<Character>();
		stackB.addAll(convStringToCharacterList(b.toUpperCase()));
		
		while(stackA.size() > 0 || stackB.size() > 0) {

			if(!stackA.isEmpty() && !stackB.isEmpty()) {
				if(stackA.peek() <= stackB.peek()) {
					res += stackA.pop();
				} else {
					res += stackB.pop();
				}
			} else {
				if(stackA.isEmpty()) {
					res += stackB.pop();
				} else {
					res += stackA.pop();
				}
			}
		}
		
		System.out.println(res);
	}

}
