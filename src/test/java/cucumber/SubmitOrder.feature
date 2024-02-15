
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce page
  
  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to Cart
    And Checkout <productname> and submit the order	
    Then "THANK YOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                  |  password      | productName  |
      | rahulshetty@gamil.com |  IamKing@000   | ZARA COAT 3  |
