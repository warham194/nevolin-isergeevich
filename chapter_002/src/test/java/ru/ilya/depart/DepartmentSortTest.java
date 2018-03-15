package ru.ilya.depart;

/**
 * Created by Lenovo2 on 15.03.2018.
 */
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
public class DepartmentSortTest {
    @Test
    public void sortByRevers() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        DepartamentSort dep = new DepartamentSort();
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        ));
        assertTrue(dep.sortByRevers(list).equals(expected));
    }
    @Test
    public void sortByDirect() {
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"));
        DepartamentSort dep = new DepartamentSort();
        List<String> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"));
        assertTrue(dep.sortByDirect(list).equals(expected));
    }
}