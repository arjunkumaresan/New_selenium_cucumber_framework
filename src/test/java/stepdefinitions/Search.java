package stepdefinitions;


import Pages.Homepage;
import Pages.Searchresultspage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Driverfactory;

public class Search {

    WebDriver driver;
    private Homepage homepage;
    private Searchresultspage searchresultspage;

    @Given("^User opens the application$")
    public void user_opens_the_application() throws Throwable {

        driver = Driverfactory.getDriver();
    }

    @When("^User enters valid product \"([^\"]*)\" into search box field$")
    public void user_enters_valid_product_into_search_box_field(String validproduct) throws Throwable {

        homepage=new Homepage(driver);
        homepage.searchvalidproduct(validproduct);


    }

    @When("^User click on search button$")
    public void user_click_on_search_button() throws Throwable {

        searchresultspage = homepage.searchmenu();

    }

    @Then("^User should get valid product displayed in the results$")
    public void user_should_get_valid_product_displayed_in_the_results() throws Throwable {
        searchresultspage = new Searchresultspage(driver);
        Assert.assertTrue(searchresultspage.validproductverification());
    }

    @Then("^User should get a message about no product matching$")
    public void user_should_get_a_message_about_no_product_matching() throws Throwable {

        Assert.assertTrue(searchresultspage.invalidproductverification());
    }

    @When("^User don't enter any product name into search box field$")
    public void user_don_t_enter_any_product_name_into_search_box_field() throws Throwable {

        Homepage homepage=new Homepage(driver);
        Thread.sleep(2000);
        homepage.searchvalidproduct(" ");

    }
}
