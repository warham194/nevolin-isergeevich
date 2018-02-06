package ru.ilya.generalizations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Lenovo2 on 06.02.2018.
 */
public class UserConvertTest {

    @Test
    public void addUsersAndConvertInMap() {
        List<User> user = new ArrayList<>();
        User user1 = new User("Ilya", "Moscow", 1);
        User user2 = new User("Max", "Rostov", 2);
        User user3 = new User("Stepa", "Reutov", 3);
        User user4 = new User("Ivan", "Gravity Falls", 6);
        user.add(user1);
        user.add(user2);
        user.add(user3);
        user.add(user4);
        UserConvert convert = new UserConvert();
        HashMap<Integer, User> result = convert.process(user);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, user1);
        expected.put(2, user2);
        expected.put(3, user3);
        expected.put(6, user4);
        assertThat(result, is(expected));
    }

}
