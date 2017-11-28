package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    public WebDriver driver;


    @FindBy(how = How.CSS, using = "#user_email")
    public WebElement userEmail;

    @FindBy(how = How.CSS, using = "#user_password")
    public WebElement userPassword;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
