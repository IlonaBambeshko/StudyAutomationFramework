package pageWrappers.yandex_com.pageWrappers.mainPage;

import common.main.elements.Button;
import common.main.elements.Input;
import org.openqa.selenium.By;
import pageWrappers.yandex_com.BasePage;

public class MainPage extends BasePage{
	private static final By SEARCH_INPUT_LOCATOR = By.cssSelector("span.input__box");

	public static Input getSearchInput() {
		return new Input(SEARCH_INPUT_LOCATOR);
	}


}