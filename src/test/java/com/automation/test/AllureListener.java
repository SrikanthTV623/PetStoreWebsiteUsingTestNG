package com.automation.test;

import com.automation.utils.AllureReportManager;
import com.automation.utils.DriverManager;
import com.automation.utils.ScreenshotUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

import java.io.IOException;

public class AllureListener extends AllureTestNg {

    @Override
    public void onTestFailure(ITestResult result){

        // Attach a screenshot to the Allure report
        try {
            String path = ScreenshotUtils.takeScreenshot(result.getMethod().getMethodName());
            Allure.addAttachment("Failed Screenshot", "image/png", path);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // Attach the current URL to the Allure report
        Allure.addAttachment("Failed URL", DriverManager.getDriver().getCurrentUrl());

        super.onTestFailure(result);
    }
}
