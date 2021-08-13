package com.cybertek.step_definitions;

import com.cybertek.pages.DropdownsPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions
{
    LibraryLoginPage loginPage = new LibraryLoginPage();
    DropdownsPage dropdownsPage = new DropdownsPage();


    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");

    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        //1- Get the dropdown as a select object
        Select  monthDropDrown = new Select(dropdownsPage.month);

        //2- Gel all the options from the dropdown and store inside of a list
        // command enter short cut of recommendation of name
        List<WebElement> actualMontHsAsWebElement = monthDropDrown.getOptions();

        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(actualMontHsAsWebElement));









//
//        // Convert the actualMonths from List<WebElement> to List<String>
//        List<String> actualMonthsAsString = new ArrayList<>();
//
//        //iter is shortcut for loop
//        for (WebElement each : actualMontHsAsWebElement) {
//
//            actualMonthsAsString.add(each.getText());
//        }
//
//        Assert.assertEquals(expectedList,actualMonthsAsString);

    }


    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(Map<String,String> loginInfo) {

        String username = loginInfo.get("username");
        // yukarda yaptigimiz gibi store da edebilriiz asagidaki gibi direk data yazabiliriz
        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(loginInfo.get("password"));

        loginPage.signIn.click();

    }

    @Then("user should see title is Library")
    public void userShouldSeeTitleIsLibrary() {
        String expectedTitle = "Library";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {

        System.out.println("listOfFruits.size() = " + listOfFruits.size());
        System.out.println(listOfFruits);
    }



}
