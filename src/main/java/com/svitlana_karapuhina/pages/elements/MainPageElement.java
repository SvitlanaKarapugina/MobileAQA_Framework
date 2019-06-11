package com.svitlana_karapuhina.pages.elements;

import com.svitlana_karapuhina.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;


public class MainPageElement extends BasePage {
    @AndroidFindBy(id = "tile_container")
    protected WebElement signUpSection;

    @AndroidFindBy(id = "searchEditText")
    protected WebElement searchField;

    @AndroidFindBy(xpath = "//*[@text='Search']")
    protected WebElement searchButton;

    @iOSFindBy(accessibility = "Home")
    @AndroidFindBy(xpath = "//*[@text='Home']")
    protected WebElement homeButton;

    @iOSFindBy(accessibility = "More")
    @AndroidFindBy(xpath = "//*[@text='More']")
    protected WebElement moreButton;

    @iOSFindBy(accessibility = "Login")
    @AndroidFindBy(id = "hello_user_textview")
    protected WebElement signInButton;

    @iOSFindBy(accessibility = "My Account")
    @AndroidFindBy(id = "hello_user_textview")
    protected WebElement myAccountButton;

}
