package pageWrappers.yandex_com.pageWrappers.mainPage;

import common.main.driver.UiDriverActions;
import utility.waiter.Waiter;
import io.qameta.allure.Step;

import java.util.Set;

public class MainPageActions {

	@Step("Click login desk on the main page")
	public static void clickLoginDesk() {
		Waiter.waitUntilVisible(LoginDesk.getLoginDesk(), "Search input is not displayed");
		Set currentTabs = UiDriverActions.getCurrentTabs();
		LoginDesk.getLoginDesk().click();
		UiDriverActions.switchToTheNextTab(currentTabs);
	}
}
