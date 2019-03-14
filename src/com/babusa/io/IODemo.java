package com.semanticsquare.io;

import java.io.*;
import java.util.Scanner;

public class IODemo {
    static String inFileStr = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/io/in-commons-lang3-3.8.1-bin.tar.gz";
    static String outFileStr = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/io/out-commons-lang3-3.8.1-bin-out.tar.gz";

    public static void fileCopyNoBuffer() {
        System.out.println("\nInside fileCopyNoBuffer ...");

        long startTime, elapsedTime; // for speed benchmarking

        // Print file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");

        try (FileInputStream in = new FileInputStream(inFileStr);
             FileOutputStream out = new FileOutputStream(outFileStr)) {
            startTime = System.nanoTime();
            int byteRead;
            // Read a raw byte, returns an int of 0 to 255.
            while ((byteRead = in.read()) != -1) {
                // Write the least-significant byte of int, drop the upper 3
                // bytes
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Most common way to read byte streams from a file
    public static void fileCopyWithBufferAndArray() {
        System.out.println("\nInside fileCopyWithBufferAndArray ...");

        long startTime, elapsedTime; // for speed benchmarking
        startTime = System.nanoTime();
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {

            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        elapsedTime = System.nanoTime() - startTime;
        System.out.println("fileCopyWithBufferAndArray: " + (elapsedTime / 1000000.0) + " msec");
    }

    public static void readFromStandardInput() {
        System.out.println("\nInside readFromStandardInput ...");
        String data;

        /*
        System.out.println("Enter \"start\" to continue (Using BufferedReader): ");

        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
            while((data = in.readLine()) != null && !data.equals("start")) {
                System.out.println("\n Did not enter \"start\". Try again: ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Correct!!");
        */

        System.out.println("\nEnter \"start\" to continue (Using java.util.Scanner): ");
        Scanner scanner = new Scanner(System.in);

        while(!(data = scanner.nextLine()).equals("start")) {
            System.out.println("\n Did not enter \"start\". Try again: ");
        }

        System.out.println("Now, enter the start code");
        int code = scanner.nextInt(); // other methods: nextLong, nextDouble
        System.out.println("Thanks, you entered code: " + code);

        Scanner s1 = new Scanner("Hello, how are you?");
        while(s1.hasNext()) {
            System.out.println(s1.next());
        }

    }

    public static void fileMethodsDemo(){
        System.out.println("\nInside fileMethodsDemo...");
        File f = new File("/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/../goku-file.jpg");

        System.out.println("getAbsolutePath(): " + f.getAbsoluteFile());
        try {
            System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
            System.out.println("createNewFile(): " + f.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("separator: " + f.separator); // dir separator in path name (string type)
        System.out.println("separatorChar: " + f.separatorChar); // dir separator in path name (char type)
        System.out.println("getParent(): " + f.getParent());
        System.out.println("lastModified(): " + f.lastModified());
        System.out.println("exists(): " + f.exists());
        System.out.println("isFile(): " + f.isFile());
        System.out.println("isDirectory(): " + f.isDirectory());
        System.out.println("length(): " + f.length());
        System.out.println("(): " + f);
        System.out.println("(): " + f);


    }

    public static void main(String[] args) {
        //fileCopyNoBuffer();
        // fileCopyWithBufferAndArray();
        // System.out.println(System.getProperty("file.encoding"));
        // readFromStandardInput();
        fileMethodsDemo();
        // dirFilter(false);
    }

}
