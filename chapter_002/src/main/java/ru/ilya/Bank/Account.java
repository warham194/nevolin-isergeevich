package ru.ilya.Bank;

/**
 * Created by Lenovo2 on 15.03.2018.
 */
public class Account {


    private double value;
    private String requisites;

    public Account(String requisites, double value) {
        this.requisites = requisites;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }
}