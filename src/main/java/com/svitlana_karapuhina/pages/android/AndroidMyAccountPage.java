package com.svitlana_karapuhina.pages.android;

import com.svitlana_karapuhina.core.utils.WaitingUtils;
import com.svitlana_karapuhina.pages.abstarctPages.AbstractMyAccountPage;

import static com.svitlana_karapuhina.core.helper.ElementHelper.setTextWithHideKeyboard;
import static java.lang.String.format;


public class AndroidMyAccountPage extends AbstractMyAccountPage {
    private final String pageName = "My account";

    @Override
    public boolean isMyAccountPageOpen() {
        log.info("Getting heading text");
        return WaitingUtils.waitUntilVisibilityOf(pageTitle).getText().equals(pageName);
    }

    @Override
    public AndroidMyAccountPage setEmailField(String text) {
        log.info(format("Set '[%s]' text to the 'Email' field", text));
        setTextWithHideKeyboard(emailField, text);
        return this;
    }

    @Override
    public AndroidMyAccountPage setPasswordField(String text) {
        log.info(format("Set [%s] text to the 'Password' field", text));
        setTextWithHideKeyboard(passwordField, text);
        return this;
    }

    @Override
    public AndroidMyAccountPage clickSignInButton() {
        log.info("Click on the 'Sign In' button");
        signInButton.click();
        return this;
    }

    @Override
    public AbstractMyAccountPage authorization(String email, String password) {
        log.info(format("Authorization with '%s' email, '%s' password", email, password));
        setEmailField(email);
        setPasswordField(password);
        return clickSignInButton();
    }

    @Override
    public AndroidMyAccountPage clickLogOutButton() {
        log.info("Click on the 'Log Out' Button");
        WaitingUtils.waitUntilVisibilityOf(logOutButton).click();
        return this;
    }

    @Override
    public AndroidMyAccountPage clickYesButton() {
        log.info("Accept log out");
        WaitingUtils.waitUntilVisibilityOf(yesButton).click();
        return this;
    }


}
