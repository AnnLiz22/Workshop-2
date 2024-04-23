package pl.coderslab.dao;

public class UserDao {

    private static final String QUERY_ADD_USER = "INSERT INTO users (id, email, username, password) VALUES (?, ?, ?, ?);";
    private static final String QUERY_ALTER_DATA = "Update users SET email=?, username=?, password=? where id=?;";
    private static final String QUERY_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?;";
    private static final String QUERY_DELETE_BY_ID = "DELETE FROM users WHERE id = ?;";
    private static final String QUERY_SELECT_ALL = "SELECT * FROM users;";


    public static void createUser(){

    }
    public static void updateUser(){

    }

    public static void readUserById(){

    }

    public static void deleteUserById(){

    }

    public static void readAllUsers(){

    }
}
