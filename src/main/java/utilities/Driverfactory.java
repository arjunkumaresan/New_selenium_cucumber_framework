package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driverfactory {

    static WebDriver driver;
    public static void Initializebrowser(String browsername)
    {


        if(browsername.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
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



    }
    public static WebDriver getdriver()
    {
        return driver;
    }
}
