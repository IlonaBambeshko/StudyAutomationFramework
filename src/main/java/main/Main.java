package main;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Main {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

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
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		screenshot.renameTo(new File("screenshotBanana.jpg"));
		driver.close();
	}
}

