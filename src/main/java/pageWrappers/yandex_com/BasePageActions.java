package pageWrappers.yandex_com;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public abstract class BasePageActions {

	public static void clickOnElement(WebElement element) {
		boolean staleElement = true;
		int attempts = 7;
		while (staleElement && (attempts > 0)) {
			try {
				element.click();
				staleElement = false;
			} catch (StaleElementReferenceException | NullPointerException e) {
				attempts -= 1;
			}
		}
	}
}
