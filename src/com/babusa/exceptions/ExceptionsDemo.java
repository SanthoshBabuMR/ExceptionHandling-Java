package com.babusa.exceptions;

import java.io.FileNotFoundException;

public class ExceptionsDemo {
	public static void main(String[] args) {
		System.out.println("\n Inside main...");
		share();
		System.out.println("\n End of main...");
	}
	
	private static void share() {
		System.out.println("\n Inside share...");
		try {
			HttpConnect.send(0, "hello", "http://www.goodsnips.com");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("\n End of share...");
	}
}
