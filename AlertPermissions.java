package javasel;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertPermissions {

	public static void main(String[] args) throws InterruptedException {
		
		// INIT CHROME OPTIONS
	    ChromeOptions options = new ChromeOptions();
	    HashMap < String, Object > prefs = new HashMap < String, Object > ();
	    HashMap < String, Object > profile = new HashMap < String, Object > ();
	    HashMap < String, Object > contentSettings = new HashMap < String, Object > ();

	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
		
		
//		options.addArguments("--disable-notifications"); //for notifications
//		options.addArguments("disable-geolocation"); // for location
//		options.addArguments("disable-media-stream"); //for cam, mic
		
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/geolocation");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Where am I?']")).click();

	}

}
