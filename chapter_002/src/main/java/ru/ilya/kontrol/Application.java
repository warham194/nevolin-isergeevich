package ru.ilya.kontrol;

/**
 * Created by Lenovo2 on 21.05.2018.
 */
import java.util.List;
import java.util.Objects;

enum Action { BUY, SELL }
enum Type { ADD, DELETE }
public class Application implements Comparable<Application> {

    private long id;
    private String book;
    private Type type;
    private Action action;
    private int price;
    private int volume;

    public Application(String book, Type type, Action action, int price, int volume) {
        this.id = (int) (Math.random() * 1000);
        this.book = book;
        this.type = type;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    /**
     * Метод getId.
     * @return уникальный ключ заявки.
     */
    public long getId() {
        return id;
    }
    /**
     * Метод getBook.
     * @return идентификатор ценной бумаги.
     */
    public String getBook() {
        return book;
    }
    /**
     * Метод getType.
     * @return выставить заявку на торги или снять.
     */
    public Type getType() {
        return type;
    }
    /**
     * Метод getAction.
     * @return покупку или продажу ценной бумаги.
     */
    public Action getAction() {
        return action;
    }
    /**
     * Метод getPrice.
     * @return цена.
     */
    public int getPrice() {
        return price;
    }
    /**
     * Метод getVolume.
     * @return Количество акций на продажу или покупку.
     */
    public int getVolume() {
        return volume;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Метод setVolume
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, action, price, volume);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Application)) {
            return false;
        }
        Application currentProposal = (Application) obj;
        return currentProposal.id == this.id
                && currentProposal.book == this.book
                && currentProposal.volume == this.volume
                && currentProposal.action.equals(this.action)
                && currentProposal.price == this.price;
    }

    @Override
    public int compareTo(Application o) {
        return Integer.compare(o.price, this.price);
    }
}
