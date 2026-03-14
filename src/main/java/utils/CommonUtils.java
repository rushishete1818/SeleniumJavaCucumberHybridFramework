package utils;

import java.util.Date;

public class CommonUtils {
	
	public static String timeStamp() {
		
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
		
	}

}
