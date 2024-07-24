package javasel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDropDown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.id("dob")).click();
		
		//Select month dropdown
		Select drp_mon = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		drp_mon.selectByVisibleText("Dec");
		
		Select drp_yr = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		drp_yr.selectByVisibleText("2000");
		
		//get all dates
		String selectDate = "6";
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
		for(WebElement ele:allDates) {
			String date = ele.getText();
			if(date.equals(selectDate)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(1000);
		
		driver.quit();

	}

}
