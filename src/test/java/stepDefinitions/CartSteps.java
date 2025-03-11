package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartSteps {
	private WebDriver driver;
	@Before("@CartTest")
	public void setup() throws InterruptedException {
		driver=new ChromeDriver();
		
	}
    @Given("I am on the login page")
    public void i_am_on_the_login_page() throws InterruptedException {
   	        driver.get("https://www.saucedemo.com/");   
    }
    @When("I enter valid credentials")
    public void i_enter_valid_credentials() throws InterruptedException {
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
    	  driver.findElement(By.id("login-button")).click();
    	  Thread.sleep(5000);
    }
    @When("User clicks the button for the product")
    public void userClicksTheButtonForThe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        product.click();
    }
    @Then("The cart badge displays")
    public void theCartBadgeDisplays() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        String actualCount = cartBadge.getText();
        Assert.assertEquals(actualCount, "1", "Cart badge count is incorrect.");
    }
    @BeforeStep
    public void beforeStep() {
        System.out.println("Starting step: " + driver.getTitle());
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Finished step: " + driver.getTitle());
    }

    @Given("Log the start of the step")
    public void logStartOfStep(){
        System.out.println("Start of step");
    }

    @Given("Log the end of the step")
    public void logEndOfStep(){
        System.out.println("End of step");
    }

    @After("@CartTest")
	public void tearDown() {
		if (driver != null) {
			driver.quit();
        }
    }}
