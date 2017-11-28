package udemyCourse;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
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
    }

    @Test(priority = 1)
    public void clickOnLogin() throws IOException {
        LandingPage logOnLanding = PageFactory.initElements(driver, LandingPage.class);
        logOnLanding.loginButton.click();
    }

    @Test(priority = 2)
    public void loginUser() {
        LoginPage provideCredentials = PageFactory.initElements(driver, LoginPage.class);
        provideCredentials.userEmail.sendKeys("acb@gmail.com");
        provideCredentials.userPassword.sendKeys("somepassword");

    }

}



