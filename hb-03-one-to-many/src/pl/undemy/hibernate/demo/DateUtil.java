package pl.undemy.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
	
	
	public static Date parseDate(String dateStr) throws ParseException {
		return formatter.parse(dateStr);
	}
	
	
	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		
		return formatter.format(date);
	}
}
