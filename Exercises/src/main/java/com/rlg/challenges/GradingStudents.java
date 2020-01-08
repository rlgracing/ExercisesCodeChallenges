package com.rlg.challenges;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {

	public static void main(String[] args) {

		List<Integer> grades = Arrays.asList(73, 67, 38, 33);
		
		System.out.println(grades.stream()
									.map(grade -> {
										if(grade == 0 || grade == 100 || grade < 38) {
											return grade;
										}
										else {
											int mod = grade % 10;
											if(mod < 5 && (5 - mod) < 3) {
												return ((grade / 10)*10) + 5;
											}
											else {
												if(mod < 10 && (10 - mod) < 3) {
													return (((grade / 10) + 1)*10);
												}
												else {
													return grade;
												}
											}
										}
									})
									.collect(Collectors.toList()));
	}

}
