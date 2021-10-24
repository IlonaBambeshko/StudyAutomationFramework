package com.stormnet.tests.functionalities;

import com.stormnet.tests.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExampleTest extends AbstractTest {

	@Test(testName = "First test")
	public void testBanana() {
		driver.get("https://www.google.com/");
		new WebDriverWait(driver, Duration.ofSeconds(4))
				.withMessage("No search results")
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
		WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
		searchField.sendKeys("banana");
		searchField.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, Duration.ofSeconds(4))
				.withMessage("No search results")
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='yuRUbf']/a[@href='https://bananarepublic.gap.com/']")));
		WebElement searchField2 = driver.findElement(By.xpath("//div[@class='yuRUbf']/a[@href='https://bananarepublic.gap.com/']"));
		searchField2.click();
		String windowTitle = driver.getTitle();
		Assert.assertEquals(windowTitle, "Shop Banana Republic for Contemporary Clothing for Women & Men", "Unexpected window title");
	}
}
