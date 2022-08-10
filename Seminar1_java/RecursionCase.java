package Seminar1_java;

class RecursionCase {
    
    public static void main(String[] args) {
        System.out.println(toBinaryString(-1));
    }

    public static int mostSignificantBitNumber(int value) {
        String binaryI = toBinaryString(value); 
            System.out.println("bit representation of i = " + binaryI);
    
            int signSearch = binaryI.contains("-") ? 1 : 0;
            return binaryI.length()-1-signSearch;  // номер старшего бита (т.е. макс степень 2-ки) - это в данном случае 
                                                    // длина строки без учета знака                                                
        }

    private static String toBinaryString(int num) {  // рекурсивный метод перевода в двоичное представление
        if (num < 0) return "-" + toBinaryString(-num);
        else {
            if (num <= 1 ) return String.valueOf(num);
            return toBinaryString(num / 2) + String.valueOf(num % 2);
        }
    }    
}
