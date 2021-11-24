package common.main.elements;

import common.main.driver.UiDriver;
import org.openqa.selenium.*;

import java.util.List;

public class HtmlElement implements WebElement {
	protected By locator;

	public HtmlElement(By locator) {
		this.locator = locator;
	}

	public WebElement getElement() {
		int attempts = 15;
		while (attempts > 0) {
			try {
				return UiDriver.getDriver().findElement(locator);
			} catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
				attempts -= 1;
			}
		}
		return null;
	}

	public By getLocator() {
		return locator;
	}

	public void click() {
		int attempts = 10;
		while (attempts > 0) {
			try {
				getElement().click();
				return;
			} catch (NullPointerException | WebDriverException e) {
				attempts -= 1;
			}
		}
	}

	@Override
	public void submit() {

	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {

	}

	@Override
	public void clear() {

	}

	@Override
	public String getTagName() {
		return null;
	}

	@Override
	public String getAttribute(String name) {
		return null;
	}

	@Override
	public boolean isSelected() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public List<WebElement> findElements(By by) {
		return null;
	}

	@Override
	public WebElement findElement(By by) {
		return null;
	}

	public boolean isDisplayed() {
		try {
			return UiDriver.getDriver().findElement(locator)
					.isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Point getLocation() {
		return null;
	}

	@Override
	public Dimension getSize() {
		return null;
	}

	@Override
	public Rectangle getRect() {
		return null;
	}

	@Override
	public String getCssValue(String propertyName) {
		return null;
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
		return null;
	}
}
