package javasel;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloading {

	public static void main(String[] args) throws InterruptedException {
		
		String location = System.getProperty("user.dir")+"\\Downloads\\";
		
		//Chrome -> to download in desired location
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory",location);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		//normally also it will download by clicking in default download section
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/mnjuser/profile");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//login
		driver.findElement(By.id("usernameField")).sendKeys("sundarqa24@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Yadla@2000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[@class='icon-wrap']")).click();
		
		
		//For edge everything will be same, you need to use Edge driver and EdgeOptions.
	}

}
