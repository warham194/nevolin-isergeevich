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

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;  // проверяем , что name не равно null (если равно , то результат 0)
                                                          // в ином случае при помощи метода высчитываем hashCode переменной name

        result = 31 * result + children;                  // для оптимального распределения хеш значения умножим на 31 и добавим значение второй переменной
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0); // аналогично вычислим хеш значение для birthday
        return result;
    }
}
