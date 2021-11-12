package pageWrappers.yandex_com.pageWrappers.diskPage;

import common.main.actionsBuilder.ActionsBuilder;
import common.main.waiter.Waiter;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageWrappers.yandex_com.BasePageActions;

public class DiskPageActions extends BasePageActions {

	@Step("Move item from Downloads to Files")
	public static void moveItemToFiles(){
		Waiter.waitUntilVisible(DiskPage.getLoadedItem(), "Loaded item is not displayed");
		Assert.assertTrue(DiskPage.getLoadedItem().getElement().getText().contains("fiile_to_attach"));
		ActionsBuilder.rightClick(DiskPage.getFirstFileInDownloads().getElement());
		chooseMoveInContextMenu();
		clickMoveButtonOnModalWindow();
		Waiter.waitWithDurationOfMilliseconds(2000);
	}

	@Step("Move item from Files to Basket")
	public static void moveItemToBasket(){
		Waiter.waitUntilVisible(DiskPage.getFilesInNavigationMenu(), "Files section in left menu is not displayed");
		DiskPage.getFilesInNavigationMenu().click();
		Waiter.waitWithDurationOfMilliseconds(2000);
		ActionsBuilder.dragAndDropAction(DiskPage.getItemInBasket().getElement(), DiskPage.getBasket().getElement());
		Waiter.waitWithDurationOfMilliseconds(2000);
		ActionsBuilder.doubleClick(DiskPage.getBasket().getElement());
		Waiter.waitWithDurationOfMilliseconds(2000);
		Waiter.waitUntilVisible(DiskPage.getItemInBasket(), "Deleted item is not displayed");
	}

	@Step("Choose 'Move' in context menu")
	public static void chooseMoveInContextMenu(){
		Waiter.waitUntilVisible(DiskPage.getMoveOptionInContextMenu(), "Check mailbox button is not displayed");
		DiskPage.getMoveOptionInContextMenu().click();
	}

	@Step("Click 'Move' button on the modal window")
	public static void clickMoveButtonOnModalWindow(){
		Waiter.waitUntilVisible(DiskPage.getMoveButtonOnModalWindow(), "Loaded item is not displayed");
		DiskPage.getMoveButtonOnModalWindow().click();
	}
}
