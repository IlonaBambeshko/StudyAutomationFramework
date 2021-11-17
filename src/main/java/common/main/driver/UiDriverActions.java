package common.main.driver;

import utility.logerator.Logger;

import java.util.HashSet;
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

	public static void switchToTheNextTab(Set previousTabs) {
		Logger.getLogger().info("Switching to {} tab");
		Set newTabs = UiDriverActions.getCurrentTabs();
		newTabs.removeAll(previousTabs);
		UiDriver.getDriver().switchTo().window(newTabs.stream().findFirst().get().toString());
	}

	public static Set getCurrentTabs() {
		return new HashSet<>(UiDriver.getDriver().getWindowHandles());
	}

}
