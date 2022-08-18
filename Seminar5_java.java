import java.util.HashMap;
import java.util.Map;

public class Seminar5_java {

    public static void main(String[] args) {
        // 1. Объявить и инициализировать словарь hashMap<String, String>
        System.out.println("Инициализация словаря:");
        Map<String, String> dict = new HashMap<>(); 
        System.out.println(dict);
        System.out.println();

        // 2. Добавить в словарь 10 пар "Ключ - Значение". Автор и название книги например.
        System.out.println("Добавление 10 пар значений:");
        dict.put("Достоевский Ф.М.", "Преступление и наказание");
        dict.put("Чехов А.П.", "Степь");
        dict.put("Пушкин А.С.", "Повести Белкина");
        dict.put("Чертов О.В.", "Вновь стану светом");
        dict.put("Толстой Л.Н.", "Война и мир");
        dict.put("Островский Н.А.", "Как закалялась сталь");
        dict.put("Полевой Б.А.", "Повесть о настоящем человеке");
        dict.put("Есенин С.А.", "Стихи. Избранное");
        dict.put("Крылов И.А.", "Все басни");
        dict.put("Wells Gerbert", "War of the Worlds");
        System.out.println(dict);
        System.out.println();

        // 3. Пройти по словарю и добавить к значениям символ "!" 
        System.out.println("Добавление к значениям символа '!':");
        dict.replaceAll((k, v) -> v + "!");
        System.out.println(dict);
        System.out.println();

        // 4. Добавить нового автора и название книги если соответствующего ключа не было.
        System.out.println("Добавление нового несуществующего автора и книги:");
        dict.putIfAbsent("Wells Gerbert", "The invisible man"); // словарь останется без изменений
        dict.putIfAbsent("Державин Г.Р.", "Властителям и судьям"); 
        System.out.println(dict);
        System.out.println();

        // 5. Если ключ, указанный в запросе, имеется, вырезать из соответствующего ключу значения первое слово.
        System.out.println("Удаление первого слова в значении по заданному ключу:");
        String key = "Чехов А.П.";
        dict.computeIfPresent(key, (k, v) -> v.contains(" ") ? v.substring(v.indexOf(' ')+1): "");

        key = "Полевой Б.А.";
        dict.computeIfPresent(key, (k, v) -> v.contains(" ") ? v.substring(v.indexOf(' ')+1): "");

        key = "Крылов"; // такого ключа нет - изменение в словаре не произойдет 
        dict.computeIfPresent(key, (k, v) -> v.contains(" ") ? v.substring(v.indexOf(' ')+1): "");
        System.out.println(dict);
        System.out.println();

        // 6. *Пройти по словарю другим, не таким как в пункте 3, методом и вывести пары ключ значение в консоль.
        System.out.println("Проход словаря другим методом:");
        dict.forEach((k,v) -> System.out.printf("%s = %s\n", k, v));        
        System.out.println();

        // 7. ** Пройти по словарю другим, не таким как в пункте 3 и 6, методом. 
        // Добавить к значениям строку "(просмотрен)" и вывести в консоль.
        System.out.println("Проход словаря еще одним методом и добавление значениям '(просмотрен)'':");
        for (String currentKey : dict.keySet()) {
            dict.compute(currentKey, (k, v) -> v.concat("(просмотрен)"));
            System.out.printf("%s = %s\n", currentKey, dict.get(currentKey));        
        }
        System.out.println();
    }
    
}
