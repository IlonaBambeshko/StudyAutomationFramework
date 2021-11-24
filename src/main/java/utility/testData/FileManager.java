package utility.testData;

import io.qameta.allure.Step;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static java.util.UUID.randomUUID;

public class FileManager {
	@Step("Generate file with random name and get its absolute path")
	public static File generateFile() {
		File file = new File(generateFileName().concat(".txt"));
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public static String generateFileName() {
		return randomUUID().toString().replaceAll("-", "").substring(0, 5);
	}
}
