package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Crawler;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoCompleteGoogle {
    @Given("User navigates to Google")
    public void user_navigates_to_google(){

        new Crawler().navigateToGoogle();

    }

    @When("User searches for {string}")
    public  void user_searches_for (String searchTerm){
        new Crawler().enterSearchTerm(searchTerm);
    }

    @Then("Following search results should be displayed")
    public void following_search_results_should_be_displayed(DataTable dataTable){
        List<String> expected = dataTable.asList().stream().skip(1).toList();
        List<String> actual = new Crawler().getAutoCompleteResults();
        Assert.assertEquals("Lists are not equal" , expected,actual);


    }

}
