import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class Seminar4_java {

    public static void main(String[] args) {
        // 1. Объявить и инициализировать связанный список в 10000 элементов случайным числом от -1024 до 1024
        List<Integer> linkedList = new LinkedList<>(); 
        List<Integer> arrayList = new ArrayList<>();
        int numberOfElems = 100_000;
        for (int i = 0; i < numberOfElems; i++) {
            linkedList.add((int) (Math.random() * 2049 - 1024));
            arrayList.add((int) (Math.random() * 2049 - 1024));    
        }
        List<Integer> copyArrayList = new ArrayList<>(arrayList); // копия для оптимизации 
        
        // 2. Пройти по списку и удалить все отрицательные элементы
        ListIterator<Integer> linkedIterator = linkedList.listIterator(); 
        long start = System.currentTimeMillis();
        while(linkedIterator.hasNext()) 
            if (linkedIterator.next() < 0)
                linkedIterator.remove();
        long end = System.currentTimeMillis();
        long period2linked = end - start; // время исполнения пункта №2 для linkedList

        ListIterator<Integer> arrayIterator = arrayList.listIterator();
        start = System.currentTimeMillis();
        while(arrayIterator.hasNext()) 
            if (arrayIterator.next() < 0)
                arrayIterator.remove();
        end = System.currentTimeMillis();
        long period2array = end - start; // время исполнения пункта №2 для arrayList  

        // 3. Скопировать в переменные и удалить из списка первый и второй элементы, сложить переменные, результат сохранить в начало списка. 
        start = System.currentTimeMillis();
        Integer a = linkedList.remove(0); // remove удаляет первый (т.е нулевой позиции) элемент из списка и возвращает при этом удаленный элемент, который получает новая переменная
        Integer b = linkedList.remove(0);
        linkedList.add(0, a + b);
        end = System.currentTimeMillis();
        long period3linked = end - start; // время исполнения пункта №3 для linkedList

        start = System.currentTimeMillis();
        a = arrayList.remove(0); 
        b = arrayList.remove(0);
        arrayList.add(0, a + b);
        end = System.currentTimeMillis();
        long period3array = end - start; // время исполнения пункта №3 для arrayList

        // 4. Реализовать пункт №3 для всего списка.
        start = System.currentTimeMillis();
        while(linkedList.size() > 1) {
            a = linkedList.remove(0);
            b = linkedList.remove(0);
            linkedList.add(0, a + b);
        }
        end = System.currentTimeMillis();
        long period4linked = end - start; // время исполнения пункта №4 для linkedList

        start = System.currentTimeMillis();
        while(arrayList.size() > 1) {
            a = arrayList.remove(0);
            b = arrayList.remove(0);
            arrayList.add(0, a + b);
        }
        end = System.currentTimeMillis();
        long period4array = end - start; // время исполнения пункта №4 для arrayList

        // 5. Измерить время исполнения пунктов №2 и №3.
        System.out.println("For LinkedList: ");
        System.out.println(String.format("Duration of task #2: %s msc", period2linked));
        System.out.println(String.format("Duration of task #3: %s msc", period3linked)); 
        System.out.println(String.format("Duration of task #4: %s msc", period4linked)); 
        
        // 6. *Реализовать пункты с первого по пятый но с ArrayList. Сравнить время исполнения.
        System.out.println("For ArrayList: ");
        System.out.println(String.format("Duration of task #2: %s msc", period2array));
        System.out.println(String.format("Duration of task #3: %s msc", period3array)); 
        System.out.println(String.format("Duration of task #4: %s msc", period4array)); 
        
        // 7. **Оптимизировать реализацию заданий так, чтобы время выполнения LinkedList и ArrayList были наименьшим.
        // для пункта №2 создаем новый ArrayList, куда будем класть только неотрицательные элементы
        // таким образом, избавимся от множественного пересоздания и перекопирования исходного arrayList в процессе удаления каждого элемента 
        start = System.currentTimeMillis();
        List<Integer> listTmp = new ArrayList<>();
        for(int i = 0; i < copyArrayList.size(); i++) 
            if(copyArrayList.get(i) >= 0)
                listTmp.add(copyArrayList.get(i));
        copyArrayList = listTmp;
        end = System.currentTimeMillis();
        period2array = end - start; // время исполнения пункта №2 для arrayList после оптимизации
        System.out.println("For ArrayList after Optimization: ");
        System.out.println(String.format("Duration of task #2: %s msc", period2array));
        // пункт №4: несложно заметить, что в результате должен получиться список из одного элемента, состоящий из алгебраич. суммы всех элементов 
        start = System.currentTimeMillis();
        int res = 0;
        arrayIterator = copyArrayList.listIterator();
        while(arrayIterator.hasNext()) 
            res += arrayIterator.next();
        copyArrayList.clear();
        copyArrayList.add(res);    
        end = System.currentTimeMillis();
        period4array = end - start; // время исполнения пункта №4 для arrayList после оптимизации
        System.out.println(String.format("Duration of task #4: %s msc", period4array));
    }
}
