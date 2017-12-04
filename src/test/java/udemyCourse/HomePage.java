package udemyCourse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    public static Logger logs = LogManager.getLogger(Base.class.getName());

    LandingPage landingPageElements;
    LoginPage loginPageElements;

    @BeforeTest
    public void initBrowser() throws IOException {
        driver = initializeDriver();
        landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        loginPageElements = PageFactory.initElements(driver, LoginPage.class);
        logs.info("Driver is initialized");
    }


    @Test(priority = 0)
    public void rootPageNavigation() {
        driver.get(rootURL);
        //Assertions to test
        Assert.assertTrue(landingPageElements.landingPageTitle().contains("QA Click Academy"));
        logs.info("Successfully navigated to given URL");

        Assert.assertTrue(landingPageElements.navbar.isDisplayed());
        Assert.assertEquals(landingPageElements.getNavbarSize(), 7);
        logs.info("Navbar is displayed, size is confirmed");
    }

    @Test(priority = 1)
    public void clickOnLogin() throws IOException {
        Assert.assertTrue(landingPageElements.loginButton.isDisplayed());
        landingPageElements.loginButton.click();
    }

    @Test(priority = 2, dataProvider = "getData")
    public void loginUser(String userName, String password) {
        loginPageElements.loginPage_Action(userName, password);

    }

    @AfterTest
    public void terminate() {
        driver.close();

        //Clear the memory after each test
        driver = null;
        logs.info("==================== END TEST ====================");
    }



    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[1][2];

        data[0][0] = "acb@gmail.com";
        data[0][1] = "somepassword";

        return data;
    }

}



