package com.epam.brest.cource;

import java.sql.*;

public class DBUtils {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        System.out.println("Connect to db");
        String datbaseURL = "jdbc:h2:mem:test_db;MODE=MYSQL;DB_CLOSE_DELAY=-1";
        Class.forName("org.h2.Driver");
        Connection connection =
                DriverManager.getConnection(datbaseURL, "sa", "");
        return connection;
    }

    public void createUserTable(Connection connection) throws SQLException {

        System.out.println("Create app_user table");
        String createTable =
                "CREATE TABLE app_user (" +
                        "user_id INT NOT NULL AUTO_INCREMENT," +
                        "login VARCHAR(255) NOT NULL," +
                        "password VARCHAR(255) NOT NULL," +
                        "description VARCHAR(255) NULL," +
                        "PRIMARY KEY (user_id))";
       try  (Statement statement = connection.createStatement()) {
           statement.executeUpdate(createTable);
       }
    }

    public int addUser(Connection connection, String login, String password, String description) throws SQLException {

        System.out.println(String.format("User %s added!", login));
        String newUser = "INSERT INTO app_user (login, password, description) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(newUser);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, description);
        return preparedStatement.executeUpdate();

    }

    public void getUsers(Connection connection) throws SQLException {

        String getRecords = "SELECT user_id, login, description FROM app_user ORDER BY user_id";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getRecords);
        while (resultSet.next()) {
            System.out.println(String.format("User: %s, %s, %s",
                    resultSet.getString("user_id"),
                    resultSet.getString("login"),
                    resultSet.getString("description")));
        }

    }
}
