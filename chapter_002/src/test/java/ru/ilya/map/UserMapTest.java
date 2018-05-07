package ru.ilya.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo2 on 06.05.2018.
 */
public class UserMapTest {
    private Map<User, Object> map = new HashMap<>();
    private Calendar birthday = new GregorianCalendar(1994, 4, 10);

    private User first = new User("Ilya", 0, birthday);
    private User second = new User("Ilya", 0, birthday);

    @Test
    public void whenAddUsersAndNotUseOverriddenEquals() {
        map.put(first, 1);
        map.put(second, 2);
        System.out.println(map); //при переопределении hashCode программа считает объекты разными
                                  // т.к. совпадение хеш не значит , что объекты индентичны
                                 // в данном случае мы получим два объекта с одинаковыми хеш значениями и разными ключами

    }



}
