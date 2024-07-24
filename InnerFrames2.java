package javasel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InnerFrames2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_target");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		
		//IFrames
		driver.switchTo().frame("iframeResult"); //outerFrame => using name
		
		driver.switchTo().frame(0); //innerFrame => using index[0 because it is first Iframe inside the outerIframe].
		
		System.out.println("Text present in Inner IFrame: "+driver.findElement(By.xpath("//h1")).getText());
		driver.switchTo().parentFrame(); //moves back to parent Frame
		Thread.sleep(1000);
		
		String text = driver.findElement(By.xpath("//h2[contains(text(), 'Iframe - Target')]")).getText();
		System.out.println("Text present in Outer IFrame: "+ text);
		driver.switchTo().defaultContent(); //moves out of outer IFrame and comes to main body
		
		driver.quit();
	}

}
