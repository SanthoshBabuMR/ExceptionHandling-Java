package com.babusa.io;
import java.io.*;


public class CompareIO {
  static String inFileStr = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/io/helloworld-in.txt";
  static String outFileStr1 = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/io/helloworld-out.txt";

  public static void main(String[] args) {
    try (FileInputStream fi1 = new FileInputStream(inFileStr);
         FileOutputStream fo1 = new FileOutputStream(outFileStr1)) {
      int n;
      Long s = System.nanoTime();
      while( (n=fi1.read()) != -1) {
//                System.out.println(n);
        fo1.write(n);
      }
      System.out.println("Time elapsed for single: " + ((System.nanoTime() - s) / 1000000.0) + " msecs");
    }catch(Exception e){
      e.printStackTrace();
    }


    try (FileInputStream fi2 = new FileInputStream(inFileStr);
         FileOutputStream fo2 = new FileOutputStream(outFileStr1)) {
      byte[] b = new byte[20];
      Long s = System.nanoTime();
      int n;
      while( (n=fi2.read(b)) != -1) {
//                System.out.println(n);
        fo2.write(b);
      }
      System.out.println("Time elapsed for group: " + ((System.nanoTime() - s) / 1000000.0) + " msecs");
    }catch(Exception e){
      e.printStackTrace();
    }

    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inFileStr));
         BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFileStr1))) {
      byte[] b = new byte[8];
      Long s = System.nanoTime();
      int n;
      while( (n=bis.read(b)) != -1) {
//                System.out.println(n);
        bos.write(b);
      }
      System.out.println("Time elapsed for buffered: " + ((System.nanoTime() - s) / 1000000.0) + " msecs");
    }catch(Exception e){
      e.printStackTrace();
    }

  }


}
