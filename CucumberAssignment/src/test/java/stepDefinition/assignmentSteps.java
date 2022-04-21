package stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class assignmentSteps {

	WebDriver driver;

	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(DataTable dataTable) {

		List<Map<String, String>> login = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> loginDetails : login) {
			driver.findElement(By.id("user-name")).sendKeys(loginDetails.get("username"));
			driver.findElement(By.id("password")).sendKeys(loginDetails.get("password"));
			driver.findElement(By.id("login-button")).click();

		}
	}

	@Given("user adds required item to cart")
	public void user_adds_required_item_to_cart() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		Thread.sleep(2000);
			}

	@Given("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
	}

	@Given("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkout(DataTable dataTable) {
		List<Map<String, String>> checkout = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> checkoutDetails : checkout) {

			driver.findElement(By.id("first-name")).sendKeys(checkoutDetails.get("FirstName"));
			driver.findElement(By.id("last-name")).sendKeys(checkoutDetails.get("LastName"));
			driver.findElement(By.id("postal-code")).sendKeys(checkoutDetails.get("PostalCode"));

		}

	}

	@When("user confirm checkout")
	public void user_confirm_checkout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_message() {

		String expectedMessage = "THANK YOU FOR YOUR ORDER";

		String actualMessage = driver.findElement(By.xpath(
				"//*[contains(text(), 'THANK YOU FOR YOUR ORDER')]"))
				.getText();

		assertEquals(expectedMessage, actualMessage);
		System.out.println("First scenario successful!");
		driver.quit();

	}

	@Given("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-onesie']")).click();
		System.out.println("Second scenario successful!");
		//driver.quit();
	}

	@Given("user sorts item low to high")
	public void user_sorts_item_low_to_high() {

		Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		select.selectByVisibleText("Price (low to high)");
		System.out.println("Third scenario successful!");
		//driver.quit();
	}

}
