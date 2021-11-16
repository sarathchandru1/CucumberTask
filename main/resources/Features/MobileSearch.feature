#Author: sarath@your.domain.com
Feature: Mobile Search Validation

Background:
    Given user lauches flipkart application
    And user enters credentials and click on login

    Scenario: Testing Mobile Purchase
    When user searching the mobile
    And user click on add to cart
    Then navigates into add to cart and check the order to updated
    
    Scenario: Testing Mobile Purchase by 1 dim list
    When user searching the mobile by one dimensional list concept
    |iPhone|Samsung|OnePlus|Nokia|
    And user click on add to cart
    Then navigates into add to cart and check the order to updated

    Scenario: Testing Mobile Purchase by 1 dim Map
    When user searching the mobile by one dimensional map concept
    |Phone1|iPhone|
    |Phone2|Samsung|
    |Phone3|OnePlus|
    |Phone4|Nokia|
    And user click on add to cart
    Then navigates into add to cart and check the order to updated
    

 
    Scenario Outline:
    When user searching the mobile "<Phone names>"
    And user click on add to cart
    Then navigates into add to cart and check the order to updated
    Examples:
    |Phone names|
    |iPhone|
    |Samsung|
    