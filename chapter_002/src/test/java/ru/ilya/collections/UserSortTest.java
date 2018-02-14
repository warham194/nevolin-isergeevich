package ru.ilya.collections;

/**
 * Created by Lenovo2 on 14.02.2018.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class UserSortTest {

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
}
