package pageWrappers.yandex_com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static common.main.driver.UiDriver.getDriver;

public abstract class BasePageActions {

//	public static void waitUntilVisible(By locator) {
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//		wait.withMessage("Page was not opened")
//				.until(ExpectedConditions.visibilityOfElementLocated(locator));
//	}

	public static void waitLongUntilVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.withMessage("Page was not opened")
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
