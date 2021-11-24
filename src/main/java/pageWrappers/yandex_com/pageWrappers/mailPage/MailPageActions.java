package pageWrappers.yandex_com.pageWrappers.mailPage;

import common.main.driver.UiDriverActions;
import common.main.driver.CustomJavascriptExecutor;
import common.main.driver.Waiter;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageWrappers.yandex_com.BasePageActions;

import java.util.Set;

//import static pageWrappers.yandex_com.pageWrappers.mailPage.MailPage.getPopupTitle;

public class MailPageActions extends BasePageActions {

	@Step("Create new message with attachment {4} and send to {0}")
	public static void sendNewMessageWithParams(String getterEmail, String subject, String text, String attachmentPath, String fileName) {
		clickMailButton();
		fillAllFieldsForNewLetter(getterEmail, subject, text, attachmentPath, fileName);
		clickSendButton();
		checkAttachmentIsLoaded();
		Waiter.waitLongUntilVisible(MailPage.getMessageSentNotification(), "Message about successful sending is not displayed");
		Waiter.waitUntilVisible(MailPage.getInboxMail(), "Inbox mail is not displayed");
	}

	public static void clickMailButton() {
		Waiter.waitUntilVisible(MailPage.getMailButton(), "Mail button is not displayed");
		MailPage.getMailButton().click();
	}

	public static void clickSendButton() {
		Waiter.waitUntilVisible(MailPage.getSendButton(), "Send button is not displayed");
		MailPage.getSendButton().click();
	}

	@Step("Check if attachment is already loaded")
	public static void checkAttachmentIsLoaded(){
		int attempts = 7;
		while (MailPage.getModalWindowWithText("Письмо не отправлено").isDisplayed() && attempts > 0) {
			Waiter.waitUntilVisible(MailPage.getButtonWithName("Вернуться к письму"),
					"Button Вернуться к письму is not displayed");
			MailPage.getButtonWithName("Вернуться к письму").click();
			clickSendButton();
			attempts -= 1;
		}
	}

	@Step("Check new message in inbox mail")
	public static void checkMessageWithSubjectReceivedInInboxMail(String subject) {
		Waiter.waitLongUntilVisible(MailPage.getCheckMailboxButton(), "Check mailbox button is not displayed");
		int attempts = 5;
		boolean messageNotDisplayed = true;
		do {
			MailPage.getCheckMailboxButton().click();
			Waiter.waitLongUntilVisible(MailPage.getCheckMailboxButton(), "Check mailbox button is not displayed");
			attempts -= 1;
			if (MailPage.getFirstInboxMessageWithSubject(subject).isDisplayed()) {
				messageNotDisplayed = false;
			}
		} while (messageNotDisplayed && (attempts > 0));
	}

	@Step("Fill necessary fields for the message")
	public static void fillAllFieldsForNewLetter(String getterEmail, String subject, String text, String attachmentPath, String fileNameWithExtension) {
		Waiter.waitUntilVisible(MailPage.getToField(), "Send button is not displayed");
		Assert.assertEquals(MailPage.getPopupTitle().getElement().getText(), "Новое письмо");
		MailPage.getToField().sendKeys(getterEmail);
		MailPage.getSubjectField().sendKeys(subject);
		MailPage.getTextBox().sendKeys(text);
		MailPage.getInputFile().sendKeys(attachmentPath);
		Waiter.waitUntilVisible(MailPage.getAttachmentField(), "Attachment field is not displayed");
		String fileName = fileNameWithExtension.replace(".txt", "");
		Assert.assertTrue(MailPage.getAttachmentField().getElement().getText().contains(fileName),
				"Attachment name doesn't contain text " + fileName);
	}

	@Step("Move attachment from mail to disk")
	public static void moveAttachmentFromMailToDisk(String subject, String fileNameWithExtension) {
		MailPage.getFirstInboxMessageWithSubject(subject).click();
		Waiter.waitLongUntilVisible(MailPage.getAttachmentField(), "Attachment field is not displayed");
		String fileName = fileNameWithExtension.replace(".txt", "");
		Assert.assertTrue(MailPage.getAttachmentField().getElement().getText().contains(fileName),
				"Attachment name doesn't contain text " + fileName);
		CustomJavascriptExecutor.executeClick(MailPage.getSaveOnDiskButton().getElement());
	}

	@Step("Check that File is saved on Disk")
	public static void checkMessageOnFrameSavedOnDisk() {
		Waiter.waitFrameToBeAvailableAndSwitch(MailPage.getFrame(), "Frame is not available");
		Waiter.waitLongUntilVisible(MailPage.getLoadedOnDiskIFrame(), "File is not saved on Disk");
		Set<String> currentTabs = UiDriverActions.getCurrentTabs();
		MailPageActions.goToDisk();
		UiDriverActions.switchToTheNextTab(currentTabs);
	}

	@Step("Click 'Go to Disk' button")
	public static void goToDisk() {
		Waiter.waitLongUntilVisible(MailPage.getGoToDiskButton(), "Button 'Go to Disk' is not displayed");
		MailPage.getGoToDiskButton().click();
	}
}
