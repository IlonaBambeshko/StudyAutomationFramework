package common.main.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.logerator.Logger;

public class UiDriver {
	private static final ThreadLocal<UiDriver> instance = new ThreadLocal<>();
	private final WebDriver driver;

	private UiDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--disable-gpu");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("--disable-infobars");
		chromeOptions.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(chromeOptions);
		this.driver = driver;
	}

	public static WebDriver getDriver() {
		if (instance.get() == null) {
			instance.set(new UiDriver());
			Logger.getLogger().debug("Started new Driver");
		}
		return instance.get().driver;
	}

	public static void closeDriver() {
		Logger.getLogger().debug("Close driver {}", UiDriver.getDriver());
		getDriver().quit();
		instance.set(null);
	}

}
