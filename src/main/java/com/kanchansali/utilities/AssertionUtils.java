package com.kanchansali.utilities;

import org.testng.Assert;

public class AssertionUtils {

    public static void verifyTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void verifyEquals(Object actual,
                                    Object expected,
                                    String message) {

        Assert.assertEquals(actual, expected, message);
    }
}