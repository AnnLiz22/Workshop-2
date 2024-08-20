package pl.coderslab.entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.util.List;

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
        User[] users = new User[1];
        users[0] = user;

        when(mockUserDao.readAllUsers()).thenReturn(users);
        mockUserDao.createUser(user);
        List<User> userList = List.of(mockUserDao.readAllUsers());

        Assertions.assertEquals(1, userList.size());
        verify(mockUserDao).readAllUsers();
        verify(mockUserDao).createUser(user);
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
        User[] users = new User[3];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;

        when(mockUserDao.readAllUsers()).thenReturn(users);

        List<User> userList = List.of(mockUserDao.readAllUsers());

        Assertions.assertEquals(3, userList.size());
        verify(mockUserDao, times(1)).readAllUsers();
    }

    @Test
    void shouldDeleteUser() throws SQLException {

        UserDao mockUserDao = mock(UserDao.class);

        User user1 = new User();
        User user2 = new User();
        user1.setId(5);
        user1.setId(6);
        user1.setUsername("Ania");
        user1.setUsername("Hania");
        User[] users = new User[2];
        users[0] = user1;
        users[1] = user2;

        when(mockUserDao.readAllUsers()).thenReturn(users);
        mockUserDao.deleteUserById(1);

        verify(mockUserDao, times(1)).deleteUserById(1);
    }

    @Test
    void shouldHashPassword() {
        User user = new User();
        user.setUsername("Anna");
        user.setPassword("123");
        String password = user.getPassword();

        String passHashed = UserDao.hashPassword(password);
        assertThat(passHashed)
                .contains("1")
                .contains("2")
                .contains("3");
    }

    @Test
    void shouldUpdateUser() throws SQLException {

        UserDao mockUserDao = mock(UserDao.class);

        User user = new User();
        user.setId(7);
        user.setUsername("Anna");
        User[] users = new User[1];
        users[0] = user;

        when(mockUserDao.readAllUsers()).thenReturn(users);
        mockUserDao.createUser(user);
        user.setEmail("Anna@Anna");
        mockUserDao.updateUser(user);
        List<User> userList = List.of(mockUserDao.readAllUsers());

        Assertions.assertEquals(1, userList.size());
        Assertions.assertEquals("Anna@Anna", user.getEmail());
        verify(mockUserDao).readAllUsers();
        verify(mockUserDao).createUser(user);
        verify(mockUserDao, times(1)).updateUser(user);
    }

    @Test
    void shouldAddToArray() {
        User user1 = new User(8, "Anna@ana", "Anna", "123");
        User user2 = new User(9, "ani@ani", "Ania", "456");
        User[] users = new User[2];
        users[0] = user1;
        users[1] = user2;

        assertThat(users)
                .hasSize(2)
                .isNotEmpty();

        assertThat(users[0].getUsername()).isEqualTo("Anna");
        assertThat(users[1].getUsername()).isEqualTo("Ania");
    }
}