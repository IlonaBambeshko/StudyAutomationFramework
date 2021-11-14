package com.stormnet.tests.functionalities;

import com.stormnet.tests.BaseTest;
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
		//todo property file, доставать с помощью getProperty baseUrl, property manager
		UiDriverActions.goToUrl("https://yandex.ru/");
		MainPageActions.clickLoginDesk();

		// Test
		// Login Page
		LoginPageActions.loginWithCreds("ilona_bambeshko@tut.by", "WsA32BV1ff"); // TODO: 12.11.21 выносить в json file test data manager

		// Mail Page
		MailPageActions.sendNewMessageWithParams(
				"ilona_bambeshko@tut.by",
				"test subject",
				"test text",
				"/home/user/fiile_to_attach.txt");
		MailPageActions.checkMessageWithSubjectReceivedInInboxMail("test subject");
		MailPageActions.moveAttachmentFromMailToDisk("fiile_to_attach.txt");
		MailPageActions.checkMessageOnFrameSavedOnDisk();

		// Disk Page
		DiskPageActions.moveItemToFilesFolder("fiile_to_attach.txt");
		DiskPageActions.moveItemToBasket("fiile_to_attach.txt");
		DiskPageActions.checkItemInBasket("fiile_to_attach.txt");
	}
}
