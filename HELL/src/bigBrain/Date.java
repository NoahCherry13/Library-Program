package bigBrain;

import java.util.Calendar;
import java.util.TimeZone;

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
		cal = simplifyTime(cal);
	}

	public long getTime() {
		return setTimeMili();
	}

	public void setYear(int y) {
		year = y;
	}

	public void setMonth(int m) {
		month = m;
	}

	public void setDay(int d) {
		day = d;
	}

	private Calendar simplifyTime(Calendar c) {
		c.setTimeZone(TimeZone.getTimeZone("EST"));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c;
	}

	public long setTimeMili() {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		cal = simplifyTime(cal);
		mili = cal.getTimeInMillis();
		return mili;
	}

	public int daysInMonth(int m, int y) {
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month==2 && y % 100 == 0 && y % 4 != 0)
			return 28;
		else if (m==2 && y % 4 == 0)
			return 29;
		else return daysInMonth[m-1];
	}
	
	public void checkValid () throws IllegalDate {
		if (day > daysInMonth (month, year)|| day<=0) {
			throw new IllegalDate("Invalid Day");
		}
		if (month <=0 || month >12) {
			throw new IllegalDate("Invalid Month");
		}
		// Add BC
		if (year < 0) throw new IllegalDate("Invalid year");
	}
}