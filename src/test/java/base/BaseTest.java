package base;

import com.svitlana_karapuhina.core.appium.DriverFactory;
import com.svitlana_karapuhina.pages.BasePage;
import com.svitlana_karapuhina.pages.abstarctPages.AbstractMainPage;
import com.svitlana_karapuhina.pages.abstarctPages.AbstractMyAccountPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    BasePage basePage;

    protected AbstractMainPage mainPage = AbstractMainPage.getInstance();
    protected AbstractMyAccountPage myAccountPage = AbstractMyAccountPage.getInstance();


    @BeforeTest()
    public void setUp() {
        basePage = new BasePage();
    }

    @AfterTest
    public void tearDown() {
        DriverFactory.getDriver().quit();
    }

}
