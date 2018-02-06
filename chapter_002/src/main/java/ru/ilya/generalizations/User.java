package ru.ilya.generalizations;

/**
 * Created by Lenovo2 on 06.02.2018.
 */
public class User {
    private String name;
    private String city;

    private int id;
    /**
     * method User.
     * @param name String.
     * @param city String.
     * @param id int.
     */
    public User(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }
    /**
     * method getId.
     * @return id.
     */
    public int getId() {
        return id;
    }
}
