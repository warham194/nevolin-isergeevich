package ru.ilya.bank;

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

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result != 0 ? result : this.passport.compareTo(o.passport);
    }
}
