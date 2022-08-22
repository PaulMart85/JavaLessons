import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Seminar6_java {

    public static void main(String[] args) {
        // 1. Объявить и инициализировать множества HashSet hs, LinkedHashSet lhs и TreeSet ts
        System.out.println("Объявление множеств:");
        Set<Integer> hs = new HashSet<>();
        Set<Integer> lhs = new LinkedHashSet<>();
        Set<Integer> ts = new TreeSet<>();
        System.out.printf("hs -> %s - множество HashSet\n", hs);
        System.out.printf("lhs -> %s - множество LinkedHashSet\n", lhs);
        System.out.printf("ts -> %s - множество TreeSet\n", ts);
        System.out.println();


        // 2. Добавить в множества по 10 случайных целочисленных ключей.
        System.out.println("Добавление 10 случайных целочисленных ключей:");
        Random rand = new Random();
        int x;
        for (int i = 0; i < 10; i++) {
            do {
                x = rand.nextInt(20);
            } while(hs.contains(x));
            hs.add(x);

            do {
                x = rand.nextInt(20);
            } while(lhs.contains(x));
            lhs.add(x);

            do {
                x = rand.nextInt(20);
            } while(ts.contains(x));
            ts.add(x);
        }
        System.out.println("hs -> " + hs);
        System.out.println("lhs -> " + lhs);
        System.out.println("ts -> " + ts);
        System.out.println();

        // 3. Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs
        System.out.println("Удаление из hs ключей, совпадающих с lhs:");
        hs.removeAll(lhs);  // или foreach и contains
        System.out.println("hs -> " + hs);
        System.out.println();

        // 4. Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts
        System.out.println("Добавление в ts ключей, отсутствующих из lhs:");
        ts.addAll(lhs);  // или foreach и contains
        System.out.println("ts -> " + ts);
        System.out.println();

        // 5. Объявить и инициализировать множество TreeSet ts1 с компаратором Integer 
        // (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). 
        // Заполнить ts1 15 случайными числами и вывести на печать.
        System.out.println("Инициализация множества ts1 с компаратором:");
        Set<Integer> ts1 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1==t2 ? 0 : t2%2==0 ? -1 : 1;
            }   
        });
        for (int i = 0; i < 15; i++) {
            do {
                x = rand.nextInt(20);
            } while(ts1.contains(x));
            ts1.add(x);
        }
        System.out.println("ts1 -> " + ts1);
        System.out.println();

        // 6. *Объявить и инициализировать множество TreeMap tm с компаратором Integer 
        // (-1 при значении  %2==0 ;0 при ==;1 при значении %2!=0). 
        // Заполнить tm 15 случайными числами и вывести на печать.
        System.out.println("Инициализация множества tm с компаратором:");
        Map<Integer, Object> tm = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t1==t2 ? 0 : t2%2==0 ? -1 : 1;
            }   
        });
        for (int i = 0; i < 15; i++) {
            do {
                x = rand.nextInt(15);
            } while(tm.containsKey(x));
            tm.put(x, null);  // значения по всем ключам null, т.е. в java heap ничего не выделяется 
        }
        System.out.println("tm -> " + tm.keySet());  // вывод множества ключей, все значения null
        System.out.println();
    }
    
}
