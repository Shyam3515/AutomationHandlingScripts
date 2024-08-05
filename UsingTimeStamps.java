package Screenshots;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingTimeStamps {

	public static void main(String[] args) throws IOException {
		Date current = new Date();
		String date = current.toString().replace(" ", "-").replace(":", "-").replace("-IST", "");
		System.out.println(date);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//screenshots/"+ date +".png");
		FileUtils.copyFile(src, dest);

		driver.quit();
	}

}
