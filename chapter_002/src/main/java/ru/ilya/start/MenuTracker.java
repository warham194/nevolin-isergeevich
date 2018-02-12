package ru.ilya.start;

import ru.ilya.models.*;
import java.util.ArrayList;
/**
 * Created by Lenovo2 on 03.12.2017.
 */




public class MenuTracker {


    private Input input;
    private Tracker tracker;
    private ArrayList<UserAction> actions = new ArrayList<>();
    private String exit = null; //переменная для реализации выхода из программы
    private int position = 0;

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление новой заявки."));
        this.actions.add(new ShowAllItems(1, "Показ списка заявок."));
        this.actions.add(new FindName(2, "Поиск заявки по имени."));
        this.actions.add(new FindItemById(3, "Поиск заявки по ID."));
        this.actions.add(new EditItems(4, "Редактирование заявки."));
        this.actions.add(new DeleteItem(5, "Удаление заявки."));
        this.actions.add(new Exit(6, "Выход.\n\"<=====================================>"));
    }

    public void addAction(UserAction action) { //Данный метод позволяет добавлять новые действия

        actions.add(action);
    }

    public void select(int key) {
        actions.get(key).execute(this.input, this.tracker);
    }

    public void show() { // вывод меню на экран

        for (UserAction action : actions) {

            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction { //внутренний класс добавления заявок
        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите Тему заявки :");
            Item item = new Item(name, desc, System.currentTimeMillis());
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }
    }

    private class ShowAllItems extends BaseAction { //внутренний класс добавления заявок
        public ShowAllItems(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.findAll() == null) { // Если список заявок пуст, сообщаем об этом

                System.out.println("<=====================================>");
                System.out.println("Список заявок пуст.");
                System.out.println("<=====================================>");
            } else {
                System.out.println("------------ Показать все заявки --------------");
                for (Item item : tracker.getAll()) {
                    System.out.println(String.format("%s. %s", item.getId(), item.getName()));
                }
            }
        }
    }

    private class DeleteItem extends BaseAction { //внутренний класс добавления заявок
        public DeleteItem(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удалить заявку --------------");
            String id = input.ask("Введите Id :");
            Item resId = tracker.findById(id);
            tracker.delete(resId);
        }
    }

    private class FindItemById extends BaseAction { //внутренний класс добавления заявок
        public FindItemById(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id :");
            Item resId = tracker.findById(id);
            System.out.println(resId);
        }
    }

    private class FindName extends BaseAction { //внутренний класс добавления заявок
        public FindName(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            ArrayList<Item> result = tracker.findByName(name);
            for (Item item : result) {
                if (tracker.findByName(name) != null) {
                    System.out.println(item);
                }
            }
        }
    }

    class EditItems extends BaseAction {
        public EditItems(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String id = input.ask("Введите ID заявки :");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите имя заявки :");
            Item updated = new Item();
            updated.setId(id);
            updated.setName(name);
            updated.setDesc(desc);
            //  tracker.update(id, updated);
        }
    }

    class Exit extends BaseAction { //внутренний класс добавления заявок
        public Exit(int key, String name) { // конструктор в котором мы вызываем конструкор родительского класса
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            //  setExit(input.ask("Вы точно хотите выйти? (Да/Нет): "));
        }

    }
}
