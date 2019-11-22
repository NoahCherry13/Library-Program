package bigBrain;

import java.util.Calendar;

public class Date {
	int month;
	int day;
	int year;
	long mili;
	
	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}
	
	public Date() {
		Calendar cal = Calendar.getInstance();
		day = cal.get(Calendar.DATE);
		month = cal.get(Calendar.MONTH) + 1;
		year = cal.get(Calendar.YEAR);
	}
	
	public long getTime() {
		
	}
}
