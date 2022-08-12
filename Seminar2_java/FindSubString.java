package Seminar2_java;

import java.util.HashSet;
import java.util.Set;

public class FindSubString {
    
    public static String leastSubString(String initStr, String condStr) {
        boolean noMatchesAtAll = true;  // указатель, если в исходной строке не найдено ни одного окна строки условия 
        Set<Character> condStrWithUniqueElems = new HashSet<>();
        // помещаем condStr в Set, чтобы получить уникальные элементы condStr
        for (Character ch : condStr.toCharArray()) {
            condStrWithUniqueElems.add(ch);
        }

        int windowSize = condStrWithUniqueElems.size(); // размер наименьшего возможного окна

        if (initStr.length() < windowSize) 
            return String.format("Initial string must be greater then %d in length", windowSize-1);


        Set<Character> flag = new HashSet<>(condStrWithUniqueElems);
        StringBuilder res = new StringBuilder(); // промежуточный (текущее подходящее окно) результат
        StringBuilder result = new StringBuilder(initStr); // конечный результат
        int index = 0;
        char ch;
        while (index < initStr.length()) {
            ch = initStr.charAt(index);
            if (!condStrWithUniqueElems.contains(ch)) { // при появлении первого символа вне строки условия исходная строка урезается
                res.setLength(0);
                initStr = initStr.substring(initStr.indexOf(ch)+1);
                flag = new HashSet<>(condStrWithUniqueElems);
                index = 0;
            }
            else {
                res.append(ch);
                flag.remove(ch);
                if (flag.isEmpty()) { // случай, когда при поиске окна в исходной строке найдены все символы строки условия
                    noMatchesAtAll = false;
                    if (res.length() < result.length()) {
                        result.setLength(0);
                        result.append(res);
                    } 
                    res.setLength(0);    
                    initStr = initStr.substring(1);
                    flag = new HashSet<>(condStrWithUniqueElems);
                    index = 0;
                }
                else index++;
            }
        }

        return noMatchesAtAll ? "Substring not found" : result.toString();
    }
}
