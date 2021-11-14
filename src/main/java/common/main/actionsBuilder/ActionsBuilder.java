package common.main.actionsBuilder;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static common.main.driver.UiDriver.getDriver;

public class ActionsBuilder {
	private static Actions actionsBuilder;

	public static Actions getActionsBuilder() {
		if (actionsBuilder == null){
			actionsBuilder = new Actions(getDriver());
		}
		return actionsBuilder;
	}

	private ActionsBuilder() {
		Actions actionsBuilder = new Actions(getDriver());
		this.actionsBuilder = actionsBuilder;
	}

	public static void moveToElementAndClick(WebElement element){
		getActionsBuilder().moveToElement(element).click();
	}

	public static void rightClick(WebElement element){
		boolean staleElement = true;
		while (staleElement) {
			try{
				getActionsBuilder().moveToElement(element)
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
		getActionsBuilder().dragAndDrop(targetElement, toElement);
	}

	public static void doubleClick(WebElement targetElement){
		getActionsBuilder().moveToElement(targetElement)
				.doubleClick()
				.build()
				.perform();
	}
}
