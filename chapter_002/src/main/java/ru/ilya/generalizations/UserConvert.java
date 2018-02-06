package ru.ilya.generalizations;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Lenovo2 on 06.02.2018.
 */
public class UserConvert {
    /**
     * method process.
     * @param list<Integer>.
     * @return HashMap<Integer,User>.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result  = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }

        return result;
    }
}
