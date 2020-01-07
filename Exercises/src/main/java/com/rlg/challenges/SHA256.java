package com.rlg.challenges;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.xml.bind.DatatypeConverter;

public class SHA256 {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		Scanner in = new Scanner(System.in);
		String value = in.nextLine();
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		byte[] result = md.digest(value.getBytes());
		
		System.out.println(DatatypeConverter.printHexBinary(result).toLowerCase());
		
		in.close();
	}

}
