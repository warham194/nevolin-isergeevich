package ru.ilya.collections;

/**
 * Created by Lenovo2 on 04.02.2018.
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ConverListTest {

    @Test
    public void testConvert() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{5, 6, 3});
        list.add(new int[]{12});
        list.add(new int[]{771, 83, 94});
        ConvertList testlist = new ConvertList();
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(6);
        expected.add(3);
        expected.add(12);
        expected.add(771);
        expected.add(83);
        expected.add(94);
        List<Integer> result = testlist.convert(list);
        assertThat(result, is(expected));
    }

    @Test
    public void testToArray() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list1.add(i);
        }
        ConvertList convertation = new ConvertList();
        int[][] tmp = convertation.toArray(list1, 3);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertThat(tmp, is(expected));
    }

    @Test
    public void testToArray2() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list1.add(i);
        }
        ConvertList convertation = new ConvertList();
        int[][] tmp = convertation.toArray(list1, 3);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(tmp, is(expected));
    }

    @Test
    public void testToList() {
        int[][] testToL = new int[][]  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ConvertList convertation = new ConvertList();
        List<Integer> result = convertation.toList(testToL);
        List<Integer> expected = new ArrayList<>(9);
        for (int i = 1; i < 10; i++) {
            expected.add(i);
        }
        assertThat(result, is(expected));
    }
}
/*

   @Test
    public void testToList() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list1.add(i);
        }
        ConvertList convertation = new ConvertList();
        int[][] tmp = convertation.toArray(list1, 3);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertThat(tmp, is(expected));
    }
}
 */