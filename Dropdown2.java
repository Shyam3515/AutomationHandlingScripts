package javasel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		Thread.sleep(1000);
		
		WebElement drpEle = driver.findElement(By.id("course")); //--> step 1
		//to select options from dropDown we need to use select class
		//select class contains a default constructor which accepts the element
		Select drop = new Select(drpEle);
		
//		drop.selectByVisibleText("Javascript");//to give the value present in dropdown
//		drop.selectByValue("java");//giving options attribute value
//		drop.selectByIndex(3);
		
		//selecting options from options without using methods
		List<WebElement> options =drop.getOptions();
		
		for(WebElement opt : options) {
			if(opt.getText().equals("Javascript")) {
				opt.click();
				break;
			}
		}
		
		//we can handle multiple dropdowns also by getting the path of the dropdown as step 1;
		//and remaining steps we can store in one method and call that method by passing the dropdown path as parameter. 
	}

}
