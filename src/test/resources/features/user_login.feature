Feature: User login

  As a website user
  I want to be able to login to the website
  So that I can access all of its content

  Rule: User must provide valid credentials to login

    Example: Correct username and correct password
      Given I am on the login page
      When I enter my username "username1"
      And I enter my password "password1"
      Then I am logged in

    Example: Incorrect password
      Given I am on the login page
      When I enter my username "username1"
      And I enter my password "password2"
      Then I am not logged in
