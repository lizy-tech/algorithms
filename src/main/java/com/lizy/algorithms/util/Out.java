package com.lizy.algorithms.util;

import java.io.*;
import java.net.Socket;
import java.util.Locale;

public class Out {
    private static final String CHARSET_NAME = "UTF-8";
    private static final Locale LOCALE = Locale.US;
    private PrintWriter out;

    public Out(OutputStream os) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(os, CHARSET_NAME);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Out() {
        this(System.out);
    }

    public Out(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, CHARSET_NAME);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Out(String filename) {
        try {
            OutputStream os = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(os, CHARSET_NAME);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        out.close();
    }

    public void println() {
        out.println();
    }

    public void println(Object x) {
        out.println(x);
    }

    public void println(boolean x) {
        out.println(x);
    }

    public void println(char x) {
        out.println(x);
    }

    public void println(double x) {
        out.println(x);
    }

    public void println(float x) {
        out.println(x);
    }

    public void println(int x) {
        out.println(x);
    }

    public void println(long x) {
        out.println(x);
    }

    public void println(byte x) {
        out.println(x);
    }

    public void print() {
        out.flush();
    }

    public void print(Object x) {
        out.print(x);
        out.flush();
    }

    public void print(boolean x) {
        out.print(x);
        out.flush();
    }

    public void print(char x) {
        out.print(x);
        out.flush();
    }

    public void print(double x) {
        out.print(x);
        out.flush();
    }

    public void print(float x) {
        out.print(x);
        out.flush();
    }

    public void print(int x) {
        out.print(x);
        out.flush();
    }

    public void print(long x) {
        out.print(x);
        out.flush();
    }

    public void print(byte x) {
        out.print(x);
        out.flush();
    }

    public void printf(String format, Object... args) {
        out.printf(LOCALE, format, args);
        out.flush();
    }

    public void printf(Locale locale, String format, Object... args) {
        out.printf(locale, format, args);
        out.flush();
    }

    public static void main(String[] args) {
        Out out;

        // write to stdout
        out = new Out();
        out.println("Test 1");
        out.close();

        // write to a file
        out = new Out("test.txt");
        out.println("Test 2");
        out.close();
    }
}
