package Seminar2_java;


public class Seminar2_java {
    public static void main(String[] args) {
        // 1. Напишите программу, чтобы найти наименьшее окно в строке, содержащее все символы другой строки.
        String initStr = "dhda d s ddlPa2asa";  // исходная строка
        String condStr = "sad sdda";            // строка условия
        System.out.println(FindSubString.leastSubString(initStr, condStr));

        // 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга.
        String str1 = "12hGu0P",
               str2 = "P0uGh21",
               str3 = "lOplk21";       
        System.out.println(String.format("%s and %s are rotatable, that's %b", 
                           str1, str2, RotatableStrings.isRotatableStrings(str1, str2)));
        
        System.out.println(String.format("%s and %s are rotatable, that's %b", 
                           str1, str3, RotatableStrings.isRotatableStrings(str1, str3)));

        // 3. Напишите программу, чтобы перевернуть строку с помощью рекурсии.
        String myString = "You never know where you are with the wether";
        System.out.println(ReverseStringByRecursion.reverseString(myString));

        // 4. Даны два числа. Необходимо составить строки арифметических действий +, - и *.
        int a = 3,
            b = 56;
        
        System.out.println(ArithmeticStrings.arithStr(a, b, '+'));
        System.out.println(ArithmeticStrings.arithStr(a, b, '-'));
        System.out.println(ArithmeticStrings.arithStr(a, b, '*'));

        // 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(), StringBuilder.deleteCharAt(). 
        StringBuilder sb = new StringBuilder(ArithmeticStrings.arithStr(a, b, '+'));
        int index = sb.indexOf("=");
        sb.deleteCharAt(index);
        sb.insert(index, "равно");
        System.out.println(sb.toString());

        // 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
        sb = new StringBuilder(ArithmeticStrings.arithStr(a, b, '-'));
        index = sb.indexOf("=");
        sb.replace(index, index+1, "равно");
        System.out.println(sb.toString());


    }

    
    
}
