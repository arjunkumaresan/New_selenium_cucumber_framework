package stepdefinitions;

import Factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {

    WebDriver driver;
    @Given("^User opens the application$")
    public void user_opens_the_application() throws Throwable {

        driver = Driverfactory.getdriver();
    }

    @When("^User enters valid product \"([^\"]*)\" into search box field$")
    public void user_enters_valid_product_into_search_box_field(String validproduct) throws Throwable {

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(validproduct);
    }

    @When("^User click on search button$")
    public void user_click_on_search_button() throws Throwable {

        driver.findElement(By.xpath("//button[contains(@class,'btn btn-default')]")).click();
    }

    @Then("^User should get valid product displayed in the results$")
    public void user_should_get_valid_product_displayed_in_the_results() throws Throwable {

        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @Then("^User should get a message about no product matching$")
    public void user_should_get_a_message_about_no_product_matching() throws Throwable {

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).isDisplayed());
    }

    @When("^User don't enter any product name into search box field$")
    public void user_don_t_enter_any_product_name_into_search_box_field() throws Throwable {

        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(" ");
    }
}
