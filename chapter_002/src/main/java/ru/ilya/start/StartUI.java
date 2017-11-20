package ru.ilya.start;

/**
 * Created by Lenovo2 on 10.11.2017.
 */
import ru.ilya.models.*;


public class StartUI {

    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItems();
            } else if (DELETE.equals(answer)) {
                this.deleteItems();
            } else if (FINDID.equals(answer)) {
                this.findId();
            } else if (FINDNAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите имя заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
          this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    private void showAllItems() {
        System.out.println("------------ Показать все заявки --------------");
        Item[] result = this.tracker.findAll();
        for (Item item : result) {
            System.out.println(item);
        }

    }
    private void editItems() {
        System.out.println("------------ Удалить заявку --------------");
        String id = this.input.ask("Введите Id :");
        Item resId = this.tracker.findById(id);
        this.tracker.update(resId);
    }
    private void deleteItems() {
        System.out.println("------------ Удалить заявку --------------");
        String id = this.input.ask("Введите Id :");
        Item resId = this.tracker.findById(id);
        this.tracker.delete(resId);


    }
    private void findName() {
        System.out.println("------------ Поиск заявки по имени --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] result = this.tracker.findByName(name);
        for (Item item : result) {
            System.out.println(item);
        }
    }
    private void findId() {
        System.out.println("------------ Поиск заявки по Id --------------");
        String id = this.input.ask("Введите Id :");
        Item resId = this.tracker.findById(id);
        System.out.println(resId);
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
        // добавить остальные пункты меню.
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
