package com.svitlana_karapuhina.pages;

import com.svitlana_karapuhina.core.appium.DriverFactory;
import com.svitlana_karapuhina.core.constants.Constants;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    public BasePage() {
        DriverFactory.getInstanceOfDriverFactory();
        initElements(new AppiumFieldDecorator(DriverFactory.getDriver(), Constants.IMPLICIT_WAIT), this);
    }

}
