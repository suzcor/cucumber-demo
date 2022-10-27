package com.suzanne.cucumberdemo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
  private final String password = "password1";
  private String currentPage;
  private int firstNumber;
  private int secondNumber;

  @Before
  public void setup() {
    currentPage = "/home";
    firstNumber = 0;
    secondNumber = 0;
  }

  @Given("I am on the login page")
  public void iAmOnTheLoginPage() {
    System.out.println("Browsing to the login page");
  }

  @When("I enter my username {string}")
  public void iEnterMyUsername(String arg0) {
    System.out.printf("Entering username %s\n", arg0);
  }

  @And("I enter my password {string}")
  public void iEnterMyPassword(String arg0) {
    System.out.printf("Entering password %s\n", arg0);
    authenticateUser(password.equals(arg0));
  }

  @Then("I am logged in")
  public void iAmLoggedIn() {
    assertThat("User is not at the home page", currentPage, is("/home"));
  }

  @Then("I am not logged in")
  public void verifyNoRedirect() {
    assertThat("User is at the home page", currentPage, is("/error"));
  }

  @Given("I enter {int} into the calculator")
  public void iEnterIntoTheCalculator(int arg0) {
    System.out.printf("Entering number %d into calculator\n", arg0);
    setNumber(arg0);
  }

  @When("I add the numbers")
  public void iAddTheNumbers() {
    System.out.println("Adding the two numbers");
  }

  @Then("the result should be {int}")
  public void theResultShouldBe(int arg0) {
    int expected = firstNumber + secondNumber;
    assertThat(expected, is(arg0));
  }

  @Then("the result should not be {int}")
  public void theResultShouldNotBe(int arg0) {
    int expected = firstNumber + secondNumber;

    assertThat(expected, is(not(arg0)));
  }

  private void authenticateUser(boolean authenticated) {
    currentPage = authenticated ? "/home" : "/error";
  }

  private void setNumber(int arg0) {
    if (firstNumber == 0) {
      firstNumber = arg0;
    } else {
      secondNumber = arg0;
    }
  }
}
