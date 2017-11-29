package ru.ilya.strategy;

/**
 * Created by Lenovo2 on 27.11.2017.
 */
public class Square implements Shape {
    @Override
    public String pic() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("++++");
        return pic.toString();
    }
}
