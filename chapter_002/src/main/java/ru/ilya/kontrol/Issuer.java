package ru.ilya.kontrol;

import java.util.*;

/**
 * Created by Lenovo2 on 21.05.2018.
 */
public class Issuer {
    /**
     * Эммитент
     */
    private String book;

    /**
     * заявки на покупку
     */
    private Set<Application> buyList = new TreeSet<>();
    /**
     * заявки на продажу
     */
    private Set<Application> sellList = new TreeSet<>();

    public Issuer(String book) {
        this.book = book;
    }

    /**
     * Метод удаления заявки
     * @param order
     */
    public void removeApplication(Application order) {
        if (order.getAction().equals(Action.BUY)) {
            this.buyList.remove(order);
        } else if (order.getAction().equals(Action.SELL)) {
            this.sellList.remove(order);
        }
    }

    public Issuer(String book, Application order) {
        this(book);
        this.addApplication(order);

    }

    /**
     * Вернуть эммитент.
     * @return String эммитент.
     */
    public String getBook() {
        return this.book;
    }

    /**
     * Метод суммирования колличества заявок
     * @param order
     */
    public void summValue(Application order) {
        Set<Application> applications = order.getAction().equals(Action.BUY) ? buyList : sellList;
        for (Application app : applications) {
            if (order.getPrice() == app.getPrice()) {
                app.setVolume(order.getVolume() + app.getVolume());
                break;
            }
        }
    }

    /**
     * Метод взаимовычета заявок
     * @param order
     */
    private void balance(Application order) {
        if (order.getAction().equals(Action.BUY)) {
            for (Application app : sellList) {
                if (order.getPrice() >= app.getPrice()) {
                    this.minValue(order, app);
                    if (app.getVolume() == 0) {
                        removeApplication(app);
                    }
                    if (order.getVolume() == 0) {
                        removeApplication(order);
                        break;
                    }
                }
            }
        } else {
            for (Application app : buyList) {
                if (order.getPrice() <= app.getPrice()) {
                    this.minValue(order, app);
                    if (app.getVolume() == 0) {
                        removeApplication(app);
                    }
                    if (order.getVolume() == 0) {
                        removeApplication(order);
                        break;
                    }
                }
            }
        }
    }

    private void minValue(Application newOrder, Application oldOrder) {
        int count = Math.min(oldOrder.getVolume(), newOrder.getVolume());
        oldOrder.setVolume(oldOrder.getVolume() - count);
        newOrder.setVolume(newOrder.getVolume() - count);
    }

    /**
     * Мнтод добавления заявки
     * @param order
     */
    public void addApplication(Application order) {
        balance(order);
        summValue(order);
        if (order.getVolume() != 0) {
            if (order.getAction().equals(Action.BUY)) {
                this.buyList.add(order);
            } else {
                this.sellList.add(order);
            }
        }
    }

    public List<String> toStringList() {
        List<String> result = new ArrayList<>();
        Set<Application> tmp = new TreeSet<>();
        tmp.addAll(this.buyList);
        tmp.addAll(this.sellList);
        for (Application order : tmp) {
            String bid = order.getAction().equals(Action.BUY) ? String.valueOf(order.getVolume()) : "";
            String ask = order.getAction().equals(Action.SELL) ? String.valueOf(order.getVolume()) : "";
            String price = String.valueOf(order.getPrice());
            result.add(String.format("%5s%7s%5s", bid, price, ask));
        }
        return result;
    }

    /**
     * For tests
     */
    public Set<Application> getBuyList() {
        return this.buyList;
    }

    public Set<Application> getSellList() {
        return this.sellList;
    }
}


