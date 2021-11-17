package pageWrappers.yandex_com.pageWrappers.diskPage;

import utility.actionsBuilder.ActionsBuilder;
import utility.waiter.Waiter;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import pageWrappers.yandex_com.BasePageActions;

public class DiskPageActions extends BasePageActions {

	@Step("Move item from Downloads to Files")
	public static void moveItemToFilesFolder(String fileNameWithExtension) {
		Waiter.waitUntilVisible(DiskPage.getLoadedItem(), "Loaded item is not displayed");
		Assert.assertTrue(DiskPage.getLoadedItem().getElement().getText().contains(fileNameWithExtension.replace(".txt", "")));
		ActionsBuilder.rightClick(DiskPage.getFileInDownloads(fileNameWithExtension.replace(".txt", "")).getElement());
		chooseMoveInContextMenu();
		clickMoveButtonOnModalWindow();
		Waiter.waitLongUntilVisible(DiskPage.getNotificationAboutMovedFile(fileNameWithExtension), "File hasn't been replaced");
	}

	@Step("Move item from Files to Basket")
	public static void moveItemToBasket(String fileNameWithExtension) {
		DiskPage.getFilesInNavigationMenu().click();
		Waiter.waitUntilVisible((DiskPage.getItemInBasket(
				fileNameWithExtension.replace(".txt", ""))), "Element is not displayed");
		ActionsBuilder.dragAndDropAction(
				DiskPage.getItemInBasket(fileNameWithExtension.replace(".txt", "")).getElement(),
				DiskPage.getBasket().getElement());
		Waiter.waitLongUntilVisible(DiskPage.getNotificationAboutMovedFile(
				fileNameWithExtension), "File hasn't been deleted");
		ActionsBuilder.doubleClick(DiskPage.getBasket().getElement());
	}

	@Step("Choose 'Move' in context menu")
	public static void chooseMoveInContextMenu() {
		Waiter.waitUntilVisible(DiskPage.getMoveOptionInContextMenu(), "Check mailbox button is not displayed");
		DiskPage.getMoveOptionInContextMenu().click();
	}

	@Step("Click 'Move' button on the modal window")
	public static void clickMoveButtonOnModalWindow() {
		boolean notClickableElement = true;
		int attempts = 5;
		while ((notClickableElement) && (attempts > 0)) {
			try {
				Waiter.waitUntilVisible(DiskPage.getMoveButtonOnModalWindow(), "Loaded item is not displayed");
				DiskPage.getMoveButtonOnModalWindow().click();
				notClickableElement = false;
			} catch (WebDriverException e) {
				attempts -= 1;
			}
		}
	}

	@Step("Check item in Basket")
	public static void checkItemInBasket(String fileNameWithExtension) {
		Waiter.waitLongUntilVisible(DiskPage.getItemInBasket(
				fileNameWithExtension.replace(".txt", "")), "Deleted item is not displayed");
	}
}
