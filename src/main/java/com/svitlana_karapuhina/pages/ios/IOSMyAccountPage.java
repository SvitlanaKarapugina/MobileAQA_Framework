package com.svitlana_karapuhina.pages.ios;

import com.svitlana_karapuhina.core.utils.WaitingUtils;
import com.svitlana_karapuhina.pages.abstarctPages.AbstractMyAccountPage;

import static com.svitlana_karapuhina.core.helper.ElementHelper.isDisplayed;
import static com.svitlana_karapuhina.core.helper.ElementHelper.setTextWithHideKeyboard;


public class IOSMyAccountPage extends AbstractMyAccountPage {
    @Override
    public boolean isMyAccountPageOpen() {
        return isDisplayed(WaitingUtils.waitUntilVisibilityOf(pageTitle, 2));
    }

    @Override
    public IOSMyAccountPage setEmailField(String text) {
        setTextWithHideKeyboard(emailField, text);
        return this;
    }

    @Override
    public IOSMyAccountPage setPasswordField(String text) {
        passwordField.sendKeys(text);
        return this;
    }


    @Override
    public IOSMyAccountPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    @Override
    public IOSMyAccountPage authorization(String email, String password) {
        return null;
    }

    @Override
    public IOSMyAccountPage clickLogOutButton() {
        WaitingUtils.waitUntilVisibilityOf(logOutButton).click();
        return this;
    }

    @Override
    public IOSMyAccountPage clickYesButton() {
        WaitingUtils.waitUntilVisibilityOf(yesButton).click();
        return this;
    }

}