package ru.ilya.collections;

/**
 * Created by Lenovo2 on 14.02.2018.
 */
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserSortTest {
    /**
     * Тест проверки сортировки списка по возрасту
     */
    @Test
    public void sortTest1() {
        ArrayList<UserSort> users = new ArrayList<>();
        UserSort user1 = new UserSort("Олег", 15);
        UserSort user2 = new UserSort("Вова", 10);
        UserSort user3 = new UserSort("Сергей", 42);
        UserSort user4 = new UserSort("Илья", 22);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        TreeSet<UserSort> expected = new TreeSet<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        expected.add(user4);
        Sort sortUser = new Sort();
        TreeSet<UserSort> result = sortUser.sort(users);
        Assert.assertThat(result, is(expected));
    }

    /**
     * Тест проверки сортировки списка по возрасту(если возраст одинаковый , сортируем по имени)
     */
   @Test
    public void sortTest2() {
        ArrayList<UserSort> users = new ArrayList<>();
       UserSort user1 = new UserSort("Олег", 15);
       UserSort user2 = new UserSort("Вова", 22);
       UserSort user3 = new UserSort("Сергей", 42);
       UserSort user4 = new UserSort("Илья", 22);
       users.add(user1);
       users.add(user2);
       users.add(user3);
       users.add(user4);
       TreeSet<UserSort> expected = new TreeSet<>();
       expected.add(user1);
       expected.add(user2);
       expected.add(user3);
       expected.add(user4);
       Sort sortUser = new Sort();
       TreeSet<UserSort> result = sortUser.sort(users);
       Assert.assertThat(result, is(expected));
    }

    /**
     * Тест проверки сортировки списка по длине имени
     */
    @Test
    public void test3() {
        ArrayList<UserSort> users = new ArrayList<>();
        UserSort user1 = new UserSort("Oleg", 15);
        UserSort user2 = new UserSort("Vovan", 22);
        UserSort user3 = new UserSort("Alexandr", 42);
        UserSort user4 = new UserSort("Max", 22);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List<UserSort> expected = new ArrayList<>();
        expected.add(user4);
        expected.add(user1);
        expected.add(user2);
        expected.add(user3);
        Sort sortUser = new Sort();
        List<UserSort> result = sortUser.sortNameLength(users);
        Assert.assertThat(result, is(expected));
    }
    /**
     * Проверка сортировки списка по длине имени, если есть имена одинаковой длины.
     */
    @Test
    public void test4() {
        ArrayList<UserSort> users = new ArrayList<>();
        UserSort user1 = new UserSort("Oleg", 15);
        UserSort user2 = new UserSort("Vovan", 22);
        UserSort user3 = new UserSort("Alexandr", 42);
        UserSort user4 = new UserSort("Maxim", 22);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List<UserSort> expected = new ArrayList<>();
        expected.add(user1);
        expected.add(user2);
        expected.add(user4);
        expected.add(user3);
        Sort sort = new Sort();
        List<UserSort> result = sort.sortNameLength(users);
        Assert.assertThat(result, is(expected));
    }

    /**
     * Проверка сортировки списка по именам  в лексикографическом порядке(одинаковых имен нет).
     */
    @Test
    public void test5() {
        ArrayList<UserSort> users = new ArrayList<>();
        UserSort user1 = new UserSort("Oleg", 15);
        UserSort user2 = new UserSort("Vovan", 22);
        UserSort user3 = new UserSort("Alexandr", 42);
        UserSort user4 = new UserSort("Max", 22);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List<UserSort> expected = new ArrayList<>();
        expected.add(user3);
        expected.add(user4);
        expected.add(user1);
        expected.add(user2);
        Sort sort = new Sort();
        List<UserSort> result = sort.sortByAllFields(users);
        Assert.assertThat(result, is(expected));
    }

    /**
     * Проверка сортировки списка по именам  в лексикографическом порядке
     * Если в списке есть одинаковые имена, то сортируем по возрасту.
     */
    @Test
    public void test6() {
        ArrayList<UserSort> users = new ArrayList<>();
        UserSort user1 = new UserSort("Max", 15);
        UserSort user2 = new UserSort("Vovan", 22);
        UserSort user3 = new UserSort("Alexandr", 42);
        UserSort user4 = new UserSort("Max", 22);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        List<UserSort> expected = new ArrayList<>();
        expected.add(user3);
        expected.add(user1);
        expected.add(user4);
        expected.add(user2);
        Sort sort = new Sort();
        List<UserSort> result = sort.sortByAllFields(users);
        Assert.assertThat(result, is(expected));
    }
}

