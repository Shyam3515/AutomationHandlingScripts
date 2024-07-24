package javasel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/mnjuser/profile");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//login
		driver.findElement(By.id("usernameField")).sendKeys("sundarqa24@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Yadla@2000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		
		//give some time to open
		//using sendKeys(), when type=file; sendKeys("C:\\Users\\shyam\\Documents\\Resumes\\Testing Resume.pdf")
		driver.findElement(By.xpath("//input[@value='Update resume']")).click();
		//here we need to follow further using robot class, as our file type is not file.
		// if we are unable to click, upload then we need to use JavaScriptExecutor
		
		/**
		 Now we need to copy path, paste it and press enter
		 */
		Robot rb = new Robot();
		rb.delay(2000);
		
		//these two statements will copy the path, where the file exists, and copy the path to clipboard;
		StringSelection ss = new StringSelection("C:\\Users\\shyam\\Documents\\Resumes\\Sundar Testing Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Ctrl+V
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		//NOW RELEASE THE KEYS
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		//now press enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		driver.quit();
	}

}
