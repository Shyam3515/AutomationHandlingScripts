package javasel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Simple Alerts with OK button
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		driver.switchTo().alert().accept(); //close alert by using ok
		Thread.sleep(1000);
		
		//Alert window with OK and cancel
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss(); //close alert by using cancel
		Thread.sleep(1000);
		
		//Alert Prompt window with OK and cancel
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Alert alertWindow = driver.switchTo().alert(); 
		
		System.out.println("Message displayed on Alert is :"+ alertWindow.getText());
		alertWindow.sendKeys("Welcome");
		alertWindow.accept();
		Thread.sleep(1000);

		driver.quit();
	}

}
