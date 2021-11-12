package common.main.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UiDriver {
	private static final ThreadLocal<UiDriver> instance = new ThreadLocal<>();
	private final WebDriver driver;

	private UiDriver() {
//		WebDriverManager.chromedriver().setup();
//		this.driver = new ChromeDriver();

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
		}
		return instance.get().driver;
	}

	public static void closeDriver() {
		getDriver().quit();
		instance.set(null);
	}

}
