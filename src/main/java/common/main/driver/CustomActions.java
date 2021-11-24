package common.main.driver;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomActions {

	public CustomActions() {
	}

	public static void moveToElement(WebElement element){
		new Actions(UiDriver.getDriver()).moveToElement(element).perform();
	}

	public static void rightClick(WebElement element){
		boolean staleElement = true;
		while (staleElement) {
			try{
				new Actions(UiDriver.getDriver()).moveToElement(element)
						.contextClick(element)
						.build()
						.perform();
				staleElement = false;
			} catch (StaleElementReferenceException e){
				staleElement = true;
			}
		}
	}

	public static void dragAndDropAction(WebElement targetElement, WebElement toElement) {
		new Actions(UiDriver.getDriver()).clickAndHold(targetElement)
				.moveToElement(toElement)
				.release(toElement)
				.build()
				.perform();
	}

	public static void doubleClick(WebElement targetElement){
		new Actions(UiDriver.getDriver()).moveToElement(targetElement)
				.doubleClick()
				.build()
				.perform();
	}
}
