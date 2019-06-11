package com.svitlana_karapuhina.pages.elements;

import com.svitlana_karapuhina.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;

public class MyAccountPageElement extends BasePage {
    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name='My account']")
    @AndroidFindBy(id = "toolbar_title")
    protected WebElement pageTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeTextField[@value='E-mail']")
    @AndroidFindBy(id = "login_email_edittext")
    protected WebElement emailField;

    @iOSFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Password']")
    @AndroidFindBy(id = "password_edittext")
    protected WebElement passwordField;

    @iOSFindBy(accessibility = "Sign in")
    @AndroidFindBy(id = "login_button")
    protected WebElement signInButton;

    @AndroidFindBy(id = "register_button")
    protected WebElement registerButton;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[contains(@value,'Hello')]")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Hello')]")
    protected WebElement greetingText;

    @iOSFindBy(accessibility = "Incorrect e-mail or password")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Incorrect e-mail or password']")
    protected WebElement txtErrorMsg;

    @iOSFindBy(accessibility = "LOGOUT")
    @AndroidFindBy(id = "myaccount_logout_button")
    protected WebElement logOutButton;

    @AndroidFindBy(id = "dialog_layout_button_negative")
    protected WebElement noButton;

    @iOSFindBy(accessibility = "YES")
    @AndroidFindBy(id = "dialog_layout_button_positive")
    protected WebElement yesButton;

}
