package utility.dataManager;

import io.qameta.allure.Step;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.UUID.randomUUID;

public class DataManager {
	public static void main(String[] args) {
		String str = "/home/user/StudyAutomationFramework/1452e.txt";
		System.out.println(str.replace("/home/user/StudyAutomationFramework/", ""));
	}


	@Step("Generate file with random name and get its absolute path")
	public static String generateFile() {
		File file = new File(generateFileName().concat(".txt"));
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}

	@Step("Get property with test data")
	public static Properties getPropertyForTest() {
		try {
			return ReadDataFromPropertiesFile.createNewPropertyForTest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generateFileName() {
		return randomUUID().toString().replaceAll("-", "").substring(0, 5);
	}

	static class ReadDataFromPropertiesFile {
		public static Properties createNewPropertyForTest() throws Exception {
			FileInputStream fis = new FileInputStream("/home/user/StudyAutomationFramework/config.properties");
			Properties prop = new Properties();
			prop.load(fis);
			prop.setProperty("Maintest.filePath", generateFile());
			return prop;
		}

	}
}