package com.rlg.challenges;

public class TimeInWords {

	public static void main(String[] args) {
		
		int hour	= 1;
		int minute	= 45;

		String[] tensNames = {
				    "",
				    "",
				    "twenty",
				    "thirty",
				    "forty",
				    "fifty"
				  };

		String[] numNames = {
				    "",
				    "one",
				    "two",
				    "three",
				    "four",
				    "five",
				    "six",
				    "seven",
				    "eight",
				    "nine",
				    "ten",
				    "eleven",
				    "twelve",
				    "thirteen",
				    "fourteen",
				    "fifteen",
				    "sixteen",
				    "seventeen",
				    "eighteen",
				    "nineteen"
				  };
		
		StringBuffer result = new StringBuffer();
		StringBuffer hourWord = new StringBuffer();
		StringBuffer minuteWord = new StringBuffer();
		
		int minuteAux = minute;

		if(minuteAux > 30) {
			minuteAux = 60 - minuteAux;
			
			if(hour + 1 > 12) {
				hour = 1;
			} else {
				hour++;
			}
		} 

		hourWord.append(numNames[hour]);
		
		if(minuteAux == 15) {
			minuteWord.append("quarter");
		} else {
			if(minuteAux == 30) {
				minuteWord.append("half");
			} else {
				if(minuteAux > 19) {
					minuteWord.append(tensNames[minuteAux/10]);
					
					if(minuteAux%10 > 0) {
						minuteWord.append(" ")
									.append(numNames[minuteAux%10]);
					}
				} else {
					minuteWord.append(numNames[minuteAux]);
				}
			}
		}

		
		if(minuteAux != 15 && minuteAux != 30) {
			if(minuteAux == 1) {
				minuteWord.append(" minute");
			} else {
				minuteWord.append(" minutes");
			}
		}

		if(minute == 0) {
			result.append(hourWord)
					.append(" o' clock");
		} else {
			
			if(minute <= 30) {
				result.append(minuteWord)
						.append(" past ")
						.append(hourWord);
			} else {
				result.append(minuteWord)
						.append(" to ")
						.append(hourWord);
			}
		}
		
		
		System.out.println(result.toString());
	}

}
