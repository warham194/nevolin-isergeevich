package ru.ilya.start;

import ru.ilya.models.*;
/**
 * Created by Lenovo2 on 03.12.2017.
 */


class EditItems implements UserAction {
    public int key() {
        return 2;
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String id = input.ask("Введите ID заявки :");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите имя заявки :");
        Item updated = new Item();
        updated.setId(id);
        updated.setName(name);
        updated.setDesc(desc);
        tracker.update(id, updated);
    }

    public String info() {
        return String.format("%s. %s", this.key(), "Edit item");
    }
}




public class MenuTracker {


    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[10];
    private String exit = null; //переменная для реализации выхода из программы

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowAllItems();
        this.actions[2] = new EditItems();
        this.actions[3] = new MenuTracker.DeleteItem();
        this.actions[4] = new MenuTracker.FindItemById();
        this.actions[5] = new MenuTracker.FindName();
        this.actions[6] = new MenuTracker.Exit();
    } // вопрос


    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show(){ // вывод меню на экран

        for(UserAction action : this.actions){

            if(action != null) {
                System.out.println(action.info());
            }
        }
    }
        private class AddItem implements UserAction { //внутренний класс добавления заявок
            public int key() {
                return 0;
            }

            public void execute(Input input, Tracker tracker) {
                System.out.println("------------ Добавление новой заявки --------------");
                String name = input.ask("Введите имя заявки :");
                String desc = input.ask("Введите имя заявки :");
                Item item = new Item(name, desc, System.currentTimeMillis());
                tracker.add(item);
                System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
            }

            public String info() {
                return String.format("%s. %s", this.key(), "Add the new Item");
            }
        }

    private class ShowAllItems implements UserAction { //внутренний класс добавления заявок
        public int key() {
            return 1;
        }

        public void execute(Input input, Tracker tracker) {
            if(tracker.findAll() == null){ // Если список заявок пуст, сообщаем об этом

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
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class DeleteItem implements UserAction { //внутренний класс добавления заявок
        public int key() {
            return 3;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удалить заявку --------------");
            String id = input.ask("Введите Id :");
            Item resId = tracker.findById(id);
            tracker.delete(resId);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Delete Item");
        }
    }

    private class FindItemById implements UserAction { //внутренний класс добавления заявок
        public int key() {
            return 4;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по Id --------------");
            String id = input.ask("Введите Id :");
            Item resId = tracker.findById(id);
            System.out.println(resId);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find Item By Id");
        }
    }

    private class FindName implements UserAction { //внутренний класс добавления заявок
        public int key() {
            return 5;
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] result = tracker.findByName(name);
            for (Item item : result) {
                System.out.println(item);
            }
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
    }
    private class Exit implements UserAction { //внутренний класс добавления заявок
        public int key() {
            return 6;
        }

        public void execute(Input input, Tracker tracker) {
          //  setExit(input.ask("Вы точно хотите выйти? (Да/Нет): "));
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Exit");
        }
    }

}