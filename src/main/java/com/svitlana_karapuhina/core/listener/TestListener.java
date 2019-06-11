package com.svitlana_karapuhina.core.listener;

import com.svitlana_karapuhina.core.appium.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends AllureTestNg implements ITestListener {

    private static String getTesMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(AppiumDriver<WebElement> driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestPass method " + getTesMethodName(iTestResult) + " PASS");


        if (DriverFactory.getDriver() != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(DriverFactory.getDriver());
        }
        super.onTestSuccess(iTestResult);
        saveTextLog(getTesMethodName(iTestResult) + " success and screenshot taken!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTesMethodName(iTestResult) + " failed");

        if (DriverFactory.getDriver() != null) {
            System.out.println("Screenshot captured for test case: " + getTesMethodName(iTestResult));
            saveScreenshotPNG(DriverFactory.getDriver());
        }
        saveTextLog(getTesMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}