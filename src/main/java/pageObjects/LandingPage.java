package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {

    public WebDriver driver;

    @FindBy(how = How.CSS, using = "#homepage > header > div.tools > div > nav > ul > li:nth-child(4)")
    public WebElement loginButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
}
