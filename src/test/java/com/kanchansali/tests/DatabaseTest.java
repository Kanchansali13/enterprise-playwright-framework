package com.kanchansali.tests;

import com.kanchansali.database.DatabaseManager;
import com.kanchansali.database.DatabaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.util.Map;

public class DatabaseTest {

    @Test (priority = 1)
    public void databaseConnectionTest() {

        Connection connection = DatabaseManager.getConnection();

        System.out.println(connection);

    }

    @Test(priority = 2)
    public void readUsersFromDatabase() {

        DatabaseUtils.executeQuery("SELECT * FROM users");

    }

    @Test(priority = 3)
    public void verifySingleUser() {

        String city = DatabaseUtils.getSingleValue(
                "SELECT city FROM users WHERE name='Kanchan'",
                "city");

        String email = DatabaseUtils.getSingleValue(
                "SELECT email FROM users WHERE name='Kanchan'",
                "email");


        System.out.println("City = " + city);
        System.out.println("Email = "+email);

        Assert.assertEquals(city, "Pune");
        Assert.assertEquals(email, "kanchan@test.com");
    }

    @Test(priority = 4)
    public void verifyUserDetails() {

        Map<String, String> user = DatabaseUtils.getRow(
                "SELECT * FROM users WHERE id = 1");

        Assert.assertEquals(user.get("name"), "Kanchan");
        Assert.assertEquals(user.get("email"), "kanchan@test.com");
        Assert.assertEquals(user.get("city"), "Pune");

        System.out.println(user);
    }

    @Test(priority = 5)
    public void insertUserIntoDatabase() {

        int rows = DatabaseUtils.executeUpdate(
                "INSERT INTO users(name,email,city) VALUES ('Priya','priya@test.com','Bangalore')");

        Assert.assertEquals(rows, 1);

        System.out.println("Rows Inserted : " + rows);

    }

    @Test(priority = 6)
    public void verifyInsertedUser() {

        Map<String, String> user =
                DatabaseUtils.getRow(
                        "SELECT * FROM users WHERE email='priya@test.com'");

        Assert.assertEquals(user.get("city"), "Bangalore");
        Assert.assertEquals(user.get("email"), "priya@test.com");

    }

    @Test(priority = 7)
    public void updateUserInDatabase() {

        int rows = DatabaseUtils.executeUpdate(
                "UPDATE users SET city='Hyderabad' WHERE email='priya@test.com'");

        Assert.assertEquals(rows, 1);

        Map<String, String> user =
                DatabaseUtils.getRow(
                        "SELECT * FROM users WHERE name='Priya'");

        Assert.assertEquals(user.get("city"), "Hyderabad");

        System.out.println(user);
    }

    @Test(priority = 8)
    public void deleteUserFromDatabase() {

        int rows = DatabaseUtils.executeUpdate(
                "DELETE FROM users WHERE email='priya@test.com'");

        Assert.assertEquals(rows, 1);

        String city = DatabaseUtils.getSingleValue(
                "SELECT city FROM users WHERE name='Priya'",
                "city");

        Assert.assertNull(city);
    }

}