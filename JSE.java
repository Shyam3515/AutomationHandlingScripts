package javasel;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSE {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//driver is an instance of webdriver js is an instance of JSE, so we can't directly assign driver to JSE, so we have to typecast it.
		//but when we create the instance as ChromeDriver we can directly assign it, bcz JSE can hold the object of ChromeDriver
		
		/*Syntax
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(Script, args);
		*/
		
		//Draw Border
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
//		JavaScriptUtil.drawBorder(logo, driver);
		//TakesScreenshot interface
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\logo.png");
		FileUtils.copyFile(src, trg);
		
		
		//GetTitle
//		String title = JavaScriptUtil.getTitleByJs(driver);
//		System.out.println(title);
		
		
		//click action
		WebElement regLink = driver.findElement(By.xpath("//a[text()='Register']"));
//		JavaScriptUtil.clickElementByJs(regLink, driver);
		
		
		//Alert message
//		JavaScriptUtil.generateAlert("This is alert...", driver);
		
		
		//Refresh Browser
//		JavaScriptUtil.refreshBrowserByJS(driver);
		
		
		//Scroll Down
//		JavaScriptUtil.scrollPageDown(driver);
		Thread.sleep(2000);
		
		//Scroll Up
//		JavaScriptUtil.scrollPageUp(driver);
		
		
		//Zoom
//		JavaScriptUtil.zoomByJs(driver);
		
		//flash
		WebElement element = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		JavaScriptUtil.flashByJs(element, driver);
		
		driver.quit();
	}

}
