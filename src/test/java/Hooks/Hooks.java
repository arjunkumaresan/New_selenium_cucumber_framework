package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;
import utilities.Driverfactory;

import java.time.Duration;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;


    @Before
    public void setup()
    {
        Properties prop = new ConfigReader().initializeProperties();
        driver = Driverfactory.Initializebrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));

    }

    @After
    public void teardown(Scenario scenario)
    {
        String scenarioname = scenario.getName().replaceAll(" "," ");
        if(scenario.isFailed())
        {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenarioname);
        }
        driver.quit();
    }
}
