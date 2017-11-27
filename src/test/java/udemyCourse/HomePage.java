package udemyCourse;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    @Test(priority = 0)
    public void rootPageNavigation() throws IOException {
        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");
    }

    @Test(priority = 1)
    public void clickOnLogin() throws IOException {
        LandingPage logOnLanding = PageFactory.initElements(driver, LandingPage.class);
        logOnLanding.loginButton.click();
    }

}



