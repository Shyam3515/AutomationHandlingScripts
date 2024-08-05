package javasel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllFieldsValidations {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://stock.scriptinglogic.in/amol.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//check boxes
		WebElement java = driver.findElement(By.id("check0"));
		WebElement selenium = driver.findElement(By.id("check1"));
		WebElement cucumber = driver.findElement(By.id("check2"));
		
		if(java.isSelected()) {
			java.click();
		}
		if(selenium.isSelected()) {
			selenium.click();
		}
		if(cucumber.isSelected()) {
			cucumber.click();
		}
		
		
		//Multi options select
		WebElement multiSelText = driver.findElement(By.id("multiSel"));
		Thread.sleep(2000);
		
		Select selText = new Select(multiSelText);
		selText.selectByVisibleText("text 1");
		selText.selectByIndex(1);
		selText.selectByIndex(2);
		Thread.sleep(3000);
		
		selText.deselectByIndex(0);
		Thread.sleep(1000);
		
		driver.quit();
	}

}
