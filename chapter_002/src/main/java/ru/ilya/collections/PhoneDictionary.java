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
            if (persons.iterator().next().getName().contains(key)) {
                result.add(i);
            } else if (persons.iterator().next().getSurname().contains(key)) {
                result.add(i);
            } else if (persons.iterator().next().getPhone().contains(key)) {
                result.add(i);
            } else if (persons.iterator().next().getAddress().contains(key)) {
                result.add(i);
            }
        }
        return result;
    }
}
