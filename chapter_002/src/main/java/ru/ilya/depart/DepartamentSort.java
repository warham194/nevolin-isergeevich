package ru.ilya.depart;

/**
 * Created by Lenovo2 on 15.03.2018.
 */
import java.util.*;

/**
 * Created by Lenovo2 on 03.03.2018.
 */
public class DepartamentSort {
    /**
     * Метод добавление недостающих элементов.
     * @param list original list
     */

    private void addTheMissingDepartament(List<String> list) {
        List<String> depart = new ArrayList<>();
        String sub;
        for (String dep : list) {
            if (dep.contains("\\")) {
                for (int index = 0; index != dep.length(); index++) {
                    index = dep.indexOf("\\", index);
                    if (index == -1) {
                        break;
                    }
                    sub = dep.substring(0, index);
                    if (!list.contains(sub) && !depart.contains(sub)) {
                        depart.add(sub);
                    }
                }
            }
        }
        if (depart.size() > 0) {
            list.addAll(depart);
        }
    }
    /**
     * Метод сравнения для компаратора.
     * @param o1 первая сравниваемая строка.
     * @param o2 втрая сравниваемая строка.
     * @param vspom 1 или -1 зависят от прямого порядка или обратного порядка сортировки.
     * @return result.
     */
    private int compareWithSign(String o1, String o2, int vspom) {
        int result;
        int length1 = o1.length();
        int length2 = o2.length();
        int length = length1 < length2 ? length1 : length2;
        int result1 = o1.substring(0, length).compareTo(o2.substring(0, length));
        if (result1 == 0) {
            result = length1 < length2 ? -1 : 1;
        } else {
            result = vspom * result1;
        }
        return result;
    }
    /**
     * Сортировка
     * @param list
     * @return отсортированный список
     */
    public List<String> sortByDirect(List<String> list) {
        addTheMissingDepartament(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareWithSign(o1, o2, 1);
            }
        });
        return list;
    }
    /**
     * Сортировка в обратном порядке
     * @param list t
     * @return отсортированный список
     */
    public List<String> sortByRevers(List<String> list) {
        addTheMissingDepartament(list);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return compareWithSign(o1, o2, -1);
            }
        });
        return list;
    }
}
