package ru.ilya.collections;

/**
 * Created by Lenovo2 on 14.02.2018.
 */
import java.util.List;
import java.util.TreeSet;
import ru.ilya.collections.UserSort;
import java.util.Comparator;
public class Sort {

    /**
     * Сортировка списка
     * @param list список объектов UserUserSort.
     * @return отсортированное.
     */
    public TreeSet<UserSort> sort(List<UserSort> list) {
        TreeSet<UserSort> result = new TreeSet<>();
        for (UserSort user : list) {
            result.add(user);
        }
        return result;
    }
    /**
     * Сортировка списка по длине имени
     * @param list список объектов UserUserSort.
     * @return отсортированое.
     */
    public List<UserSort> sortNameLength(List<UserSort> list) {
        list.sort(new Comparator<UserSort>() {
            @Override
            public int compare(UserSort o1, UserSort o2) {
                int result = Integer.compare(o1.getName().toCharArray().length, o2.getName().toCharArray().length);
                return result;
            }
        });
        return list;
    }
    /**
     * Cначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     * @param list список объектов UserUserSort.
     * @return отсортированое.
     */
    public List<UserSort> sortByAllFields(List<UserSort> list) {
        list.sort(new Comparator<UserSort>() {
            @Override
            public int compare(UserSort o1, UserSort o2) {
                int result = o1.getName().compareTo(o2.getName());
                return result != 0 ? result : Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return list;
    }
}
