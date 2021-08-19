package com.mphasis.main.cui;

import java.io.*;

class OnlyExt implements FilenameFilter {
    String ext;

    public OnlyExt(String ext) {
        this.ext = "." + ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        File f1 = new File("/java/COPYRIGHT/trial/test.txt");
        p("File Name: " + f1.getName());
        p("Path: " + f1.getPath());
        p("Abs Path: " + f1.getAbsolutePath());
        p("Parent: " + f1.getParent());
        p(f1.exists() ? "exists" : "does not exist");
        p(f1.canWrite() ? "is writeable" : "is not writeable");
        p(f1.canRead() ? "is readable" : "is not readable");
        p("is " + (f1.isDirectory() ? "" : "not" + " a directory"));
        p(f1.isFile() ? "is normal file" : "might be a named pipe");
        p(f1.isAbsolute() ? "is absolute" : "is not absolute");
        p("File last modified: " + f1.lastModified());
        p("File size: " + f1.length() + " Bytes");
        System.out.println();

        String dirname = "/java";
        f1 = new File(dirname);

        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String s[] = f1.list();

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    System.out.println(s[i] + " is a directory");
                } else {
                    System.out.println(s[i] + " is a file");
                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
        System.out.println();

        dirname = "/java";
        f1 = new File(dirname);
        FilenameFilter only = new OnlyExt("html");
        String s[] = f1.list(only);

        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println();

        int size = 0;
        InputStream f =
                null;
        try {
            f = new FileInputStream("src/FileInputStreamDemo.java");
            size = f.available();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Total Available Bytes: " +
                    (size = f.available()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int n = size / 40;
        System.out.println("First " + n +
                " bytes of the file one read() at a time");
        for (int i = 0; i < n; i++) {
            try {
                System.out.print((char) f.read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("\nStill Available: " + f.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading the next " + n +
                " with one read(b[])");
        byte b[] = new byte[n];
        try {
            if (f.read(b) != n) {
                System.err.println("couldn't read " + n + " bytes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b, 0, n));
        try {
            System.out.println("\nStill Available: " + (size = f.available()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Skipping half of remaining bytes with skip()");
        try {
            f.skip(size / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Still Available: " + f.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading " + n / 2 + " into the end of array");
        try {
            if (f.read(b, n / 2, n / 2) != n / 2) {
                System.err.println("couldn't read " + n / 2 + " bytes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b, 0, b.length));
        try {
            System.out.println("\nStill Available: " + f.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        String source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        byte buf[] = source.getBytes();
        try (OutputStream f0 = new FileOutputStream("file1.txt")) {
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream f3 = new FileOutputStream("file2.txt")) {
            f3.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream f4 = new FileOutputStream("file3.txt")) {
            f4.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Here are some numeric values " +
                "in different formats.\n");

        System.out.printf("Various integer formats: ");
        System.out.printf("%d %(d %+d %05d\n", 3, -3, 3, 3);

        System.out.println();

        System.out.printf("Default floating-point format: %f\n",
                1234567.123);
        System.out.printf("Floating-point with commas: %,f\n",
                1234567.123);
        System.out.printf("Negative floating-point default: %,f\n",
                -1234567.123);
        System.out.printf("Negative floating-point option: %,(f\n",
                -1234567.123);

        System.out.println();

        System.out.printf("Line-up positive and negative values:\n");
        System.out.printf("% ,.2f\n% ,.2f\n",
                1234567.123, -1234567.123);
        System.out.println();


        try (FileOutputStream fout = new FileOutputStream("Test.dat");
             DataOutputStream out = new DataOutputStream(fout)) {
            out.writeDouble(98.6);
            out.writeInt(1000);
            out.writeBoolean(true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileInputStream fin = new FileInputStream("Test.dat");
             DataInputStream in = new DataInputStream(fin)) {
            double d = in.readDouble();
            int i = in.readInt();
            boolean bool = in.readBoolean();

            System.out.println("Here are the values:  " +
                    d + " " + i + " " + bool);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileReader fr = new FileReader("src/FileReaderDemo.java");
             BufferedReader br = new BufferedReader(fr)) {
            ;
            String s1;

            while ((s1 = br.readLine()) != null) {
                System.out.println(s1);
            }

            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        source = "Now is the time for all good men\n"
                + " to come to the aid of their country\n"
                + " and pay their due taxes.";
        char buffer[] = new char[source.length()];
        source.getChars(0, source.length(), buffer, 0);

        try (FileWriter f0 = new FileWriter("file1.txt");
             FileWriter fw1 = new FileWriter("file2.txt");
             FileWriter f2 = new FileWriter("file3.txt")
        ) {
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }
            fw1.write(buffer);
            f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);

        } catch (IOException e) {
            e.printStackTrace();
        }
   /*     String str;
    Console con;

    con = System.console();

     // If no console available, exit.
    if(con == null) return;

    str = con.readLine("Enter a string: ");
    con.printf("Here is your string: %s\n", str);

    */
     FileReader fr;
    try {
      if (args.length == 0) { // We're working with stdin
        wc(new InputStreamReader(System.in));
      }
      else { // We're working with a list of files

        for (int i = 0; i < args.length; i++) {
          fr = new FileReader(args[i]);
          wc(fr);
        }
      }
    }
    catch (IOException e) {
      return;
    }
    System.out.println(lines + " " + words + " " + chars);

    }
    public static int words = 0;
  public static int lines = 0;
  public static int chars = 0;

  public static void wc(InputStreamReader isr)
    throws IOException {
    int c = 0;
    boolean lastWhite = true;
    String whiteSpace = " \t\n\r";

    while ((c = isr.read()) != -1) {
      // Count characters
      chars++;
      // Count lines
      if (c == '\n') {
        lines++;
      }
      // Count words by detecting the start of a word
      int index = whiteSpace.indexOf(c);
      if(index == -1) {
        if(lastWhite == true) {
          ++words;
        }
        lastWhite = false;
      }
      else {
        lastWhite = true;
      }
    }
    if(chars != 0) {
      ++lines;
    }
  }
    public static void p(String s) {
        System.out.println(s);
    }
}
