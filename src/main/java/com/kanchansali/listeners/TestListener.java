package com.kanchansali.listeners;

import com.kanchansali.base.BaseTest;
import com.kanchansali.utilities.LoggerUtil;
import com.kanchansali.utilities.ScreenshotUtils;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

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

        ScreenshotUtils.captureScreenshot(BaseTest.page,result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("SKIPPED : {}", result.getName());

    }
}
