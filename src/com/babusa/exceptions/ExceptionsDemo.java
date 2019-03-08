package com.babusa.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
	public static void main(String[] args) {
		System.out.println("\n Inside main...");
		share();
		System.out.println("\n End of main...");
	}
	
	private static void share() {
		System.out.println("\n Inside share...");
		try {
			HttpConnect.send(1, "hello", "http://www.goodsnips.com");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Connecting to a different server");
		}
		catch (Exception e) { }
		catch(Throwable e) { }
		System.out.println("\n End of share...");
	}
}
