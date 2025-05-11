package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.Driverfactory;

import java.time.Duration;

public class Hooks {
    WebDriver driver;

    @Before
    public void setup()
    {
        Driverfactory.Initializebrowser("chrome");
        driver = Driverfactory.getdriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @After
    public void teardown()
    {
        driver.quit();
    }
}
