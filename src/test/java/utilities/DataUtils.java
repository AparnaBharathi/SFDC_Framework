package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class DataUtils {

	public static String readAccounts(String key) throws IOException {
		
		Properties p=new Properties();
		FileReader prop=new FileReader(FileConstants.PROD_ACCOUNTS_FILE_PATH);
		p.load(prop);
		String value=p.getProperty(key);
		return value;
	}
	
public static String readExpectedError(String key) throws IOException {
		
		Properties p=new Properties();
		FileReader prop=new FileReader(FileConstants.ERROR_MESSAGES_FILE_PATH);
		p.load(prop);
		String value=p.getProperty(key);
		return value;
	}
}
