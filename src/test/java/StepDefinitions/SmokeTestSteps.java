package StepDefinitions;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SmokeTestSteps {
	
	public static WebDriver createWebDriver(String browserName) {
		if ("firefox".equals(browserName)) {
			return new FirefoxDriver();
		} else if ("chrome".equals(browserName)) {
			return new ChromeDriver();
		}
		throw new RuntimeException("Unsupported webdriver: " + browserName);
	}
	
	static WebDriver driver;
	@Given("browser is defined")
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");

	}

	@Given("user is on home page")
	public void user_is_on_home_page() {

	driver = createWebDriver(System.getProperty("browser"));
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	
	driver.navigate().to("http://automationpractice.com/index.php");
	}
	
	@When("user goes to SIGN IN form")
	public void user_goes_to_SIGN_IN_form() {
	driver.findElement(By.className("login")).click();
	
	}
	
	@And("user enters valid credentials in the input fields")
	public void user_enters_valid_credentials_in_the_input_fields() {
	driver.findElement(By.id("email")).sendKeys("tester072020@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("Testing2020");
	}
	
	@And("user hits enter")
	public void user_hits_enter() {
	driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Then("user is successfully logged on My store")
	public void user_is_successfully_logged_on_My_store() {
	driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders.");
	System.out.println("User is successfully logged on My store");
	}

	@When("Search for a blouse in the search box")
	public void Search_for_a_blouse_in_the_search_box() {
	driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
	}
	
	@And("click on search button")
	public void click_on_search_button() {
	driver.findElement(By.className("button-search")).click();
	}

	@And("user adds product to the cart")
	public void user_adds_product_to_the_cart() {
		WebElement searchBtn = driver.findElement(By.className("product_img_link"));

		Actions action = new Actions(driver);
		action.moveToElement(searchBtn).perform();
		
		driver.findElement(By.className("ajax_add_to_cart_button")).click();
	}

	@Then("Product is successfully added to users shopping cart")
	public void Product_is_successfully_added_users_shopping_cart() {
		driver.getPageSource().contains("Product successfully added to your shopping cart");
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=order']")).click();
		System.out.println("Product is successfully added to users shopping cart");
	}

	@Given("User has added the product to the cart")
	public void user_has_added_the_product_to_the_cart() {
		driver.findElement(By.id("cart_title")).isDisplayed();
	}

	@When("User checks all details about shopping cart")
	public void user_checks_all_details_about_shopping_cart() {
		driver.getPageSource().contains("Total");
	}

	@And("User clicks to proceed to checkout")
	public void user_clicks_to_proceed_to_checkout() {
		driver.findElement(By.className("standard-checkout")).click();
	}

	@Then("User continues with his order")
	public void user_continues_with_his_order() {
		System.out.println("After checking all details in shopping-cart summary card, user continues with his order");
	}

	@Given("User has continued to finish his order")
	public void user_has_continued_to_finish_his_order() {
		driver.getPageSource().contains("Addresses");
	}

	@When("User checks all details about addresses")
	public void user_checks_all_details_about_addresses() {
		driver.getPageSource().contains("Choose a delivery address:");
	}

	@And("User clicks on proceed to checkout")
	public void user_clicks_on_proceed_to_checkout() {
		driver.findElement(By.name("processAddress")).click();
	}

	@Then("User continues to finish his order")
	public void user_continues_to_finish_his_order() {
		System.out.println("After checking all details in addresses card, user continues with his order");
	}

	@Given("User is on card to check details about shipping")
	public void user_is_on_card_to_check_details_about_shipping() {
		driver.findElement(By.className("page-heading")).isDisplayed();
	}

	@When("User checks all details about shipping")
	public void user_checks_all_details_about_shipping() {
		driver.getPageSource().contains("Terms of service");
	}

	@And("User agrees with terms of services")
	public void user_agrees_with_terms_of_services() {
		driver.findElement(By.id("cgv")).click();
	}

	@And("User clicks to proceed")
	public void user_clicks_to_proceed() {
		driver.findElement(By.name("processCarrier")).click();
	}

	@Then("User is one step to finish his order")
	public void user_is_one_step_to_finish_his_order() {
		System.out.println("User is one step to finish his order");
	}

	@Given("User is on card with two payment methods")
	public void user_is_on_card_to_view_two_payment_methods() {
		driver.findElement(By.className("page-heading")).isDisplayed();
	}

	@When("User one more time checks all details about shipping")
	public void user_one_more_time_checks_all_details_about_shipping() {
		driver.getPageSource().contains("Please choose your payment method");
	}

	@And("User clicks on chosen payment metod")
	public void user_clicks_on_chosen_payment_metod() {
		driver.findElement(By.className("bankwire")).click();
	}

	@And("User checks details about metod")
	public void user_checks_details_about_metod() {
		driver.findElement(By.className("page-heading")).isDisplayed();
	}

	@Then("User has successfully completed the order")
	public void user_has_successfully_completed_the_order() {
		driver.findElement(By.xpath("//span[.='I confirm my order']")).click();
		System.out.println("User has successfully completed the order");
		driver.findElement(By.className("logout")).click();

		driver.close();
	}
}


