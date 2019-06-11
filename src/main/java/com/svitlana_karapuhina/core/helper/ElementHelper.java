package com.svitlana_karapuhina.core.helper;

import com.svitlana_karapuhina.core.appium.DriverFactory;
import com.svitlana_karapuhina.core.constants.Constants;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class ElementHelper {
    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public static WebElement findElement(By by) {
        try {
            return DriverFactory.getDriver().findElement(by);
        } catch (WebDriverException e) {
            return null;
        }
    }

    public static void setTextWithHideKeyboard(WebElement webElement, String text) {
        webElement.sendKeys(text);
        hideKeyboard();
    }

    public static void hideKeyboard() {
        if (Constants.IS_IOS) Objects.requireNonNull(findElement(new ByAccessibilityId("Done"))).click();
        else DriverFactory.getDriver().hideKeyboard();
    }

}
