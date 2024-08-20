package pl.coderslab.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

class UserDaoTest {

    @Test
    void shouldReadUserById() throws SQLException {

        UserDao mockUserDao = mock(UserDao.class);

        User user = new User();
        user.setId(1);
        user.setUsername("Adam");

        when(mockUserDao.readUserById(1)).thenReturn(user);
        Assertions.assertEquals(mockUserDao.readUserById(1), user);

    }

    @Test
    void shouldCreateNewUser() throws SQLException {

        UserDao mockUserDao = mock(UserDao.class);

        User user = new User();
        user.setId(2);
        user.setUsername("Karol");
        User [] users = new User[1];
        users[0] = user;

        when(mockUserDao.readAllUsers()).thenReturn(users);
        Assertions.assertEquals(1, mockUserDao.readAllUsers().length);
    }

    @Test
    void shouldReadAllUsers() throws SQLException {

        UserDao mockUserDao = mock(UserDao.class);

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setId(2);
        user2.setId(3);
        user3.setId(4);
        user1.setUsername("Andrzej");
        user2.setUsername("Antek");
        user3.setUsername("Alek");
        User [] users = new User[3];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;

        when(mockUserDao.readAllUsers()).thenReturn(users);
        Assertions.assertEquals(3, mockUserDao.readAllUsers().length);
    }
}