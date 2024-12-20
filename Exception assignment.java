/*
 * Summary:
 * This program showcases exception handling in Java by simulating realistic scenarios for both
 * checked and unchecked exceptions. Each example demonstrates triggering and handling the
 * exception with clear explanations.
 */

import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamplesV2 {
    public static void main(String[] args) {
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();
        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }

    // Example of IOException
    private static void handleIOException() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"));
            System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException handled: Error during file operations.");
        }
    }

    // Example of FileNotFoundException
    private static void handleFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("unknown.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException handled: File does not exist.");
        }
    }

    // Example of EOFException
    private static void handleEOFException() {
        try {
            DataInputStream dataInput = new DataInputStream(new ByteArrayInputStream(new byte[0]));
            dataInput.readUTF();
        } catch (EOFException e) {
            System.out.println("EOFException handled: End of file reached.");
        } catch (IOException e) {
            System.out.println("IOException handled: " + e.getMessage());
        }
    }

    // Example of SQLException
    private static void handleSQLException() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:invalid:url", "user", "pass");
        } catch (SQLException e) {
            System.out.println("SQLException handled: Database connection error.");
        }
    }

    // Example of ClassNotFoundException
    private static void handleClassNotFoundException() {
        try {
            Class.forName("NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException handled: Class not found.");
        }
    }

    // Example of ArithmeticException
    private static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException handled: Division by zero.");
        }
    }

    // Example of NullPointerException
    private static void handleNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled: Null object accessed.");
        }
    }

    // Example of ArrayIndexOutOfBoundsException
    private static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] array = {1, 2, 3};
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled: Invalid array index.");
        }
    }

    // Example of ClassCastException
    private static void handleClassCastException() {
        try {
            Object obj = "String";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException handled: Invalid type casting.");
        }
    }

    // Example of IllegalArgumentException
    private static void handleIllegalArgumentException() {
        try {
            Thread thread = new Thread();
            thread.setPriority(-1); // Invalid priority
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: Invalid argument.");
        }
    }

    // Example of NumberFormatException
    private static void handleNumberFormatException() {
        try {
            int num = Integer.parseInt("abc123");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: Invalid number format.");
        }
    }
}
