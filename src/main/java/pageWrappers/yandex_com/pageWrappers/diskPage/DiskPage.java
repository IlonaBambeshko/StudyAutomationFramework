package pageWrappers.yandex_com.pageWrappers.diskPage;

import common.main.elements.Button;
import common.main.elements.HtmlElement;
import org.openqa.selenium.By;
import pageWrappers.yandex_com.BasePage;

public class DiskPage extends BasePage {
	private static final By LOADED_ITEM_LOCATOR = By.xpath("//div[1]/div[@class='listing-item__info']//span");
	private static final By MOVE_BUTTON_ON_MODAL_WINDOW_LOCATOR = By.xpath("//div[@class='dialog__wrap']//button[contains(@class, 'confirmation-dialog__button confirmation-dialog__button_submit')]");
	private static final By FILES_NAVIGATION_MENU_LOCATOR = By.xpath("//div/a[@title='Файлы']");
	private static final By FIRST_FILE_IN_DOWNLOADS_LOCATOR = By.xpath("//div[1]/div[@class='listing-item__info']//span");
	private static final By MOVE_OPTION_IN_CONTEXT_MENU_LOCATOR = By.xpath("//div[@class='resources-actions-popup__wrapper']//div[@value='move']");
	private static final By ITEM_IN_BASKET_LOCATOR = By.xpath("//span[contains(@title, 'fiile_to_attach')]/../../../div[1]");
	private static final By BASKET_LOCATOR = By.xpath("//span[contains(., 'Корзина')]/../../../div[1]");

	public static HtmlElement getLoadedItem() {
		return new HtmlElement(LOADED_ITEM_LOCATOR);
	}

	public static Button getMoveButtonOnModalWindow() {
		return new Button(MOVE_BUTTON_ON_MODAL_WINDOW_LOCATOR);
	}

	public static Button getFilesInNavigationMenu() {
		return new Button(FILES_NAVIGATION_MENU_LOCATOR);
	}

	public static HtmlElement getFirstFileInDownloads() {
		return new HtmlElement(FIRST_FILE_IN_DOWNLOADS_LOCATOR);
	}

	public static HtmlElement getMoveOptionInContextMenu() {
		return new HtmlElement(MOVE_OPTION_IN_CONTEXT_MENU_LOCATOR);
	}

	public static HtmlElement getItemInBasket() {
		return new HtmlElement(ITEM_IN_BASKET_LOCATOR);
	}

	public static HtmlElement getBasket() {
		return new HtmlElement(BASKET_LOCATOR);
	}


}
