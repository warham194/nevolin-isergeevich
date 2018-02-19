package ru.ilya.collections;

/**
 * Created by Lenovo2 on 30.01.2018.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CollectionsSravnenie {
    public static void main(String[] args) throws FileNotFoundException {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        Set<String> list3 = new TreeSet<>();
        CollectionsSravnenie col = new CollectionsSravnenie();
        int amount = 7300;
        long first = col.add(list1, amount);
        System.out.println("Время добавления элементов в список типа ArrayList равно  " + first);
        long second = col.add(list2, amount);
        System.out.println("Время добавления элементов в список типа LinkedList равно  " + second);
        long third = col.add(list3, amount);
        System.out.println("Время добавления элементов в список типа TreeSet равно   " + third);
        System.out.println(list1.size());
        long first2 =  col.del(list1, amount);
        long second2 = col.del(list2, amount);
        long third2 = col.del(list3, amount);
        System.out.println("Время удаления  элементов из Arraylist равно " + first2);
        System.out.println("Время удаления  элементов из LinkedList равно " + second2);
        System.out.println("Время удаления   элементов из TreeSet равно " + third2);
        System.out.println(list1.size());

    } // вопрос
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add("Строка №" + i);
        }
        long result = System.currentTimeMillis() - start;
        return result;
    }

    public long del(Collection<String> collection, int amount) {

        Iterator<String> iterator = collection.iterator();
        long start = System.currentTimeMillis();
        while (iterator.hasNext() && amount > 0) {
            collection.remove("Строка №" + 700); // вопрос
            amount--;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        return result;
    }
}
