package common.main.waiter;

import common.main.driver.UiDriver;
import common.main.elements.HtmlElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

public class Waiter {
	private static int defaultWaitTimeInSeconds = 10;
	private static int longWaitTimeInSeconds = 15;

	public Waiter(int defaultTimeout, int longTimeout) {
		defaultWaitTimeInSeconds = defaultTimeout;
		longWaitTimeInSeconds = longTimeout;
	}

	public Waiter() {
	}

	public static void waitUntilVisible(HtmlElement element, String message){
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(defaultWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
	}

	public static void waitLongUntilVisible(HtmlElement element, String message){
		new WebDriverWait(UiDriver.getDriver(), Duration.ofSeconds(longWaitTimeInSeconds))
				.withMessage(message)
				.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
	}

	public static void waitWithDurationOfMilliseconds(int milliseconds){
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static HtmlElement fluentWaitOfDisplayedElement(HtmlElement element){
		FluentWait wait = new FluentWait(UiDriver.getDriver());
		wait.withTimeout(Duration.ofSeconds(18));
		wait.pollingEvery(Duration.ofSeconds(10));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element.getLocator()));
		return element;
	}

	public static void fluentWait(int seconds){
		FluentWait wait = new FluentWait(UiDriver.getDriver());
		wait.withTimeout(Duration.ofSeconds(seconds));

	}
}