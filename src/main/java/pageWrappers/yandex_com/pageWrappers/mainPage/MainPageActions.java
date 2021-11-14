package pageWrappers.yandex_com.pageWrappers.mainPage;

import common.main.driver.UiDriverActions;
import common.main.waiter.Waiter;
import io.qameta.allure.Step;

public class MainPageActions {

	@Step("Click login desk on the main page")
	public static void clickLoginDesk() {
		Waiter.waitUntilVisible(LoginDesk.getLoginDesk(), "Search input is not displayed");
		LoginDesk.getLoginDesk().click();
		UiDriverActions.switchToTab(2);
	}
}
