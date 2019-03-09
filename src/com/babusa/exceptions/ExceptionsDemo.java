package com.babusa.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsDemo {
	public static void main(String[] args) {
		System.out.println("\n Inside main...");
		try {
			share();
			System.out.println(" After invoking share ... ");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(" main: FileNotFoundException ");
		}
		finally {
			System.out.println(" Inside main's finally ...");
		}
		System.out.println("\n End of main...");
	}
	
	private static void share() throws FileNotFoundException {
		System.out.println("\n Inside share...");
		try {
			HttpConnect.send(0, "hello", "http://www.goodsnips.com");
		}
		catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println(" Share:FileNotFoundException ...");
			throw e;
		}
		catch (IOException e) {
			System.out.println(" Connecting to a different server...");
		}
//		catch (Exception e) { }
//		catch(Throwable e) { }
		finally {
			System.out.println(" Inside share's finally...");
		}

		System.out.println("\n End of share...");
	}
}
