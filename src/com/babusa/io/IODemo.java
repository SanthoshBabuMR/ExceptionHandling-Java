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
        System.out.println("lastModified(): " + f.lastModified()); // time in milliseconds since 1970 jan 1
        System.out.println("exists(): " + f.exists());
        System.out.println("isFile(): " + f.isFile());
        System.out.println("isDirectory(): " + f.isDirectory());
        System.out.println("length(): " + f.length());

        System.out.println("My Working or user directory: " + System.getProperty("user.dir"));
        System.out.println("new File(\"tesdir\").mkdir(): " + new File("testdir").mkdir());
        System.out.println("new File(\"tesdir/test\").mkdir(): " + new File("testdir/test").mkdir());
        System.out.println("new File(\"tesdir\").delete(): " + new File("testdir").delete());
        System.out.println("new File(\"testdir/test1/test2\").mkdir(): " + new File("testdir/test1/test2").mkdir());
        System.out.println("new File(\"testdir/test1/test2\").mkdirs(): " + new File("testdir/test1/test2").mkdirs());

        try {
            File f2 = new File("temp.txt");
            System.out.println("f2.createNewFile(): "  + f2.createNewFile());
            System.out.println("f2.renameTo(...): " + f2.renameTo(new File("testdir/temp1.txt")));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void dirFilter(boolean applyFilter) {
        System.out.println("\nInside dirFilter...");

        File path = new File(".");
        String[] list;

        if(!applyFilter) {
            list = path.list();
        } else {
            list = path.list(new DirFilter());
        }

        for (String dirItem:list) {
            System.out.println(dirItem);
        }
    }

    public static void main(String[] args) {
        //fileCopyNoBuffer();
        // fileCopyWithBufferAndArray();
        // System.out.println(System.getProperty("file.encoding"));
        // readFromStandardInput();
        // fileMethodsDemo();
        // dirFilter(true);

        // serialization

        if (args.length > 0 && args[0].equals("true")) {
            new IODemo().doSerialization();
        }
        new IODemo().doDeserialization();

    }

    public void doSerialization() {
        System.out.println("\nInside doSerialization...");

        SerializableDemo serializableDemo = new SerializableDemo();
        serializableDemo.setName("Java");
        System.out.println("name (before serialization): " + serializableDemo.getName());
        System.out.println("id (before serialization): " + serializableDemo.getId());

        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("java-obj.ser")))) {
            out.writeObject(serializableDemo);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void doDeserialization() {
        System.out.println("\nInside doDeserialization...");

        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("java-obj.ser")))) {
            SerializableDemo serializableDemo = (SerializableDemo) in.readObject();
            System.out.println("name (after serialization): " + serializableDemo.getName());
            System.out.println("id (after serialization): " + serializableDemo.getId());

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // By convention, static nested classes should be placed before static methods
    public static class SerializableDemo implements Serializable {
        // static final long serialVersionUID = 8882416210786165012L;
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        private transient  int id = 4;
        public int getId() { return id; }

        // private String gender;

    }
}




class DirFilter implements FilenameFilter {
    // Holds filtering criteria
    public boolean accept(File file, String name) {
        return name.endsWith(".jpg") || name.endsWith(".JPG");
    }
}