package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class eLearningSteps {

	WebDriver driver;

	@Given("Launch E-learning website")
	public void to_launch_elearning_website() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
	}

	@When("SignUp button is displayed")
	public void signup_is_visible() {
		// Write the code here that turns the phrase above into concrete actions
		System.out.println(
				driver.findElement(By.xpath("//div[@id='login_block']//a[text()=' Sign up! ']")).isDisplayed());
	}

	@Then("Click SignUp button")
	public void click_Signup() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='login_block']//a[text()=' Sign up! ']")).click();
	}

	@Then("Fill the registration form for all mandatory fields")
	public void fill_form() {
		// Write code here that turns the phrase above into concrete actions
		// String userName = "nus";
		driver.findElement(By.name("firstname")).sendKeys("Nusrat");
		driver.findElement(By.name("lastname")).sendKeys("B");
		driver.findElement(By.name("email")).sendKeys("nusrat@gmail.com");
		driver.findElement(By.name("username")).sendKeys("nus46");
		driver.findElement(By.id("pass1")).sendKeys("123456");
		driver.findElement(By.id("pass2")).sendKeys("123456");
	}

	@Then("Click Register button")
	public void click_Register() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("submit")).click();
	}

	@Then("Verify {string}")
	public void verify(String string) {
		// Write code here that turns the phrase above into concrete actions
		
		WebElement element = driver.findElement(By.xpath("//*[text()='Your personal settings have been registered.']"));
		String error = element.getText();
		if (error.contains("Your personal settings have been registered.")) {
			System.out.println("Confirmation text matched");
		} else {
			System.out.println("Confirmation text does not match");
		}
	}

	@Then("Click Next")
	public void click_Next() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("next")).click();
	}

	@Then("on HomePage , click Username")
	public void on_HomePage_click_username() {
		// Write code here that turns the phrase above into concrete actions

		driver.findElement(By.xpath("//a[contains(@class,'dropdown-toggle')]")).click();
	}

	@Then("Choose profile from Dropdown and scroll down")
	public void choose_profile_from_Dropdown_and_scroll_down() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu')]//a[contains(text(),'Profile')]")).click();

	}

	@Then("Click on Messages icon")
	public void click_message_icon() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='sn-sidebar-collapse']/div/ul/li[@class='messages-icon ']/a")).click();
	}

	@Then("Click on Compose message")
	public void click_compose_message() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='toolbar']//img[@title='Compose message']")).click();
	}

	@Then("Enter the details shown on the page")
	public void enter_the_details_for_message() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).click();
		driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Sample Mail");
		driver.findElement(By.xpath("//*[@id='file-descrtiption']")).sendKeys("This is a sample mail");
		Thread.sleep(2000);
	}

	@Then("Click on Send message")
	public void click_send_message() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

}
