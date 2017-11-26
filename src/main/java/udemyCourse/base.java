package udemyCourse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException{

        Properties browserProps = new Properties();
        FileInputStream browserConfigFile = new FileInputStream("C:\\Users\\m_szymajda\\IdeaProjects\\completeFramework\\src\\main\\java\\udemyCourse\\browserConfigFile.properties");

        browserProps.load(browserConfigFile);
        String browserName = browserProps.getProperty("browser");

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.firefox.marionette", "C:\\Testing\\geckodriver-v0.19.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "C:\\Testing\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Browser " + browserName + " is invalid, launching Chrome browser as default choice...");
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

}
