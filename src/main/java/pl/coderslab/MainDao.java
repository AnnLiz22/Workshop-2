package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

import java.sql.SQLException;

public class MainDao {
    public static void main(String[] args) throws SQLException {

  //testowanie metod userDao

        User user = new User();
        UserDao userDao = new UserDao();
//        user.setEmail("anna.mia@gmail.com");
//        user.setUsername("Anna Maria");
//        user.setPassword("pimpek");
//        userDao.createUser(user);

        //  System.out.println(user);
//        User read = userDao.readUserById(1);
//        System.out.println(read);
//
//        User userToUpdate = userDao.readUserById(4);
//        userToUpdate.setUsername("Bonifacy");
//        userToUpdate.setEmail("boniek@boniek.pl");
//        userToUpdate.setPassword("superpass");
//        userDao.updateUser(userToUpdate);
//

   //     userDao.deleteUserById(9);

//        User secondUser = new User();
//        secondUser.setUsername("marek");
//        secondUser.setEmail("marek@janek.pl");
//        secondUser.setPassword("pass");
//        userDao.createUser(secondUser);
//        User[] all = userDao.readAllUsers();
//        for (User u : all) {
//            System.out.println(u);
//        }

    }
}