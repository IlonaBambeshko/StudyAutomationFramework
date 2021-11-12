package common.main.driver;

import common.main.elements.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class UiDriverActions {
	public static void goToUrl(String url) {
		UiDriver.getDriver().get(url);
	}

	public static String getTitle() {
		return UiDriver.getDriver().getTitle();
	}

	public static void maximise() {
		UiDriver.getDriver().manage().window().maximize();
	}

	public static void switchToTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList(UiDriver.getDriver().getWindowHandles());
		UiDriver.getDriver().switchTo().window(tabs.get(tabNumber - 1));
	}

	public static void switchToFrame(int frameNumber) {
		UiDriver.getDriver().switchTo().frame(frameNumber);
	}

}
