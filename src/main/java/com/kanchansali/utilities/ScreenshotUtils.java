package com.kanchansali.utilities;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.ScreenshotType;

import java.nio.file.Paths;

public class ScreenshotUtils {

    public static void capture(Page page,
                               String fileName) {

        page.screenshot(
                new Page.ScreenshotOptions()
                        .setPath(Paths.get(
                                "screenshots/" + fileName + ".png"))
                        .setType(ScreenshotType.PNG));
    }
}