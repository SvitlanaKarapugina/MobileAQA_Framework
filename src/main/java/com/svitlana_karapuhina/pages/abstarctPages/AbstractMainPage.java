package com.svitlana_karapuhina.pages.abstarctPages;

import com.svitlana_karapuhina.pages.android.AndroidMainPage;
import com.svitlana_karapuhina.pages.elements.MainPageElement;
import com.svitlana_karapuhina.pages.ios.IOSMainPage;
import io.qameta.allure.Step;

import java.util.logging.Logger;

import static com.svitlana_karapuhina.core.constants.Constants.IS_IOS;
import static com.svitlana_karapuhina.core.helper.ElementHelper.isDisplayed;
import static com.svitlana_karapuhina.core.utils.WaitingUtils.waitUntilVisibilityOf;
import static java.util.logging.Logger.getLogger;

public abstract class AbstractMainPage extends MainPageElement {
    protected static final Logger log = getLogger(String.valueOf(AbstractMainPage.class));

    public static AbstractMainPage getInstance() {
        return IS_IOS ? new IOSMainPage() : new AndroidMainPage();
    }

    @Step("clickOnMoreBtn")
    public AbstractMainPage clickOnMoreBtn() {
        log.info("Click on 'More' button");
        moreButton.click();
        return AbstractMainPage.getInstance();
    }

    @Step("clickOnHomeBtn")
    public AbstractMainPage openHomePage() {
        log.info("Click on 'More' button");
        homeButton.click();
        return AbstractMainPage.getInstance();
    }

    @Step(value = "Click on 'Sign In' button")
    public AbstractMyAccountPage clickOnSignIn() {
        log.info("Click on 'Sign In' button");
        signInButton.click();
        return AbstractMyAccountPage.getInstance();
    }

    @Step(value = "Log out")
    public AbstractMainPage logOut() {
        log.info("Click on 'Sign In' button");
        waitUntilVisibilityOf(moreButton).click();
        if (!isDisplayed(signInButton)) {
            myAccountButton.click();
            AbstractMyAccountPage.getInstance().clickLogOutButton().clickYesButton();
        }
        openHomePage();
        return AbstractMainPage.getInstance();
    }
}
