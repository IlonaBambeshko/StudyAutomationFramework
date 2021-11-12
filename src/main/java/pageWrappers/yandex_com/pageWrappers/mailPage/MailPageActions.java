package pageWrappers.yandex_com.pageWrappers.mailPage;

import common.main.javascriptExecutor.CustomJavascriptExecutor;
import common.main.waiter.Waiter;
import io.qameta.allure.Step;
import org.testng.Assert;
import pageWrappers.yandex_com.BasePageActions;

import static pageWrappers.yandex_com.pageWrappers.mailPage.MailPage.getPopupTitle;

public class MailPageActions extends BasePageActions {

	@Step("Create new message with attachment {3} and send to {0}")
	public static void sendNewMessageWithAttachment(String getterEmail, String subject, String text, String attachmentPath) {
		clickMailButton();
		fillAllFieldsForNewLetter(getterEmail, subject, text, attachmentPath);
		clickSendButton();
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

	@Step("Fill necessary fields for the message")
	public static void fillAllFieldsForNewLetter(String getterEmail, String subject, String text, String attachmentPath) {
		Waiter.waitUntilVisible(MailPage.getToField(), "Send button is not displayed");
		Assert.assertEquals(getPopupTitle().getElement().getText(), "Новое письмо");
		MailPage.getToField().sendKeys(getterEmail);
		MailPage.getSubjectField().sendKeys(subject);
		MailPage.getTextBox().sendKeys(text);
		MailPage.getInputFile().sendKeys(attachmentPath);
		Waiter.waitUntilVisible(MailPage.getAttachmentField(), "Attachment field is not displayed");
		Assert.assertEquals(MailPage.getAttachmentField().getElement().getText().contains("fiile_to_attach"), true);
	}

	@Step("Check new message in inbox mail")
	public static void checkMessageInInboxMail() {
		Waiter.waitLongUntilVisible(MailPage.getCheckMailboxButton(), "Check mailbox button is not displayed");
		do {
			MailPage.getCheckMailboxButton().click();
			Waiter.waitWithDurationOfMilliseconds(4000);
		} while (!MailPage.getFirstInboxMessage().isDisplayed());
	}

	@Step("Move attachment from mail to disk")
	public static void moveAttachmentFromMailToDisk() {
		MailPage.getFirstInboxMessage().click();
		Waiter.waitLongUntilVisible(MailPage.getAttachmentField(), "Attachment field is not displayed");
		CustomJavascriptExecutor.executeClick(MailPage.getSaveOnDiskButton().getElement());
		Waiter.waitWithDurationOfMilliseconds(4000);
	}

	@Step("Check that File is saved on Disk")
	public static void checkFileIsSavedOnDisk() {
		Waiter.waitLongUntilVisible(MailPage.getLoadedOnDiskIFrame(), "File is not saved on Disk");
	}

	@Step("Click 'go to Disk' button")
	public static void moveToDisk() {
		Waiter.waitLongUntilVisible(MailPage.getGoToDiskButton(), "Button to go to Disk is not displayed");
		MailPage.getGoToDiskButton().click();
	}
}
