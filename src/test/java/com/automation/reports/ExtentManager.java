package com.automation.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("extend-report-results/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Tester", "T V Srikanth");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
