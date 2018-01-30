package ru.ilya.collections;

/**
 * Created by Lenovo2 on 30.01.2018.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class CollectionSpeed {
    public static void main(String[] args) throws FileNotFoundException {


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        Set<String> list3 = new TreeSet<>();
        CollectionSpeed col = new CollectionSpeed();
        int amount = 7300;
        long a = col.add(list1,amount);
        System.out.println("Время добавления элементов в список типа ArrayList равно  " + a);
        long b = col.add(list2,amount);
        System.out.println("Время добавления элементов в список типа LinkedList равно  " + b);
        long c = col.add(list3,amount);
        System.out.println("Время добавления элементов в список типа TreeSet равно   " + c);
        long d =  col.del(list1,amount);
        long f = col.del(list2,amount);
        long g = col.del(list3,amount);
        System.out.println("Время удаления  разных по индексу элементов из Arraylist равно " + d);
        System.out.println("Время удаления  разных элементов из LinkedList равно " + f);
        System.out.println("Время удаления  разных элементов из TreeSet равно " + g);

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
        long start=System.currentTimeMillis();
        while( iterator.hasNext() && amount > 0) {
            collection.remove(""); // вопрос
            amount--;
        }
        long end = System.currentTimeMillis();
        long result = end - start;
        return result;
    }
    }

