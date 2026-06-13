package com.automation.listeners;

import com.automation.reports.ExtentManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import com.aventstack.extentreports.*;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        try {
            String path = ScreenshotUtils.takeScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(path);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}
