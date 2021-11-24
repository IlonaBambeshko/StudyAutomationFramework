package common.main.driver;

import utility.logerator.Logger;

import java.util.Set;

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

	public static void switchToTheNextTab(Set<String> previousTabs) {
		Set<String> newTabs = UiDriverActions.getCurrentTabs();
		newTabs.removeAll(previousTabs);
		String newTabName = newTabs.stream().findFirst().get();
		UiDriver.getDriver().switchTo().window(newTabName);
		Logger.getLogger().info("Switching to {} tab", newTabName);
	}

	public static Set<String> getCurrentTabs() {
		return UiDriver.getDriver().getWindowHandles();
	}

}
