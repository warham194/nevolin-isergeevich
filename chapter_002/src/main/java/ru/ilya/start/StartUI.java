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
     *
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    private int[] range = new int[]{0, 1, 2, 3, 4, 5, 6}; // вопрос

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select:", this.range)); // вопрос по поводу this
        } while (!"y".equals(this.input.ask("Exit ?  (y)")));

    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }
}