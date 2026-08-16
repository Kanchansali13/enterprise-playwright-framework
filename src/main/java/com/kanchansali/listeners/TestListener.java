package com.kanchansali.listeners;

import com.kanchansali.base.BaseTest;
import com.kanchansali.utils.LoggerUtil;
import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LoggerUtil.getLogger(TestListener.class);

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("PASSED : {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("FAILED : {}", result.getName());

        Object instance = result.getInstance();

        if (instance instanceof BaseTest baseTest) {

            Page page = baseTest.getPage();

            if (page != null && !page.isClosed()) {

                try {

                    String screenshotPath =
                            "target/screenshots/"
                                    + result.getName()
                                    + ".png";

                    byte[] screenshot =
                            page.screenshot(
                                    new Page.ScreenshotOptions()
                                            .setPath(Paths.get(screenshotPath))
                                            .setFullPage(true)
                            );

                    attachScreenshot(screenshot);

                    logger.info(
                            "Screenshot captured: {}",
                            screenshotPath
                    );

                } catch (Exception e) {

                    logger.error(
                            "Failed to capture screenshot",
                            e
                    );
                }
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("SKIPPED : {}", result.getName());
    }

    @Attachment(
            value = "Failure Screenshot",
            type = "image/png"
    )
    public byte[] attachScreenshot(byte[] screenshot) {

        return screenshot;
    }
}