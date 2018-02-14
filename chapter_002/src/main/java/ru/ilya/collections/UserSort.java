package ru.ilya.collections;

/**
 * Created by Lenovo2 on 10.02.2018.
 */
public class UserSort implements Comparable<UserSort> {
    /**
     * Имя
     * возраст.
     */
    private final String name;
    private final int age;
    /**
     * Конструктор
     *
     * @param name имя.
     * @param age  возраст.
     */
    public UserSort(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * сравнение
     * @param o сравниваемый объект.
     * @return результат
     */
    @Override
    public int compareTo(UserSort o) {
        int result = Integer.compare(this.age, o.age);
        return result != 0 ? result : this.name.compareTo(o.name);
    }
}
