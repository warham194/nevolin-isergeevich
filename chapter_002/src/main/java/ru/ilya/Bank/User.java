package ru.ilya.Bank;

/**
 * Created by Lenovo2 on 15.03.2018.
 */
public class User implements Comparable<User> {

    private String name;

    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result != 0 ? result : this.passport.compareTo(o.passport);
    }
}
