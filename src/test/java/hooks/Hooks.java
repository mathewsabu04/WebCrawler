package hooks;

import io.cucumber.java.Before;  // Cucumber-specific Before annotation
import io.cucumber.java.After;   // Cucumber-specific After annotation
import org.example.WebDriverManger;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver webDriver;

    @Before
    public void setup(){
        this.webDriver = WebDriverManger.getDriver();
        System.out.println("Runs at the beginning of a test");
    }

    @After
    public void tearDown(){
        WebDriverManger.getDriver().quit();
        System.out.println("Runs at the end of a test");
    }
}
