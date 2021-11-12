package pageWrappers.yandex_com.pageWrappers.mainPage;

import common.main.elements.HtmlElement;
import org.openqa.selenium.By;

public class LoginDesk extends MainPage {
	private static final By LOGIN_DESK_LOCATOR = By.cssSelector("div.desk-notif-card__login-new-items");

	public static HtmlElement getLoginDesk() {
		return new HtmlElement(LOGIN_DESK_LOCATOR);
	}
}
