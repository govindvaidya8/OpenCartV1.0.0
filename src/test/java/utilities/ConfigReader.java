package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties property = new Properties();
	static {
		try {

			property.load(ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String value = property.getProperty(key);
		return value;

	}
}
