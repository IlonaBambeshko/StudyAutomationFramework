package pageWrappers.yandex_com.pageWrappers.mailPage;

import common.main.elements.Button;
import common.main.elements.HtmlElement;
import common.main.elements.Input;
import org.openqa.selenium.By;
import pageWrappers.yandex_com.BasePage;

public class MailPage extends BasePage {
	private static final By INBOX_MAIL_LOCATOR = By.xpath("//div[@class='mail-Layout-Inner']//a[@href='#inbox']");
	private static final By MAIL_BUTTON_LOCATOR = By.cssSelector("a.mail-ComposeButton.js-main-action-compose");
	private static final By POPUP_TITLE_LOCATOR = By.xpath("//div[@class='ComposePopup-Head']//span[@class='composeHeader-Title']/span");
	private static final By TO_FIELD_LOCATOR = By.xpath("//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField ComposeRecipients-ToField tst-field-to']//div[@class='composeYabbles']");
	private static final By SUBJECT_FIELD_LOCATOR = By.xpath("//input[@name='subject']");
	private static final By TEXTBOX_LOCATOR = By.xpath("//div[@role='textbox']");
	private static final By INPUT_FILE_LOCATOR = By.xpath("//input[@type='file']");
	private static final By SEND_BUTTON_LOCATOR = By.xpath("//div[@class='ComposeSendButton-Text']/../../../button");
	private static final By ATTACHMENT_FIELD_LOCATOR = By.xpath("//div[@class='AttachmentItem__text--24wwt qa-Attachment-fileName']/span");
	private static final By CHECK_MAILBOX_BUTTON_LOCATOR = By.xpath("//span[@data-click-action='mailbox.check']");
	private static final By I_FRAME_LOCATOR = By.xpath("(//iframe)[3]");
	private static final By NON_VISIBLE_ATTACHMENT_AREA = By.xpath("//div[@class='AttachmentItem__attachmentItem--P5Tr2']");

//	add variable to 'ilona_bambeshko@tut.by'
	private static final By INBOX_MESSAGE_LOCATOR = By.xpath("//div[1][contains(@class, 'ns-view-messages-item-wrap')]//div[@class='mail-MessageSnippet-Content']//span[@title='ilona_bambeshko@tut.by']");
	private static final By SAVE_ON_DISK_BUTTON_LOCATOR = By.xpath("//button[contains(@class, 'qa-MessageViewer-Attachment-SaveDiskBtn')]");
	private static final By LOADED_ON_DICK_IFRAME_LOCATOR = By.xpath("//span/span/span[contains(., 'Сохранено на Диск')]");
	private static final By GO_TO_DISK_BUTTON_LOCATOR = By.xpath("//a//span[@class='button__text']");


	public static HtmlElement getAttachmentField() {
		return new HtmlElement(ATTACHMENT_FIELD_LOCATOR);
	}

	public static HtmlElement getInboxMail() {
		return new HtmlElement(INBOX_MAIL_LOCATOR);
	}

	public static HtmlElement getNonVisibleAttachmentArea() {
		return new HtmlElement(NON_VISIBLE_ATTACHMENT_AREA);
	}

	public static HtmlElement getLoadedOnDiskIFrame() {
		return new HtmlElement(LOADED_ON_DICK_IFRAME_LOCATOR);
	}

	public static HtmlElement getIFrame() {
		return new HtmlElement(I_FRAME_LOCATOR);
	}

	public static HtmlElement getFirstInboxMessage() {
		return new HtmlElement(INBOX_MESSAGE_LOCATOR);
	}

	public static Button getMailButton(){ return new Button(MAIL_BUTTON_LOCATOR); }

	public static Button getSendButton(){ return new Button(SEND_BUTTON_LOCATOR); }

	public static Button getGoToDiskButton(){ return new Button(GO_TO_DISK_BUTTON_LOCATOR); }

	public static Button getSaveOnDiskButton(){ return new Button(SAVE_ON_DISK_BUTTON_LOCATOR); }

	public static Button getCheckMailboxButton(){ return new Button(CHECK_MAILBOX_BUTTON_LOCATOR); }

	public static HtmlElement getPopupTitle() { return new HtmlElement(POPUP_TITLE_LOCATOR); }

	public static Input getToField() { return new Input(TO_FIELD_LOCATOR); }

	public static Input getSubjectField() { return new Input(SUBJECT_FIELD_LOCATOR); }

	public static Input getTextBox() { return new Input(TEXTBOX_LOCATOR); }

	public static Input getInputFile() { return new Input(INPUT_FILE_LOCATOR); }
}
