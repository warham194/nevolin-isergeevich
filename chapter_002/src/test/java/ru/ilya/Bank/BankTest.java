package ru.ilya.bank;

/**
 * Created by Lenovo2 on 16.03.2018.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class BankTest {
    /**
     * добавление нового клиента.
     */
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user = new User("Ilya", "Nevolin");
        bank.addUser(user);
        Assert.assertTrue(bank.users.keySet().contains(user));
    }

    /**
     * удаление нового клиента.
     */
    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Ilya", "Nevolin");
        User user1 = new User("Alex", "Ivanov");
        bank.addUser(user);
        bank.addUser(user1);
        bank.deleteUser(user);
        Assert.assertFalse(bank.users.keySet().contains(user));
    }

    /**
     * добавление счета для клиента.
     */
    @Test
    public void whenAddAccount() {
        Bank bank = new Bank();
        User user = new User("Ilqa", "Nevolin");
        bank.addUser(user);
        bank.addAccountToUser("Nevolin", new Account("1234", 0.0));
        Assert.assertThat(bank.users.get(user).get(0).getRequisites(), is("1234"));
        Assert.assertThat(bank.users.get(user).get(0).getValue(), is(0.0));
    }

    /**
     * Проверяется удаление счета у клиента.
     */
    @Test
    public void whenDeleteAccount() {
        Bank bank = new Bank();
        User user = new User("Illya", "Nevolin");
        Account account = new Account("0123", 0.0);
        bank.addUser(user);
        bank.addAccountToUser("Nevolin", account);
        bank.deleteAccountFromUser("Nevolin", account);
        Assert.assertTrue(bank.users.get(user).isEmpty());
    }

    /**
     * Проверяется получение списка счетов клиента.
     */
    @Test
    public void whenCallUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Ilya", "Nevolin");
        Account accountOne = new Account("0123456789", 0.0);
        Account accountTwo = new Account("0123456789", 0.0);
        bank.addUser(user);
        bank.addAccountToUser("Nevolin", accountOne);
        bank.addAccountToUser("Nevolin", accountTwo);
        List<Account> expected = new LinkedList<>();
        expected.add(accountOne);
        expected.add(accountTwo);
        List<Account> result = bank.getUserAccounts("Nevolin");
        Assert.assertThat(result, is(expected));
    }

    /**
     * перечисления денег со счета на счет, денег для перечисления достаточно.
     */
    @Test
    public void whenTransferEnoughMoney() {
        Bank bank = new Bank();
        User user = new User("Ilya", "Nevolin");
        User user1 = new User("Alex", "Ivanov");
        bank.addUser(user);
        bank.addUser(user1);
        Account accountOne = new Account("1", 10.0);
        Account accountTwo = new Account("2", 0.0);
        bank.addAccountToUser("Nevolin", accountOne);
        bank.addAccountToUser("Ivanov", accountTwo);
        boolean result = bank.transferMoney("Nevolin", "1", "Ivanov", "2", 7.0);
        System.out.println(accountOne.getValue());
        System.out.println(accountTwo.getValue());
        Assert.assertThat(result, is(true));

    }

    /**
     * перечисления денег со счета на счет, денег для перечисления недостаточно.
     */
    @Test
    public void whenTransferNotEnoughMoney() {
        Bank bank = new Bank();
        User user = new User("Ilya", "Nevolin");
        User user1 = new User("Alex", "Ivanov");
        bank.addUser(user);
        bank.addUser(user1);
        Account accountOne = new Account("1", 10.0);
        Account accountTwo = new Account("2", 0.0);
        bank.addAccountToUser("Nevolin", accountOne);
        bank.addAccountToUser("Ivanov", accountTwo);
        boolean result = bank.transferMoney("Nevolin", "1", "Ivanov", "2", 11.0);
        System.out.println(accountOne.getValue());
        System.out.println(accountTwo.getValue());
        Assert.assertThat(result, is(true));
    }

}
