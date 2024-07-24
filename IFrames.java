package javasel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrames {

	//driver.switchTo().frame(name of the frame / id of the frame)
	//driver.switchTo().frame(WebElement) //xPath
	//driver.switchTo().frame(0) //index

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/iframe");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//First IFrame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class ='interactive is-tabbed-standard-height']")));
		driver.findElement(By.id("css")).click();
		//comes back to main window 
		driver.switchTo().defaultContent();
		
		
		String text = driver.findElement(By.xpath("//div/ul[@class=\"auth-container\"]/li[2]/a/span")).getText();
		System.out.println(text);
		
		driver.quit();
	}

}
