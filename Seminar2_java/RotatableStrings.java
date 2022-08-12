package Seminar2_java;

public class RotatableStrings {

    public static boolean isRotatableStrings(String str1, String str2) {
        return str1.equals(new StringBuilder(str2).reverse().toString());
    }
}