package ru.ilya.collections;

/**
 * Created by Lenovo2 on 14.02.2018.
 */
import java.util.List;
import java.util.TreeSet;
import ru.ilya.collections.UserSort;

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

}
