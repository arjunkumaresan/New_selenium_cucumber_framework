package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.Properties;

public class Driverfactory {

    static WebDriver driver = null;
    public static WebDriver Initializebrowser(String browsername)
    {

        if(browsername.equals("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(browsername.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browsername.equals("edge"))
        {
            driver = new EdgeDriver();
        }
        else if(browsername.equals("safari"))
        {
            driver = new SafariDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Common_utils.PAGE_LOAD_TIME));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Common_utils.IMPLICIT_WAIT_TIME));

        return driver;
    }
    public static WebDriver getDriver()
    {
        return driver;
    }
}
