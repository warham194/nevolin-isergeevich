package ru.job4j.proff;

/**
 * Created by Lenovo2 on 28.10.2017.
 */
public class Profession {
    public String name;
    public int age;

    public void takeMoney(Money money) {
        System.out.println("За услиги взял" + money + "рублей");
    }
}
