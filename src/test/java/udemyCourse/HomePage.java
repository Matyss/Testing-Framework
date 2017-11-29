package udemyCourse;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @BeforeTest
    public void initBrowser() throws IOException {
        driver = initializeDriver();
    }


    @Test(priority = 0)
    public void rootPageNavigation() {
        driver.get("http://qaclickacademy.com");
        LandingPage landingPageElements = PageFactory.initElements(driver, LandingPage.class);
        //Assertions to test
        Assert.assertTrue(landingPageElements.landingPageTitle().contains("QA Click Academy"));
        Assert.assertTrue(landingPageElements.navbar.isDisplayed());
        Assert.assertEquals(landingPageElements.getNavbarSize(), 7);
    }

    @Test(priority = 1)
    public void clickOnLogin() throws IOException {
        LandingPage logOnLanding = PageFactory.initElements(driver, LandingPage.class);
        logOnLanding.loginButton.click();
    }

    @Test(priority = 2, dataProvider = "getData")
    public void loginUser(String userName, String password) {
        LoginPage provideCredentials = PageFactory.initElements(driver, LoginPage.class);
        provideCredentials.userEmail.sendKeys(userName);
        provideCredentials.userPassword.sendKeys(password);

    }

    @AfterTest
    public void terminate() {
        driver.close();
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[1][2];

        data[0][0] = "acb@gmail.com";
        data[0][1] = "somepassword";

        return data;
    }

}



