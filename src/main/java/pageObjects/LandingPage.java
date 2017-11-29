package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LandingPage {

    //Driver declaration
    public WebDriver driver;

    //Page objects methods
    @FindBy(how = How.CSS, using = "#homepage > header > div.tools > div > nav > ul > li:nth-child(4)")
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = "#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul")
    public WebElement navbar;


    public int getNavbarSize() {
        return navbar.findElements(By.tagName("li")).size();
    }

    public String landingPageTitle() {
        return driver.getTitle();
    }

    //Constructor for driver on landing page
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
}
