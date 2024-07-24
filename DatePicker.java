package javasel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//https://smrutisouravsahoo06.medium.com/calendar-type-iii-not-able-to-inspect-elements-on-calendar-21247feaf6f8
//need to remove blur event listeners
public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://redbus.in/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		String month = "Dec";
		String year = "2024";
		String date = "6";
		
		driver.findElement(By.xpath("//div[@id='onwardCal']")).click();
		Thread.sleep(1000);
		
		
		while(true) {
			String text = driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[2]")).getText();
			String dt[] = text.split("\n")[0].split(" ");//splitting by lines
			System.out.println(dt[0]+","+dt[1]);
			String mon = dt[0];
			String yr = dt[1];
			
			if(mon.equalsIgnoreCase(month) && yr.equals(year)) {
				break;
			}else {
				//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[3]//*[name()='svg']
				driver.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']/div[3]")).click();
			}	
		}
		
		//Date Selection
		driver.findElement(By.xpath("//div[@class='DayTiles__CalendarDaysBlock-sc-1xum02u-0 isgDNj']/span[text()='6']")).click();
		String text1 = driver.findElement(By.xpath("//div[@class='sc-kAzzGY cCrHkP']/text[2]")).getText();
		String text2 = driver.findElement(By.xpath("//div[@class='sc-kAzzGY cCrHkP']/text[3]")).getText();
		System.out.println("Selected date: "+text1+" "+text2);
		driver.quit();
		
		
	}

}
