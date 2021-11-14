package common.main.driver;

import common.main.elements.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utility.logerator.Logger;

import java.util.ArrayList;

public class UiDriverActions {
	public static void goToUrl(String url) {
		UiDriver.getDriver().get(url);
	}

	public static String getTitle() {
		String title = UiDriver.getDriver().getTitle();
		Logger.getLogger().info("Got title window {}", title);
		return title;
	}

	public static void maximise() {
		UiDriver.getDriver().manage().window().maximize();
	}

	public static void refreshPage() {
		UiDriver.getDriver().navigate().refresh();
	}

	public static void switchToTab(int tabNumber) {
		ArrayList<String> tabs = new ArrayList(UiDriver.getDriver().getWindowHandles());
		// TODO: 12.11.21 до 2 вкладок получить сет на текущ вкладку, потом открыть 2 вкл, получить нов сет и потом вычесть и определить номер нов вкладки
		Logger.getLogger().info("Switching to {} tab", tabNumber - 1);
		UiDriver.getDriver().switchTo().window(tabs.get(tabNumber - 1));
	}

	public static void switchToFrame(int frameNumber) {
		Logger.getLogger().info("Switching to {} frame", frameNumber);
		UiDriver.getDriver().switchTo().frame(frameNumber);
	}

}
