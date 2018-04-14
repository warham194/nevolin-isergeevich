package ru.ilya.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Lenovo2 on 14.04.2018.
 */
public class RoleTest {

    private RoleStore roleStore;
    private UserStore userStore;

    private Role role1 = new Role("FirstRole");
    private Role role2 = new Role("SecondRole");
    private User user1 = new User("FirstUser");
    private User user2 = new User("SecondUser");
    @Before
    public void setUp() {
        roleStore = new RoleStore();
        userStore = new UserStore();
        roleStore.add(role1);
        roleStore.add(role2);
        userStore.add(user1);
        userStore.add(user2);
    }

    /**
     * Test delete, getById methods.
     */
    @Test
    public void whenDeleteElementThenElementDoesNotContainedAtTheStoreAndTrueValueReturned() {
        assertThat((roleStore.findById("FirstRole") != null), is(true));
        assertThat(roleStore.delete("FirstRole"), is(true));
        assertThat((roleStore.findById("FirstRole") == null), is(true));

        assertThat(userStore.delete("SecondUser"), is(true));
        assertThat(userStore.delete("FirstUser"), is(true));
        assertThat(userStore.delete("SecondUser"), is(false));
    }
    /**
     * Test replace method.
     */

    @Test
    public void whenUpdateElementThanNewElementStoredInstead() {
        User updatedUser = new User("replaceUser");
        Role updateRole = new Role("replaceRole");

        assertThat(roleStore.replace("FirstRole", updateRole), is(true));
        assertThat(userStore.replace("FirstUser", updatedUser), is(true));

        assertTrue(null == roleStore.findById("FirstRole"));
        assertTrue(null == userStore.findById("FirstUser"));

        assertThat(roleStore.findById(updateRole.getId()), is(updateRole));
        assertThat(userStore.findById(updatedUser.getId()), is(updatedUser));
    }
}