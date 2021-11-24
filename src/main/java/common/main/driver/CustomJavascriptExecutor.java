package common.main.driver;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static common.main.driver.UiDriver.getDriver;

public class CustomJavascriptExecutor {
	private static String clickCommand = "arguments[0].click();";

	public CustomJavascriptExecutor() {

	}

	public static void executeClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) getDriver();
		executor.executeScript(clickCommand, element);
	}

}
