import base.BaseTest;
import com.svitlana_karapuhina.core.listener.TestListener;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class})
public class SingUpTest extends BaseTest {
    //DATA
    String validEmail = "sw.karapugina@gmail.com";
    String invalidEmail = "test@email.com";
    String password = "qwerty123";

    @Test(description = "Sign In Pass")
    @Description("Test Description: Sing in test - pass")
    public void testSignInPass() {
        mainPage.logOut();
        assertTrue(mainPage.clickOnMoreBtn()
                .clickOnSignIn()
                .isMyAccountPageOpen());
        assertTrue(myAccountPage.setEmailField(validEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled());
        assertFalse(myAccountPage.clickSignInButton()
                .isErrorMsgShown());
        assertTrue(myAccountPage.isGreetingShown());
    }

    @Test(description = "Sign In Fail")
    @Description("Test Description: Sing in test - fail")
    public void testSignInFail() {
        mainPage.logOut();
        assertTrue(mainPage.clickOnMoreBtn()
                .clickOnSignIn()
                .isMyAccountPageOpen());
        assertTrue(myAccountPage.setEmailField(invalidEmail)
                .setPasswordField(password)
                .isSignInButtonEnabled());
        assertTrue(myAccountPage.clickSignInButton()
                .isErrorMsgShown());
    }
}
