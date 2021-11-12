package common.main.elements;

import org.openqa.selenium.By;

public class Input extends HtmlElement {
	public Input(By locator) {
		super(locator);
	}

	public void sendKeys(String text) {
		getElement().clear();
		getElement().sendKeys(text);
	}
}