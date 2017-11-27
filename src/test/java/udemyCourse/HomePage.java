package udemyCourse;

import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    @Test
    public void rootPageNavigation() throws IOException {
        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");
    }
}
