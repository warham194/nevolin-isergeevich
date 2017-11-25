package ru.ilya.models;

/**
 * Created by Lenovo2 on 19.11.2017.
 */

import org.junit.Test;
import ru.ilya.start.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StunInputTest {

    @Test
    public void addTest() {

        Input input = new StubInput(new String[] {"0", "test", "Desc", "6"}); // Создаем массив с последовательностью действий
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test")); // заодно проверка метода findAll
    }


    @Test
    public void deleteTest() {

            Item item = new Item("test", "Desc",123L); // создаем заявку
            Tracker tracker = new Tracker();
            tracker.add(item);
            Input input = new StubInput(new String[] {"3", item.getId(), "6"});
            Item[] expected = new Item[] {};
            new StartUI(input, tracker).init();
            Item[] result = tracker.findAll();
            assertThat(result, is(expected));

    }
    @Test
    public void updateTest() {
        Item item = new Item("test", "Desc",123L); // создаем заявку
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input input = new StubInput(
                new String[] {
                        "2", // select update menu
                        item.getId(), // selected item id.
                        "test1", // enter name
                        "Desc01", // enter desc
                        "1234L", // enter create date
                        "6" // exit
                }
        );
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test1"));
    }
    @Test
    public void findByIdTest() {
        Item item = new Item("test", "Desc",123L); // создаем заявку
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        String result = item.getName();
        new StartUI(input, tracker);
        assertThat(result, is("test"));
    }

    @Test
    public void findByName() {
        Item item = new Item("test", "Desc",123L); // создаем заявку
        Tracker tracker = new Tracker();
        tracker.add(item);
        Input input = new StubInput(new String[]{"5", item.getId(), "6"});
        String result = item.getName();
        new StartUI(input, tracker);
        assertThat(result, is("test"));
    }

}
