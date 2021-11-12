package common.main.driver;

import common.main.elements.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UiDriverActions {
	public static String getTitle(){
		return UiDriver.getDriver().getTitle();
	}

	public static void maximise(){
		UiDriver.getDriver().manage().window().maximize();
	}

	public static void switchToTab(int tabNumber){
		ArrayList<String> tabs = new ArrayList (UiDriver.getDriver().getWindowHandles());
		UiDriver.getDriver().switchTo().window(tabs.get(tabNumber-1));
	}

	public static void switchToFrame(int frameNumber){
		UiDriver.getDriver().switchTo().frame(frameNumber);
	}



//	public HtmlElement waitForElement(By locator){
//		int attempts = 10;
//		while (attempts != 0) {
//			try {
//				return (HtmlElement) UiDriver.getDriver().findElement(locator);
//			} catch (NoSuchElementException e) {
//				attempts -= 1;
//			}
//		}
//		return null;
//	}
}
