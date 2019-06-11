package com.svitlana_karapuhina.core.appium;

import com.svitlana_karapuhina.core.utils.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static com.svitlana_karapuhina.core.constants.Constants.IS_ANDROID;
import static com.svitlana_karapuhina.core.constants.Constants.IS_IOS;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.APPLICATION_NAME;


public class DriverFactory {
    private static AppiumDriver driver;

    private DriverFactory() {
        intializeAppiumDriver();
    }

    private static DriverFactory instanceOfDriverFactory;

    public static DriverFactory getInstanceOfDriverFactory() {
        if (instanceOfDriverFactory == null) {
            instanceOfDriverFactory = new DriverFactory();
        }
        return instanceOfDriverFactory;
    }

    /**
     * Intiliaze Appium driver and capabilities for device
     */
    private void intializeAppiumDriver() {
        File app = new File("src/main/resources", CommonUtils.getCentralData("App"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CommonUtils.getCentralData("PlatformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, CommonUtils.getCentralData("PlatformVersion"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonUtils.getCentralData("DeviceName"));
        if (IS_ANDROID) {
            capabilities.setCapability(APPLICATION_NAME, app.getAbsolutePath());
            capabilities.setCapability(APP_PACKAGE, CommonUtils.getCentralData("AppPackage"));
            capabilities.setCapability(APP_ACTIVITY, CommonUtils.getCentralData("AppActivity"));
        }
        if (IS_IOS) {
            capabilities.setCapability(AUTOMATION_NAME, IOS_XCUI_TEST);
            capabilities.setCapability("app", app.getAbsolutePath());
        }
        capabilities.setCapability(FULL_RESET, CommonUtils.getCentralData("FullReset"));
        capabilities.setCapability(NO_RESET, CommonUtils.getCentralData("NoReset"));
        capabilities.setCapability("udid", CommonUtils.getCentralData("UDID"));
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, CommonUtils.getCentralData("WaitTimeoutInSeconds"));

        try {
            driver = new AppiumDriver(new URL(CommonUtils.getCentralData("URL")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
