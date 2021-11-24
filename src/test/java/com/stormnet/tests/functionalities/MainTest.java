package com.stormnet.tests.functionalities;

import com.stormnet.tests.BaseTest;
import common.main.driver.UiDriverActions;
import org.testng.annotations.Test;
import pageWrappers.yandex_com.pageWrappers.diskPage.DiskPageActions;
import pageWrappers.yandex_com.pageWrappers.loginPage.LoginPageActions;
import pageWrappers.yandex_com.pageWrappers.mailPage.MailPageActions;
import pageWrappers.yandex_com.pageWrappers.mainPage.MainPageActions;
import utility.testData.FileManager;
import utility.testData.PropertyManager;
import utility.testData.UserManager;
import utility.testData.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class MainTest extends BaseTest {

	@Test(description = "Main test C12345")
	public void C12345() throws IOException {
		// Preconditions
		// Get test data:
		User user = UserManager.getUserByIdFromList("C12345");
		Properties property = PropertyManager.getPropertyForTest();
		File file = FileManager.generateFile();
		String canonPath = file.getCanonicalPath();
		String fileName = file.getName();

		// Test
		// Main Page
		UiDriverActions.goToUrl(property.getProperty("baseurl"));
		MainPageActions.clickLoginDesk();

		// Login Page
		LoginPageActions.loginWithCreds
				(user.getUsername(), user.getPswd());

		// Mail Page
		MailPageActions.sendNewMessageWithParams(
				user.getUsername(),
				"test subject",
				"text for testing",
				canonPath,
				fileName);
		MailPageActions.checkMessageWithSubjectReceivedInInboxMail("test subject");
		MailPageActions.moveAttachmentFromMailToDisk("test subject", fileName);
		MailPageActions.checkMessageOnFrameSavedOnDisk();

		// Disk Page
		DiskPageActions.moveItemToFilesFolder(fileName);
		DiskPageActions.moveItemToBasket(fileName);
		DiskPageActions.checkItemInBasket(fileName);
	}
}
