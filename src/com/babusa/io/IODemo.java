package com.babusa.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/io/data.txt");
            int i;
            while((i = fis.read()) != -1) {
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("File not found!");
        }

    }
}