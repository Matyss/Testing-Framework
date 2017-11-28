package resources;

//Selenium imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//Utilities
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;

    //Info method to print browser name
    public void chosenBrowser(String browserName) {
        System.out.println("Initializing " + browserName);
    }

    //Main init class to define driver config
    public WebDriver initializeDriver() throws IOException{

        //Create object for browser file configuration
        Properties browserProps = new Properties();
        FileInputStream browserConfigFile = new FileInputStream("C:\\Users\\m_szymajda\\IdeaProjects\\completeFramework\\src\\main\\java\\resources\\browserConfigFile.properties");

        browserProps.load(browserConfigFile);
        String browserName = browserProps.getProperty("browser");



        //Check for browser configuration file input
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                chosenBrowser(browserName);
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Testing\\geckodriver-v0.19.1-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                chosenBrowser(browserName);
                break;
            case "IE":
                System.setProperty("webdriver.ie.driver", "C:\\Testing\\IEDriverServer_x64_3.7.0\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                chosenBrowser(browserName);
                break;
            default:
                System.out.println("Browser " + browserName + " is invalid, launching Chrome browser as default choice...");
                System.setProperty("webdriver.chrome.driver", "C:\\Testing\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
        }

        //Setup custom implicit wait for test methods
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Clear cookies and maximize window
        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted");
        driver.manage().window().maximize();
        System.out.println("Maximizing window");

        return driver;
    }

}
