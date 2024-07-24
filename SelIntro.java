package javasel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntro {

	public static void main(String[] args) throws InterruptedException {
		
		// we want to refer only webDriver implemented methods.
		//So here, the moment your script identified that you have defined your chrome driver locally, then selenium manager will not be in active state.
		//That will be disabled. So it will not check for web, because you already have it in your local and you are nicely giving the path also.

        //So it will directly invoke the chrome driver and that chrome driver will be ultimately responsible to invoke your browser and from there things will go on.
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		//@@@@@@@@@@@@@@@@@ Xpath @@@@@@@@@@@@@@@
		//Tagname[@AttibuteName = 'value']
		
		
		//########### CSS selector #############
		// class name -> tagname.classname -> button.signInBtn -> .error
		// Id => tagname#id -> input#inputUsername
		// tagname[attribute='value']
		// <input type="text" placeholder="Name">       -->     input[placeholder='Name']
		//tagname[@attribute='value']:nth-child(index) -- child items
		// parenttagname childtagname
		
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.xpath("//form/p")).getText());
		driver.findElement(By.xpath("//input[@id='Username']")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		driver.quit();
	}

}
