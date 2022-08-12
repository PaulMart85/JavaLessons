package Seminar2_java;

public class ReverseStringByRecursion {
    
    public static String reverseString(String str) {
        if (str.length() <= 1) {
           return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
      }
    
}
