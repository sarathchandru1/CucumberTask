package com.flipkart.stepdefinition;

import java.awt.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.ast.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileSearchSteps {
		static String input;
	@Given("user lauches flipkart application")
	public void user_lauches_flipkart_application() {
	 
	 Hooks.driver.get("https://www.flipkart.com/");
	 

	@Given("user enters credentials and click on login")
	public void user_enters_credentials_and_click_on_login() {
	    try {
	    	WebElement xbutton = Hooks.driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	    	xbutton.isDisplayed();
	    	xbutton.click();
	    }catch (Exception e) {
	    	System.out.println("Popup is not displayed");
	    }
	}
	@When("user searching the mobile")
	public void user_searching_the_mobile() {
	   WebElement search = Hooks.driver.findElement(By.name("q"));
	   input = "Samsung";
	   search.sendKeys("Samsung",Keys.ENTER);
	}
static String parentURL;
	@When("user click on add to cart")
	public void user_click_on_add_to_cart() {
		WebElement mobileName = Hooks.driver.findElement(By.xpath("(//div[contains(text(),"+input+")])[2]"));
		   mobileName.click();
		   
		    parentURL = Hooks.driver.getWindowHandle();
		   Set<String> childURL = Hooks.driver.getWindowHandles();
		   for(String child : childURL) {
			   if(!parentURL.equals(child)) {
			   Hooks.driver.switchTo().window(child);
		   }
		   }
	
	Hooks.driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
	
	    
	}
	@Then("navigates into add to cart and check the order to updated")
	public void navigates_into_add_to_cart_and_check_the_order_to_updated() {
		Hooks.driver.switchTo().window(parentURL);
		Hooks.driver.findElement(By.xpath("//span[text()='cart']")).click();
		try {
	    	WebElement xbutton = Hooks.driver.findElement(By.xpath("//button[text()='X']"));
	    	xbutton.isDisplayed();
	    	xbutton.click();
	    }catch (Exception e) {
	    	System.out.println("Popup is not displayed");
	    }
		Assert.assertTrue(Hooks.driver.findElement(By.xpath("//span[text()='Place Order']")).isDisplayed());
	}
	
	@When("user searching the mobile by one dimensional list concept")
	public void user_searching_the_mobile_by_one_dimensional_list_concept(DataTable dataTable) {
	List<String> datas = dataTable.asList(String.class);
	
		WebElement search = Hooks.driver.findElement(By.name("q"));
		input = datas.getItem(1);
		search.sendKeys(input,Keys.ENTER);
	} 
	
	@When("user searching the mobile by one dimensional list concept")
	public void user_searching_the_mobile_by_one_dimensional_map_concept(DataTable dataTable) {
		Map<String, String> datas = dataTable.asMap(String.class, String.class);
		WebElement search = Hooks.driver.findElement(By.name("q"));
		input = datas.get("Phone1");
		search.sendKeys(input,Keys.ENTER);
	} 
	@When("user searching the mobile {string}")
	public void user_searching_the_mobile(String phoneName) {
		WebElement search = findElement(By.name("q"));
		input = phoneName;
		search.sendKeys(input,Keys.ENTER);
	}   
 
}
