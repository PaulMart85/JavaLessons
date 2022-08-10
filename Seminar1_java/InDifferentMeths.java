package Seminar1_java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InDifferentMeths {
    public static void main(String[] args) {
        // 1. Выбросить случайное целое число и сохранить в i
        int i = randomI();
        System.out.println("random i = " + i);
        
        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        // int n = mostSignificantBitNumber(i);
        int n = RecursionCase.mostSignificantBitNumber(i);
        System.out.println("most significant bit number of i is n = " + n);        

        // 3. Найти все кратные n числа большие i и сохранить в массив m1
        int m1[] = multipleAndGreaterNumbers(n, i);

        // 4. Найти все некратные n числа меньшие i и сохранить в массив m2
        int m2[] = nonRepeatedAndLessNumbers(n, i);        

        // 5. Сохранить оба массива в файлы с именами m1 и m2 соответственно
        saveFiles(m1, m2);
    }

    private static int randomI() {
        return new Random().nextInt(2022) - 1011; //  случайное целое в диапазоне (-1011; 1011)
    }

    private static int mostSignificantBitNumber(int value) {
        String binaryI = Integer.toBinaryString(value);  // i в двоичное представление, когда говорим о битах
        System.out.println("bit representation of i = " + binaryI);

        return binaryI.length()-1;  // номер старшего бита (т.е. макс степень 2-ки) - это в данном случае 
                                    // длина строки; биты, отвечающие за знак, также включил в расчет                                                
    }

    private static int[] multipleAndGreaterNumbers(int n, int i) {
        int min = i+1, 
            max = 1010; // выбор max произвольный

        int[] m1 = new int[(int)(Math.abs((max-min)/n)+1)]; 
        while(min%n != 0) min++;  // находим первое кратное n целое число, большее i
        for (int k = 0; min < max; min += n, k++) {
            m1[k] = min;
        }
        return m1;
    }

    private static int[] nonRepeatedAndLessNumbers(int n, int i) {
        int min = -1010,  // выбор min произвольный
        max = i;

        int[] m2 = new int[(int)(max-min - Math.abs((max-min)/n))]; 
        for (int k = 0; min < max; min++) 
            if (min%n != 0) 
                m2[k++] = min;
        
        return m2;
    }

    private static void saveFiles(int[] m1, int[] m2) {
        try (FileWriter fos = new FileWriter(new File("m1.txt")))
		{
			for (int j = 0; j < m1.length; j++) {
                fos.append(String.valueOf(m1[j]));
                fos.append("\n");
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

        try (FileWriter fos = new FileWriter(new File("m2.txt")))
		{
			for (int j = 0; j < m2.length; j++) {
                fos.append(String.valueOf(m2[j]));
                fos.append("\n");
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
