package ru.ilya.bank;

import java.util.LinkedList;

/**
 * Created by Lenovo2 on 15.03.2018.
 */
import java.util.*;
public class Bank {

    /**
     * Хранилище клиентов и их счетов.
     */
    Map<User, LinkedList<Account>> users = new TreeMap<>();

    /**
     * Добавление нового клиента
     * @param user
     */
    public void addUser(User user) {
        this.users.putIfAbsent(user, new LinkedList<Account>());
    }
    /**
     * Удаление клиента
     * @param user
     */
    public void deleteUser(User user) {
        this.users.remove(user);
    }

    /**
     * создать или добавить новый счет клиента
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        if (!this.users.get(findByPassport(passport)).contains(account)) {
            this.users.get(findByPassport(passport)).add(account);
        }
    }
    /**
     * удалить счет клиента
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
            this.users.get(findByPassport(passport)).remove(account);
    }

    /**
     * Поиск по паспарту
     * @param passport
     * @return result
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : this.users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Cписок всех счетов клиента.
     * @param passport
     * @return result
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        result = this.users.get(findByPassport(passport));
        return result;
    }


    public boolean transferMoney(String srcPassport, String srcRequisite, String dstPassport, String dstRequisite, double amount) {
        boolean result = false;
        User client1 = null;
        User client2 = null;
        double schet = 0;
        double dstSchet = 0;
        client1 = findByPassport(srcPassport);
        client2 = findByPassport(dstPassport);

        for (Account account : this.users.get(client1)) {
            if (account.getRequisites().equals(srcRequisite) && account.getValue() >= amount) {
                schet = account.getValue() - amount;
                account.setValue(schet);

            }
        }
                for (Account account1 : this.users.get(client2)) {
                    if (account1.getRequisites().equals(dstRequisite)) {
                        dstSchet = account1.getValue() + amount;
                        account1.setValue(dstSchet);
                        result = true;

                    }
                }


        return result;
    }
}