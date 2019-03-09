package com.babusa.exceptions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResourcesDemo {
    static String inFileStr = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/exceptions/goku.jpg";
    static String outFileStr = "/Users/babusa/Documents/webster/project/ExceptionHandling-Java/src/com/babusa/exceptions/goku-out.jpg";

    public static void fileCopyWithArm() throws IOException {
        System.out.println("\nInside fileCopyWithArm");

        try(Test t = new Test(); Test2 t2 = new Test2(); BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }
        }
    }

    public static void main(String[] args) {
        try {
            fileCopyWithArm();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}

class Test implements AutoCloseable{
    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception");
    }
}

class Test2 implements AutoCloseable{
    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception 2");
    }
}