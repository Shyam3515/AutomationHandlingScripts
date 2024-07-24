package javasel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownsWithoutSelectClass {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.get("https://www.bstackdemo.com/");
		 driver.manage().window().maximize();
		 
		 //Method 1: By storing all the options in List and iterating through it
		 driver.findElement(By.xpath("//select")).click();  
		 List<WebElement> allOptions=driver.findElements(By.cssSelector("select option"));
		 
		 String option="Highest to lowest";
		 for(WebElement el:allOptions) {
             if(el.getText().contains(option)) {
                   el.click();

             }
		 }
		 Thread.sleep(2000);
		 
		 // Method 2: By creating Custom Locator and without iterating the List
		 String opt ="Lowest to highest";
		 WebElement dropdown =driver.findElement(By.xpath("//select/option[contains(text(), '"+opt+"')]"));
		 dropdown.click();
		 
		 driver.quit();
	}

}
