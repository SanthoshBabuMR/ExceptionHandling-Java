package com.babusa.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {
	
	public static void send(int destination, String data, String partner)
		throws
//			FileNotFoundException,
			IOException {
		System.out.println("\n Inside send...");
		
		if (destination == 0) {
			throw new FileNotFoundException();
		} else if (destination == 1) {
			throw new IOException();
		}

		System.out.println("\n End of send...");
	}
}
