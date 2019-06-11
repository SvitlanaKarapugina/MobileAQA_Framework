package com.svitlana_karapuhina.core.utils;

import com.svitlana_karapuhina.core.appium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.svitlana_karapuhina.core.helper.ElementHelper.isDisplayed;
import static com.svitlana_karapuhina.core.helper.ElementHelper.isEnabled;
import static org.slf4j.helpers.Util.report;

public class WaitingUtils {
    private static final long STANDARD_DELAY = 30;

    public static void delay(long time, TimeUnit timeType) {
        try {
            Thread.sleep(timeType.toMillis(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitUntilVisibilityOf(WebElement element) {
        return waitUntilVisibilityOf(element, STANDARD_DELAY);
    }

    public static WebElement waitUntilVisibilityOf(WebElement element, long timeOutInSeconds) {
        return until(webDriver -> isDisplayed(element) ? element : null, timeOutInSeconds);
    }

    public static WebElement waitUntilEnabled(WebElement element, long timeOutInSeconds) {
        return until(webDriver -> isEnabled(element) ? element : null, timeOutInSeconds);
    }

    private static <V> V until(Function<? super WebDriver, V> isTrue, long timeout) {
        try {
            return new WebDriverWait(DriverFactory.getDriver(), timeout).until(isTrue);
        } catch (NullPointerException e) {
            report("A test's been failed because WebElement - NULL.");
        }
        return null;
    }

}
