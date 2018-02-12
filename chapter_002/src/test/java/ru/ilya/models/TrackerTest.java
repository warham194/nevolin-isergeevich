package ru.ilya.models;
/**
 * Created by Lenovo2 on 02.11.2017.
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll().get(0), is(item));
    }
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteChangedForNull() {
        Tracker tracker = new Tracker();
        Item item2 = new Item("T5", "TD5", 123L);
        ArrayList<Item> items = new ArrayList<>();
        tracker.add(item2);
        tracker.delete(item2);
        assertThat(tracker.getAll(), is(items));
    }
    @Test
    public void findAllTest() {
        ArrayList<Item> items = new ArrayList<>();
        Item item1 = new Item("test1", "testDescription", 123L);
        Item item2 = new Item("test2", "testDescription", 1234L);
        Item item3 = new Item("test3", "testDescription", 12345L);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
       assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void findByIdTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item result = tracker.findById(item1.getId());
        assertThat(result, is(item1));
    }

    @Test
    public void findByNameTest() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
     //   Item[] result = tracker.findByName("test1");
       assertThat(expected, is(tracker.findByName("test1")));
    }
}
