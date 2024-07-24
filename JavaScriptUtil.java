package javasel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptUtil {
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void clickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void generateAlert(String message, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+ message +"')");
	}
	
	public static void refreshBrowserByJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public static void zoomByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");
	}
	
	public static void flashByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0;i<50;i++) {
			changeColor("#000000",element,driver);
			changeColor(bgColor,element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
		try{
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
	}
	
	public static void practice(WebElement element, WebDriver driver) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
//		js.executeAsyncScript("arguments[0].style.border='3px solid red'", element);
//		String title = js.executeScript("return document.title;").toString();
//		js.executeScript("arguments[0].click()", element);
//		js.executeScript("alert('"+message+"')");
//		js.executeScript("history.go(0)");
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); //down
//		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); //up
//		js.executeScript("document.body.style.zoom = '50%'");
		
//		String bgColor = element.getCssValue("backgroundColor");
//		js.executeScript("arguments[0].style.backgroundColor='"+bgColor+"'", element);
	}
};
