package pageWrappers.yandex_com.pageWrappers.diskPage;

import common.main.elements.Button;
import common.main.elements.HtmlElement;
import org.openqa.selenium.By;
import pageWrappers.yandex_com.BasePage;

public class DiskPage extends BasePage {
	// Locators:
	private static final By LOADED_ITEM_LOCATOR = By.xpath("//div/div[@class='listing-item__info']//span");
	private static final By MOVE_BUTTON_ON_MODAL_WINDOW_LOCATOR = By.xpath("//span[contains(., 'Переместить')]/../../button[contains(@class, 'confirmation-dialog__button_submit')]");
	private static final By FILES_NAVIGATION_MENU_LOCATOR = By.xpath("//div/a[@title='Файлы']");
	private static final By MOVE_OPTION_IN_CONTEXT_MENU_LOCATOR = By.xpath("//div[@class='resources-actions-popup__wrapper']//div[@value='move']");
	private static final By BASKET_LOCATOR = By.xpath("//span[contains(., 'Корзина')]/../../../div[1]");

	// Patterns:
	private static final String FILE_IN_DOWNLOADS_PATTERN = "//div/div[@class='listing-item__info']//span[contains(., '%s')]";
	private static final String NOTIFICATION_ABOUT_MOVED_FILE_PATTERN = "//div[@class='notifications__text js-message'][contains(., 'Файл «\"%s\"» перемещен')] | //div[@class='notifications__text js-message'][contains(., 'Файл «\"%s\"» перемещён')]";
	private static final String FILE_IN_BASKET_PATTERN = "//span[contains(@title, '%s')]/../../../div[1]";

	// Methods:
	private static By notificationAboutMovedFileLocator(String fileName){
		String fullPass = NOTIFICATION_ABOUT_MOVED_FILE_PATTERN.replace("%s", fileName).replace("\"", "");
		return By.xpath(fullPass);
	}

	private static By fileInBasketLocator(String fileName){
		return By.xpath(String.format(FILE_IN_BASKET_PATTERN, fileName));
	}

	private static By fileInDownloadsLocator(String fileName){
		return By.xpath(String.format(FILE_IN_DOWNLOADS_PATTERN, fileName));
	}

	public static HtmlElement getFileInDownloads(String fileName) {
		return new HtmlElement(fileInDownloadsLocator(fileName));
	}

	public static HtmlElement getNotificationAboutMovedFile(String fileName) {
		return new HtmlElement(notificationAboutMovedFileLocator(fileName));
	}

	public static Button getMoveButtonOnModalWindow() {
		return new Button(MOVE_BUTTON_ON_MODAL_WINDOW_LOCATOR);
	}

	public static Button getFilesInNavigationMenu() {
		return new Button(FILES_NAVIGATION_MENU_LOCATOR);
	}

	public static HtmlElement getLoadedItem() {
		return new HtmlElement(LOADED_ITEM_LOCATOR);
	}

	public static HtmlElement getMoveOptionInContextMenu() {
		return new HtmlElement(MOVE_OPTION_IN_CONTEXT_MENU_LOCATOR);
	}

	public static HtmlElement getItemInBasket(String fileName) {
		return new HtmlElement(fileInBasketLocator(fileName));
	}

	public static HtmlElement getBasket() {
		return new HtmlElement(BASKET_LOCATOR);
	}

}
