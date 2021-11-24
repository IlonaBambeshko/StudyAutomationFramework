package utility.testData;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import utility.testData.entities.User;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

public class UserManager {
	private static ArrayList<User> getUserListFromJSON() {
		String jsonString = "src/test/resources/users.json";
		String userInfoJson= null;
		try {
			userInfoJson = new String(Files.readAllBytes(Paths.get(jsonString)));
			Type listOfMyClassObject = new TypeToken<ArrayList<User>>() {}.getType();
			Gson gson = new Gson();
			return gson.fromJson(userInfoJson, listOfMyClassObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	// TODO: 24.11.21 simple json from maven 

	public static User getUserByIdFromList(String id){
		Optional<User> user = getUserListFromJSON().stream().filter(p -> p.getId().equals(id)).findFirst();
		return user.get();
	}
}
