package ru.ilya.collections;

/**
 * Created by Lenovo2 on 17.02.2018.
 */
import java.util.Comparator;
import java.util.List;


public class ListCompare implements Comparator<List<Integer>> {

    /**
     * Сравниваем два списка .
     * @param left  левый список.
     * @param right правый список.
     * @return result.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int result = 0;
            for (int leftIndex = 0; leftIndex < left.size(); leftIndex ++) {
                for (int rightIndex = 0; rightIndex < right.size(); rightIndex ++) {
                    result = Integer.compare(left.get(leftIndex), right.get(rightIndex));
                }
             }
        return result;
    }
}
