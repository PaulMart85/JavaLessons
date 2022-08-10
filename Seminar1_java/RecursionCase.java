package Seminar1_java;

class RecursionCase {

    public static int mostSignificantBitNumber(int value) {
        if (value < 0) return 31;
        else {
            String binaryI = toBinaryString(value);
            System.out.println("bit representation of i = " + binaryI);
    
            return binaryI.length()-1;
        }                                                
    }

    private static String toBinaryString(int num) {  // рекурсивный метод перевода в двоичное представление
        if (num <= 1 ) return String.valueOf(num);
        return toBinaryString(num / 2) + String.valueOf(num % 2);
    }    
}
