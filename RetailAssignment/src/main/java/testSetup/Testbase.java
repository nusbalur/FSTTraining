package testSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
	public static WebDriver driver;
	
	public static WebDriver openBrowser() {
		try {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
			
		} catch(Exception e) {
			
			System.out.println("Unable to launch Browser :"+e.getClass()+"--"+e.getMessage());
		}
		
		return driver;
		
	}

}
