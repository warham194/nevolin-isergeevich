package ru.ilya.multithreading;

/**
 * Created by Lenovo2 on 04.09.2018.
 */
public class Problem {
    public static void main(String[] args) {
        User firstUser = new User();
        User secondUser = new User();
        Thread firstThread = new Thread(firstUser);
        Thread secondThread = new Thread(secondUser);
        firstThread.start();
        secondThread.start();
    }
}
class User implements Runnable {
    private String name1 = "Оля";
    private String name2 = "Лена";
    public void change()
    {
        String s = name1;
        name1 = name2;
        name2 = s;
    }
    @Override
    public void run() {
        change();
        System.out.println(name1);
        System.out.println(name2);
    }
}
