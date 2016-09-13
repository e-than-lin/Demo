package e.z;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertyHelper {
	public static Properties properties;
	/**getProperties*/
	public static String getProperties() {
		try {
			Properties prop = new Properties();// ���Լ��϶���
			InputStream  fis = PropertyHelper.class.getResourceAsStream("/prop.properties");
			prop.load(fis);
			properties=prop;
			fis.close();// �ر���
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String setProperties(Map<String, String> map) {
		try {
			Properties prop = new Properties();// ���Լ��϶���
			FileOutputStream fos = new FileOutputStream("prop.properties");
			Iterator<String> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				prop.setProperty(key, map.get(key));
			}
			// ��Properties���ϱ��浽����
			prop.store(fos, "");
			fos.close();// �ر���
			return null;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
