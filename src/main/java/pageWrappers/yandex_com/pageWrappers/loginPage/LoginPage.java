package pageWrappers.yandex_com.pageWrappers.loginPage;

import common.main.elements.Button;
import common.main.elements.Input;
import org.openqa.selenium.By;
import pageWrappers.yandex_com.BasePage;

public class LoginPage extends BasePage {

	// Locators:
	private static final By USERNAME_FIELD_LOCATOR = By.id("passp-field-login");
	private static final By PASSWORD_FIELD_LOCATOR = By.id("passp-field-passwd");
	private static final By SIGN_IN_BUTTON_LOCATOR = By.id("passp:sign-in");
	private static final String FILLED_PASSWORD_FIELD_PATTERN = "//input[@value='%s']";


	// Methods:
	public static Input getUserNameField() {
		return new Input(USERNAME_FIELD_LOCATOR);
	}

	public static Input getPasswordsField() {
		return new Input(PASSWORD_FIELD_LOCATOR);
	}

	public static Input getFilledPasswordField(String pswd) {
		return new Input(By.xpath(String.format(FILLED_PASSWORD_FIELD_PATTERN, pswd)));
	}

	public static Button getSignInButton() {
		return new Button(SIGN_IN_BUTTON_LOCATOR);
	}
}
