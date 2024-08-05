package javasel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// WebDriverManager in Selenium is an open-source Java library automating the management of Selenium WebDriver drivers like chromedriver,...
		// The primary use of WebDriverManager is the automation of driver management. To use this feature, you need to select a given manager in the WebDriverMager API 
		//(e.g., chromedriver() for Chrome) and invoke the method setup() .
		
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		/*
		//getWindowHandle()
		String windowId = driver.getWindowHandle();
		System.out.println(windowId);//280BB1B5C3B439416A05F8411940CCDA
		*/
		
		//clicking on link which moves to another window
		driver.findElement(By.xpath("//div[@class='overlay-panel overlay-right']/button[@class='ghost']")).click();
		
		//=> Open a new window/tab  => driver.get(“https://example.com”); driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> windowIds =driver.getWindowHandles();
		
		
		//First Method -- Iterator()
		/*
		Iterator <String> it = windowIds.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		System.out.println(parentWindowId+", "+ childWindowId);
		*/
		
		//Second method using List ---> ArrayList is a class which implements the List Interface.
		List<String> windowIDsList = new ArrayList(windowIds); // converting set to --> list/
		
		/*String parentWindowId = windowIDsList.get(0);
		String childWindowId = windowIDsList.get(1);
		System.out.println(parentWindowId+", "+ childWindowId);
		Thread.sleep(1000);
		
		//How to use windowId;s for switching
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window title :"+ driver.getTitle());
		
		driver.switchTo().window(childWindowId);
		System.out.println("Child Window title :"+ driver.getTitle());
		*/
		
		//For each loop
		for(String winid : windowIDsList) {
			driver.switchTo().window(winid);
			System.out.println(driver.getTitle());
		};
		
		driver.quit();
	}

}
