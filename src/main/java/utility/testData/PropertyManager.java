package utility.testData;

import io.qameta.allure.Step;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyManager {
	@Step("Get property with test data")
	public static Properties getPropertyForTest() {
		try {
			return createNewPropertyForTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Properties createNewPropertyForTest() throws Exception {
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
//		File file = generateFile();
//		prop.setProperty("C12345.filePath", file.getCanonicalPath());
//		prop.setProperty("C12345.fileNameWithExtension", file.getName());
		return prop;
	}
}
