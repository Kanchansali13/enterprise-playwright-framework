package com.kanchansali.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseUtils {

    public static void executeQuery(String query) {

        try {

            Connection connection = DatabaseManager.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                System.out.println("ID: " + resultSet.getInt("id"));

                System.out.println("Name: " + resultSet.getString("name"));

                System.out.println("Email: " + resultSet.getString("email"));

                System.out.println("City: " + resultSet.getString("city"));

                System.out.println("-------------------------");

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public static String getSingleValue(String query, String columnName) {

        try {

            Connection connection = DatabaseManager.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                return resultSet.getString(columnName);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    public static Map<String, String> getRow(String query) {

        Map<String, String> row = new HashMap<>();

        try {

            Connection connection = DatabaseManager.getConnection();

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {

                row.put("id", resultSet.getString("id"));
                row.put("name", resultSet.getString("name"));
                row.put("email", resultSet.getString("email"));
                row.put("city", resultSet.getString("city"));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return row;
    }

    public static int executeUpdate(String query) {

        try {

            Connection connection = DatabaseManager.getConnection();

            Statement statement = connection.createStatement();

            int rowsAffected = statement.executeUpdate(query);

            statement.close();

            return rowsAffected;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return 0;
    }

}