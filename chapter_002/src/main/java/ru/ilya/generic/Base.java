package ru.ilya.generic;

/**
 * Created by Lenovo2 on 13.04.2018.
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
