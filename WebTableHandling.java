package javasel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/shyam/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/ecosystem/");
		driver.manage().window().maximize();
		
		//How many rows
		int rows = driver.findElements(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr")).size();
		//how many cols
		int cols = driver.findElements(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table//thead/tr/th")).size();
		//specific row/data
		String lang = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr[4]/td[1]")).getText();
		System.out.println("Rows: "+rows+", Coloumns: "+ cols+", Language: "+lang);
		
		//printing every value
		/*for(int i=1;i<=rows;i++) {
			for(int j=1;j<cols;j++) {
				String data = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data+"                     ");
			}
			System.out.println();
		}*/
		
		
		//Get the language and author
		for(int i=1;i<=rows;i++) {
			String lan = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr["+i+"]/td[1]")).getText();
			
			if(lan.equals("JavaScript")) {
				String language = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr["+i+"]/td[1]")).getText();
				String author = driver.findElement(By.xpath("//div[@class='row justify-content-center p-5 td-box--100']/div/table/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(language+" -->  Author:  "+author);
			}
		}
		
		driver.quit();
	}

}
