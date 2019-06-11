package com.svitlana_karapuhina.pages.abstarctPages;

import com.svitlana_karapuhina.core.utils.WaitingUtils;
import com.svitlana_karapuhina.pages.android.AndroidMyAccountPage;
import com.svitlana_karapuhina.pages.elements.MyAccountPageElement;
import com.svitlana_karapuhina.pages.ios.IOSMyAccountPage;
import io.qameta.allure.Step;

import java.util.logging.Logger;

import static com.svitlana_karapuhina.core.constants.Constants.IS_IOS;
import static com.svitlana_karapuhina.core.helper.ElementHelper.isDisplayed;
import static com.svitlana_karapuhina.core.helper.ElementHelper.isEnabled;
import static java.util.concurrent.TimeUnit.SECONDS;


public abstract class AbstractMyAccountPage extends MyAccountPageElement {
    protected Logger log = Logger.getLogger(String.valueOf(AbstractMyAccountPage.class));

    public static AbstractMyAccountPage getInstance() {
        return IS_IOS ? new IOSMyAccountPage() : new AndroidMyAccountPage();
    }

    @Step(value = "isMyAccountPageOpen")
    public abstract boolean isMyAccountPageOpen();

    @Step(value = "setEmailField")
    public abstract AbstractMyAccountPage setEmailField(String text);

    @Step("Set [{0}] text to the 'Password' field")
    public abstract AbstractMyAccountPage setPasswordField(String text);

    @Step("Click on the 'Sign In' button")
    public abstract AbstractMyAccountPage clickSignInButton();

    public abstract AbstractMyAccountPage authorization(String email, String password);

    @Step("Click on the 'Log Out' Button")
    public abstract AbstractMyAccountPage clickLogOutButton();

    @Step("Accept log out")
    public abstract AbstractMyAccountPage clickYesButton();

    @Step
    public boolean isGreetingShown() {
        log.info("Verify if Greeting message is present");
        return isDisplayed(WaitingUtils.waitUntilVisibilityOf(greetingText));
    }

    @Step("Verify if Error message is present")
    public boolean isErrorMsgShown() {
        log.info("Verify if Error message is present");
        WaitingUtils.delay(1, SECONDS);
        return isDisplayed(txtErrorMsg);
    }

    @Step
    public boolean isSignInButtonEnabled() {
        log.info("Verify if 'Sign in' button enabled ");
        return isEnabled(WaitingUtils.waitUntilEnabled(signInButton, 2));
    }

    @Step(value = "getGreetingText")
    public String getGreetingText() {
        log.info("Getting greeting text");
        return WaitingUtils.waitUntilVisibilityOf(greetingText).getText();
    }
}
