package common.main.actionsBuilder;

import common.main.waiter.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pageWrappers.yandex_com.pageWrappers.diskPage.DiskPage;

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
				Waiter.waitWithDurationOfMilliseconds(3000);
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
		getActionsBuilder().clickAndHold(targetElement)
				.moveToElement(toElement)
				.release(toElement)
				.build()
				.perform();
	}

	public static void doubleClick(WebElement targetElement){
		getActionsBuilder().moveToElement(targetElement)
				.doubleClick()
				.build()
				.perform();
	}
}
