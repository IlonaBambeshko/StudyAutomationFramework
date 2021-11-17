package com.stormnet.tests.functionalities;

import com.stormnet.tests.BaseTest;
import common.main.driver.UiDriverActions;
import org.testng.annotations.Test;
import pageWrappers.yandex_com.pageWrappers.diskPage.DiskPageActions;
import pageWrappers.yandex_com.pageWrappers.loginPage.LoginPageActions;
import pageWrappers.yandex_com.pageWrappers.mailPage.MailPageActions;
import pageWrappers.yandex_com.pageWrappers.mainPage.MainPageActions;
import utility.dataManager.DataManager;

import java.util.Properties;

public class MainTest extends BaseTest {

	@Test(description = "Main test")
	public void mainTest() {
		// Preconditions
		// Get test data from properties:
		Properties propertyForTest = DataManager.getPropertyForTest();
		String fileName = propertyForTest.getProperty("Maintest.filePath").replace("/home/user/StudyAutomationFramework/", "");
		UiDriverActions.goToUrl(propertyForTest.getProperty("Maintest.url"));

		// Test
		// Main Page
		MainPageActions.clickLoginDesk();

		// Login Page
		LoginPageActions.loginWithCreds
				(propertyForTest.getProperty("Maintest.userLogin"), propertyForTest.getProperty("Maintest.password"));

		// Mail Page
		MailPageActions.sendNewMessageWithParams(
				propertyForTest.getProperty("Maintest.getterEmail"),
				propertyForTest.getProperty("Maintest.subject"),
				propertyForTest.getProperty("Maintest.text"),
				propertyForTest.getProperty("Maintest.filePath"), fileName);
		MailPageActions.checkMessageWithSubjectReceivedInInboxMail(propertyForTest.getProperty("Maintest.subject"));
		MailPageActions.moveAttachmentFromMailToDisk(fileName);
		MailPageActions.checkMessageOnFrameSavedOnDisk();

		// Disk Page
		DiskPageActions.moveItemToFilesFolder(fileName);
		DiskPageActions.moveItemToBasket(fileName);
		DiskPageActions.checkItemInBasket(fileName);
	}
}
