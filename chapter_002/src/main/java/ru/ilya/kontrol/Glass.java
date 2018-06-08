package ru.ilya.kontrol;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo2 on 01.06.2018.
 */
public class Glass {

    private List<Issuer> glasses = new ArrayList<>();

    public void addOrder(Application order) {
        boolean result = false;
        for (Issuer issuer : glasses) {
            if (issuer.getBook().equals(order.getBook())) {
                issuer.addApplication(order);
                result = true;
                break;
            }
        }
        if (!result) {
            this.glasses.add(new Issuer(order.getBook(), order));
        }
    }

    private void removeOrder(Application order) {
        for (Issuer issuer : this.glasses) {
            if (order.getBook().equals(issuer.getBook())) {
                issuer.removeApplication(order);
                break;
            }
        }
    }

    /**
     * Печатает стакан эммитента.
     * @param book идентификатор ценной бумаги.
     */
    public void printGlass(String book) {
        for (Issuer issuer : glasses) {
            if (issuer.getBook().equals(book)) {
                for (String s : issuer.toStringList()) {
                    System.out.println(s);
                }
            }
        }
    }

    public void orderHandler(Application order) {
        if (order.getType().equals(Type.ADD)) {
            this.addOrder(order);
        } else if (order.getType().equals(Type.DELETE)) {
             this.removeOrder(order);
        }
    }

    /**
     * For tests.
     */
    public List<Issuer> getGlasses() {
        return this.glasses;
    }
}
