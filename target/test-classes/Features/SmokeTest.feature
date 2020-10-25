Feature: Feature to test make an order functionality in 'My store' we app
  Background: Setup environment
    Given browser is defined

  Scenario: Check login is successful with valid credentials
    Given user is on home page
    When user goes to SIGN IN form
    And user enters valid credentials in the input fields
    And user hits enter
    Then user is successfully logged on My store
    
    Scenario: Search for blouse and add it to the cart
    Given: User is on homepage and is logged in
    When Search for a blouse in the search box
    And click on search button
    And user adds product to the cart
    Then Product is successfully added to users shopping cart

    Scenario: Proceed to checkout after checking shopping cart summary
    Given User has added the product to the cart
    When User checks all details about shopping cart 
    And User clicks to proceed to checkout
    Then User continues with his order
    
    Scenario: Proceed to checkout after checking details about addresses
    Given User has continued to finish his order
    When User checks all details about addresses 
    And User clicks on proceed to checkout
    Then User continues to finish his order
    
    Scenario: Proceed to checkout after checking details about shipping
    Given User is on card to check details about shipping
    When User checks all details about shipping 
    And User agrees with terms of services
    And User clicks to proceed
    Then User is one step to finish his order
    
    Scenario: Proceed to checkout after choosing payment method
    Given User is on card with two payment methods
    When User one more time checks all details about shipping 
    And User clicks on chosen payment metod
    And User checks details about metod
    Then User has successfully completed the order


    
    