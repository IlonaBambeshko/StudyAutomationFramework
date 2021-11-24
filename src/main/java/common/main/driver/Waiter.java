package common.main.driver;

import common.main.driver.UiDriver;
import common.main.elements.HtmlElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
	private static int defaultWaitTimeInSeconds = TIMEOUT.TEN_SEC.seconds;
	private static int longWaitTimeInSeconds = TIMEOUT.TWENTY_SEC.seconds;

	public Waiter(TIMEOUT defaultTimeout, TIMEOUT longTimeout) {
		defaultWaitTimeInSeconds = defaultTimeout.seconds;
		longWaitTimeInSeconds = longTimeout.seconds;
	}

	public Waiter() {
	}

	public static void waitUntilVisible(HtmlElement element, String message) {
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(defaultWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
	}

	public static void waitLongUntilVisible(HtmlElement element, String message) {
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(longWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
	}

	public static void waitUntilClickable(HtmlElement element, String message) {
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(defaultWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.elementToBeClickable(element.getLocator()));
	}

	public static void waitFrameToBeAvailableAndSwitch(HtmlElement element, String message) {
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(defaultWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element.getLocator()));
	}

	public static void waitWithDurationOfMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public enum TIMEOUT {
		FIVE_SEC(5),
		EIGHT_SEC(8),
		TEN_SEC(10),
		TWENTY_SEC(20);

		int seconds;

		TIMEOUT(int seconds) {
			this.seconds = seconds;
		}

		public int getSeconds() {
			return seconds;
		}
	}

}
