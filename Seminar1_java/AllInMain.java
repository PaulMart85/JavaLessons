package Seminar1_java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class AllInMain {
    public static void main(String[] args) {

        // 1. Выбросить случайное целое число и сохранить в i
        int i = new Random().nextInt(2022) - 1011; //  случайное целое в диапазоне (-1011; 1011)
        System.out.println("random i = " + i);

        // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        String binaryI = Integer.toBinaryString(i);  // i в двоичное представление, когда говорим о битах
        System.out.println("bit representation of i = " + binaryI);

        int n = binaryI.length()-1;  // номер старшего бита (т.е. макс степень 2-ки) - это в данном случае 
                                    // длина строки; биты, отвечающие за знак, также включил в расчет
        System.out.println("most significant bit number of i is n = " + n);        

        // 3. Найти все кратные n числа большие i и сохранить в массив m1
        int min = i+1, 
            max = 1010; // выбор max произвольный

        int[] m1 = new int[(int)(Math.abs((max-min)/n)+1)]; 
        while(min%n != 0) min++;  // находим первое кратное n целое число, большее i
        for (int k = 0; min < max; min += n, k++) {
            m1[k] = min;
            // System.out.println(m1[k]);
        }

        // 4. Найти все некратные n числа меньшие i и сохранить в массив m2
        min = -1010;  // выбор min произвольный
        max = i;

        int[] m2 = new int[(int)(max-min - Math.abs((max-min)/n))]; 
        for (int k = 0; min < max; min++) {
            if (min%n != 0) m2[k++] = min;
            // System.out.println(m2[k]);
        }

        // 5. Сохранить оба массива в файлы с именами m1 и m2 соответственно
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