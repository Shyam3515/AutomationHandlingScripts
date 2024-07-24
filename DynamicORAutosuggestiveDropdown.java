package javasel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicORAutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		//For dynamics, enter the city we need and get all the dynamic options available in the dropDown;
		//check if it contains the required city.
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		
		String city = "Hyderabad";
		driver.findElement(By.cssSelector("#fromCity")).sendKeys("hyd");
		Thread.sleep(1000);
		List<WebElement> options =  driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li/div/div/p"));
		
		for(WebElement ele : options) {
			System.out.println(ele.getText());
			String optionToSelect = ele.getText();
			if(optionToSelect.contains(city)) {
				ele.click();
				break;
			}
		}
	}

}
