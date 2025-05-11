package stepdefinitions;

import Factory.Driverfactory;
import java.util.Map;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Register {

    WebDriver driver;
    @Given("^User navigate to register page$")
    public void user_navigate_to_register_page() throws Throwable {

        driver  = Driverfactory.getdriver();
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @When("^User enters the details into below fields$")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) throws Throwable {

        Map<String, String> datamap = dataTable.asMap(String.class,String.class);
        driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("firstname"));
        driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("lastname"));
        driver.findElement(By.id("input-email")).sendKeys(datamap.get("email"));
        driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(datamap.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("password"));

    }

    @When("^User selects privacy policy$")
    public void user_selects_privacy_policy() throws Throwable {

        driver.findElement(By.name("agree")).click();
    }

    @When("^User clicks on continue button$")
    public void user_clicks_on_continue_button() throws Throwable {

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("^User account shout get created successfully$")
    public void user_account_shout_get_created_successfully() throws Throwable {

        Assert.assertEquals("Your Account Has Been Created!",driver.findElement(By.xpath("//div[@id='content']/h1")).getText());

    }

    @When("^User select yes for news letter$")
    public void user_select_yes_for_news_letter() throws Throwable {

        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
    }

    @Then("^User account shout get proper warning message about duplicate email$")
    public void user_account_shout_get_proper_warning_message_about_duplicate_email() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));

    }

    @When("^User don't enter any details into fields$")
    public void user_don_t_enter_any_details_into_fields() throws Throwable {

    }

    @Then("^User should get proper warning message for every mandatory fields$")
    public void user_should_get_proper_warning_message_for_every_mandatory_fields() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
        Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());


    }
}
