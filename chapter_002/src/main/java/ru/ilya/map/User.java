package ru.ilya.map;

import java.util.Calendar;

/**
 * Created by Lenovo2 on 06.05.2018.
 */
public class User {
    private String name;
    private int children;
    private Calendar  birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
