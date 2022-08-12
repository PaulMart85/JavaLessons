import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Seminar3_java {
    
    public static void main(String[] args) {
        // 1. Напишите программу, чтобы создать новый список массивов, добавить несколько цветов (строку) и вывести коллекцию на экран. 
        List<String> list = new ArrayList<>();                
        list.add("blue");
        list.add("green");
        list.add("red");
        list.add("yellow");
        System.out.println("Init list is " + list);

        // 2. Напишите программу для итерации всех элементов списка цветов и добавления к каждому символа '!'.
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
          it.set(it.next().concat("!"));
        }
        System.out.println(list);

        // 3. Напишите программу для вставки элемента в список массивов в первой позиции.
        String myElem = "grey";
        list.add(0, myElem);
        System.out.println("list after inserting elem at first position is " + list);

        // 4. Напишите программу для извлечения элемента (по указанному индексу) из заданного списка. 
        int index = 1;
        System.out.println(list.get(index));

        // 5. Напишите программу для обновления определенного элемента массива по заданному элементу. 
        String chosenElem = "green!";
        String changeTo = "white"; 
        list.set(list.indexOf(chosenElem), changeTo);
        System.out.println("list after updating given elem is " + list);

        // 6. Напишите программу для удаления третьего элемента из списка массивов. 
        list.remove(3); // третий элемент в списке
        System.out.println("list after deleting given elem is " + list);

        // 7. Напишите программу для поиска элемента в списке массивов. 
        String findElem = "yellow!";
        if (list.contains(findElem)) System.out.println("Elem found in position " + Collections.binarySearch(list, findElem));
        else System.out.println("Elem not found");

        // 8. Напишите программу для сортировки заданного списка массивов. 
        Collections.sort(list);
        System.out.println("sorted list is " + list);

        // 9. Напишите программу для копирования одного списка массивов в другой. 
        List<String> anotherList = new ArrayList<>(list);
        // /*или*/ List<String> anotherList = List.copyOf(list);
        System.out.println("List copied is " + anotherList);

    }
}
