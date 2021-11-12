package com.stormnet.tests.functionalities;

import com.stormnet.tests.BaseTest;
import common.main.driver.UiDriver;
import common.main.driver.UiDriverActions;
import org.testng.annotations.Test;
import pageWrappers.yandex_com.pageWrappers.diskPage.DiskPageActions;
import pageWrappers.yandex_com.pageWrappers.loginPage.LoginPageActions;
import pageWrappers.yandex_com.pageWrappers.mailPage.MailPageActions;
import pageWrappers.yandex_com.pageWrappers.mainPage.MainPageActions;

public class MainTest extends BaseTest {

	@Test(description = "Main test")
	public void mainTest() {
		// Preconditions
		UiDriverActions.goToUrl("https://yandex.ru/");
		MainPageActions.clickLoginDesk();
		UiDriverActions.switchToTab(2);

		// Test
		// Login Page
		LoginPageActions.loginWithCreds("ilona_bambeshko@tut.by", "gjgf1823qwerty");

		// Mail Page
		MailPageActions.sendNewMessageWithAttachment("ilona_bambeshko@tut.by", "test subject", "test text", "/home/user/fiile_to_attach.txt");
		MailPageActions.checkMessageInInboxMail();
		MailPageActions.moveAttachmentFromMailToDisk();
		UiDriverActions.switchToFrame(3);
		MailPageActions.checkFileIsSavedOnDisk();
		MailPageActions.moveToDisk();
		UiDriverActions.switchToTab(3);

		// Disk Page
		DiskPageActions.moveItemToFiles();
		DiskPageActions.moveItemToBasket();
	}
}
