package ru.ilya.collections;

/**
 * Created by Lenovo2 on 20.02.2018.
 */
import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person i : persons) {
            if (i.getName().contains(key) || i.getSurname().contains(key) || i.getAddress().contains(key) || i.getPhone().contains(key)) {
                result.add(i);
            }
        }
        return result;
    }
}
