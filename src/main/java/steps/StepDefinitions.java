package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import factory.CartPage;
import factory.LocationSearchPage;
import factory.LoginPage;


public class StepDefinitions 
{
	WebDriver driver;		//declaring the WebDriver instance
	LoginPage loginPage;	//declaring the LoginPage instance
	CartPage cartPage;		//declaring the CartPage instance
	LocationSearchPage lsp;	//declaring the LocationSearchPage instance
	Actions act;			//declaring the Actions instance
	
	@Before
	//Code the execute before every test
	public void intitialize()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.mcdelivery.co.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		act=new Actions(driver);
		loginPage=new LoginPage(driver);
		cartPage=new CartPage(driver);
		lsp=new LocationSearchPage(driver);
	}
	
	@After
	// Code to execute after every test
	public void end()
	{
		driver.quit();
	}
	
	@Given("I will be on SignUp Page")
	public void i_will_be_on_SignUp_Page() {
		
		loginPage.clickLoginSignup();
		loginPage.clickLoginViaPassword();
	}

	@When("I enter mobile {string} and enter password {string}")
	public void i_enter_mobile_and_enter_password(String string, String string2) {
		
	    loginPage.enterMobileNo(string);
	    loginPage.enterPassword(string2);
	}

	@When("I click on Login")
	public void i_click_on_Login() {
		loginPage.clickLoginButton();
	  
	}

	@Then("I will be logged into my account")
	public void i_will_be_logged_into_my_account() {
		loginPage.checkLogin();
		driver.quit();
	}

	@When("I enter mobileno {string} and enter password {string}")
	public void i_enter_mobileno_and_enter_password(String string, String string2) {
		loginPage.enterMobileNo(string);
	    loginPage.enterPassword(string2);
	}

	@Then("Error message {string} should be displayed")
	public void error_message_should_be_displayed(String string) {
	    loginPage.checkInvalidUserPassMessage();
	}

	@Given("I will be navigated to location page")
	public void i_will_be_navigated_to_location_page() {
		loginPage.clickLoginSignup();
		loginPage.clickLoginViaPassword();
		loginPage.enterMobileNo("8179225291");
		loginPage.enterPassword("msrihari123");
		loginPage.clickLoginButton();
		driver.navigate().to("https://www.mcdelivery.co.in/serviciability/locateme/home");
	}

	@When("I enter a location with service as servinglocation {string}")
	public void i_enter_a_location_with_service_as_servinglocation(String string) throws InterruptedException {
		lsp.enterLocationSearch(string);
		Thread.sleep(2000);
		lsp.clickFirstButton();
		lsp.clickDoneButton();
		Thread.sleep(2000);
	}

	@When("I enter the address")///////////////////////////////////////////////////////////
	public void i_enter_the_address() {
	   
	}

	@Then("The location is set and visible on the top of the page")////////////////////////////////////////////
	public void the_location_is_set_and_visible_on_the_top_of_the_page() {
	    
	}

	@When("I enter a location without service as {string}")
	public void i_enter_a_location_without_service_as(String string) throws InterruptedException {
		lsp.enterLocationSearch(string);
		Thread.sleep(2000);
		lsp.clickFirstButton();
		lsp.clickDoneButton();
		Thread.sleep(2000);
	}

	@Then("Error Message says {string} is displayed")
	public void error_Message_says_is_displayed(String string) {
	   lsp.checkNotServeMessage();
	}

	@When("I entered invalid location as {string}")
	public void i_entered_invalid_location_as(String string) throws InterruptedException {
		lsp.enterLocationSearch(string);
		Thread.sleep(2000);
	}

	@Then("Error Message shown as {string}")
	public void error_Message_shown_as(String string) {
		lsp.checkNoLocationFoundMessage();
	}

	@Given("I have selected the delivery location")
	public void i_have_selected_the_delivery_location() {
		loginPage.clickLoginSignup();
		loginPage.clickLoginViaPassword();
		loginPage.enterMobileNo("8179225291");
		loginPage.enterPassword("msrihari123");
		loginPage.clickLoginButton();
	}

	@When("I search for validitem {string} in the search box")
	public void i_search_for_validitem_in_the_search_box(String string) throws InterruptedException {
	   Thread.sleep(1000);
	   cartPage.enterSearchItem(string);
	   Thread.sleep(1000);
	}

	@Then("I get the relevant items below")
	public void i_get_the_relevant_items_below() {
	    cartPage.checkAddButton();
	}

	@When("I search for invaliditem {string} in the search box")
	public void i_search_for_invaliditem_in_the_search_box(String string) throws InterruptedException {
	    cartPage.enterSearchItem(string);
	    Thread.sleep(2000);
	}

	@Then("Error message {string} is shown")
	public void error_message_is_shown(String string) {
	    cartPage.checkNoResultFound();
	}

	@Given("I have clicked on Add button of a product")
	public void i_have_clicked_on_Add_button_of_a_product() throws InterruptedException {
		loginPage.clickLoginSignup();
		loginPage.clickLoginViaPassword();
		loginPage.enterMobileNo("8179225291");
		loginPage.enterPassword("msrihari123");
		loginPage.clickLoginButton();
		Thread.sleep(2000);
		cartPage.enterSearchItem("burger");
		Thread.sleep(2000);
		cartPage.clickAddButton();
	}

	@When("I have selected coke and clicked on Add to cart button")
	public void i_have_selected_coke_and_clicked_on_Add_to_cart_button() throws InterruptedException {
		Thread.sleep(2000);
	    cartPage.clickAddCoke();
	    Thread.sleep(2000);
	    cartPage.clickAddToCartButton();
	    Thread.sleep(2000);
	}

	@Then("The custmoization should be added and product is added to cart")
	public void the_custmoization_should_be_added_and_product_is_added_to_cart() {
	    cartPage.checkViewCartButton();
	}

	@Given("I have added a customization")
	public void i_have_added_a_customization() throws InterruptedException {
		loginPage.clickLoginSignup();
		loginPage.clickLoginViaPassword();
		loginPage.enterMobileNo("8179225291");
		loginPage.enterPassword("msrihari123");
		loginPage.clickLoginButton();
		Thread.sleep(1000);
		cartPage.enterSearchItem("chicken");
		Thread.sleep(2000);
		cartPage.clickAddButton();
		Thread.sleep(2000);
	    cartPage.clickAddCoke();
	    
	}

	@When("I click on remove button of respective customization and click on Add to cart button")
	public void i_click_on_remove_button_of_respective_customization_and_click_on_Add_to_cart_button() throws InterruptedException {
		Thread.sleep(2000);
	    cartPage.clickRemoveCoke();
	    Thread.sleep(2000);
	    cartPage.clickAddToCartButton();
	}

	@Then("The customization should be deleted and product is added to cart")
	public void the_customization_should_be_deleted_and_product_is_added_to_cart() {
	   cartPage.checkViewCartButton();
	}

}
