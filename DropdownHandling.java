package javasel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://twoplugs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		WebElement dropdown = driver.findElement(By.name("category_id"));
		
		Select dropSelect = new Select(dropdown);
		List <WebElement> options = dropSelect.getOptions();
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		//copy dropdown options into two lists
		for(WebElement option:options) {
			originalList.add(option.getText());
			tempList.add(option.getText());
		}
		
		//Sorting temp list
		Collections.sort(tempList);
		
		//compare originalList with sortedTempList
		if(originalList.equals(tempList)) {
			System.out.println("Sorted Dropdown");
		}else {
			System.out.println("UnSorted Dropdown");
		}

		driver.quit();
	}

}
