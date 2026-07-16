package com.kanchansali.utilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String captureScreenshot(Page page, String testName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());

        String filePath = "screenshots/" + testName + "_" + timestamp + ".png";

        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(filePath))
                .setFullPage(true));

        return filePath;
    }
}