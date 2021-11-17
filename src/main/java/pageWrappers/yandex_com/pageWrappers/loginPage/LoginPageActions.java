package pageWrappers.yandex_com.pageWrappers.loginPage;

import utility.waiter.Waiter;
import io.qameta.allure.Step;
import pageWrappers.yandex_com.BasePageActions;
import pageWrappers.yandex_com.pageWrappers.mailPage.MailPage;
import utility.logerator.Logger;

public class LoginPageActions extends BasePageActions {
	@Step("Fill username in form for login and submit")
	public static void fillUsername(String username) {
		Waiter.waitUntilVisible(LoginPage.getUserNameField(), "Username field is not displayed");
		LoginPage.getUserNameField().sendKeys(username);
		clickSignIn();
	}

	@Step("Fill password in form for login and submit")
	public static void fillPassword(String password) {
		Waiter.waitUntilVisible(LoginPage.getPasswordsField(), "Password field is not displayed");
		LoginPage.getPasswordsField().sendKeys(password);
		clickSignIn();
	}

	public static void clickSignIn() {
		Waiter.waitUntilVisible(LoginPage.getSignInButton(), "Sign in button is not displayed");
		LoginPage.getSignInButton().click();
	}

	@Step("Log in the mail with credentials {0}/{1}")
	public static void loginWithCreds(String userName, String password) {
		Logger.getLogger().info("Try to login as {}/{}", userName, password);
		fillUsername(userName);
		fillPassword(password);
		Waiter.waitLongUntilVisible(MailPage.getInboxMail(), "Inbox mail is not displayed");
		Logger.getLogger().info("Logged in as {}/{}", userName, password);
	}
}
