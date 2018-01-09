package main.java.com.rockey.ssm.util;

import java.io.FileReader;
import java.util.Properties;

public class BasicUtil {

	private static Properties prop;

	private BasicUtil() {

	}

	static {
		// get and resolve properties file
		prop = new Properties();
		try {
			prop.load(new FileReader(BasicUtil.class.getClassLoader()
					.getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static int getRowPage() {

		return Integer.parseInt(prop.getProperty("RowPage"));
	}
}
