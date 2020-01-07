package com.rlg.challenges;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PairLexicoMinimalString {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\Grigoriu-Notebook\\Downloads\\input01 - Copia.txt"));
		
		bf.readLine();
		
		StringBuffer a = new StringBuffer(bf.readLine());
		StringBuffer b = new StringBuffer(bf.readLine());

//		StringBuffer a = new StringBuffer("JACK");
//		StringBuffer b = new StringBuffer("DANIEL");
		
		bf.close();
		
		StringBuffer res = new StringBuffer();
		
		int i = 0;
		int j = 0;
		
		while(i < a.length() && j < b.length()) {

			if(a.charAt(i) < b.charAt(j)) {
				res.append(a.charAt(i));
				i++;
			} else {
				if(a.charAt(i) == b.charAt(j)) {

					String partA = a.substring(i);
					String partB = b.substring(j);
					
					int al = partA.length();
					int bl = partB.length();
					int lim = al <= bl ? al : bl;
					
					for(int k = 0 ; k < lim; k++) {
					
						if(partA.charAt(k) != partB.charAt(k)) {
						
							if(partA.charAt(k) < partB.charAt(k)) {
								res.append(a.charAt(i));
								i++;
							} else {
								res.append(b.charAt(j));
								j++;
							}
							
							break;
						}
					}
					
				} else {
					res.append(b.charAt(j));
					j++;
				}
			}
//			System.out.println("i " + i + " a " + a.length() + " -  j " + j + " b " + b.length());
		}
		
		if(a.length() == i) {
			res.append(b.substring(j));
		} else {
			if(b.length() == j) {
				res.append(a.substring(i));
			}
		}

		
//		System.out.println(res.toString());
		
		BufferedWriter fw = new BufferedWriter(new FileWriter("C:\\Users\\Grigoriu-Notebook\\Downloads\\outputRlg.txt"));
		fw.write(res.toString());
		fw.close();
	}

}
