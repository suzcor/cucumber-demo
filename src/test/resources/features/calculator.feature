@Regression
Feature: Addition

  As a calculator user
  I want to calculate the sum of two numbers
  So that I can make good calculations

  Rule: Adding two numbers should provide their sum

    Example: Correct sum of two numbers
      Given I enter 50 into the calculator
      And I enter 70 into the calculator
      When I add the numbers
      Then the result should be 120

    Example: Incorrect sum of two numbers
      Given I enter 70 into the calculator
      And I enter 50 into the calculator
      When I add the numbers
      Then the result should not be 20

