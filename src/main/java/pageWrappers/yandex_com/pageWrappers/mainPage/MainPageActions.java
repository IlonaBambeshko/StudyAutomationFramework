package pageWrappers.yandex_com.pageWrappers.mainPage;

import common.main.driver.UiDriver;
import common.main.elements.HtmlElement;
import common.main.waiter.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPageActions {
//	public static void waitSearchInputToBeDisplayed() {
//		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(4))
//				.withMessage("No search results")
//				.until(ExpectedConditions.visibilityOfElementLocated(MainPage.getSearchInput().getLocator()));
//	}

//	public static void waitLoginDeskToBeDisplayed() {
//		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(4))
//				.withMessage("No search results")
//				.until(ExpectedConditions.visibilityOfElementLocated(LoginDesk.getLoginDesk().getLocator()));
//	}

	@Step("Click login desk on the main page")
	public static void clickLoginDesk() {
		Waiter.waitUntilVisible(LoginDesk.getLoginDesk(), "Search input is not displayed");
		LoginDesk.getLoginDesk().click();
	}
}
