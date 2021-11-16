package com.flipkart.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSteps {
	@Given("user lanches amazon application")
	public void user_lanches_amazon_application() {
		Hooks.driver.get("https://www.amazon.com/");
		
	}
	@When("user search mobiles")
	public void user_search_mobiles() {
		Hooks.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles",Keys.ENTER);
}
	@Then("user validate the mobile page")
	public void user_validate_the_mobile_page() {
}
}