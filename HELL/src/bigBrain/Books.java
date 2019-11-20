package bigBrain;

public class Books {
	String bookName;
	String author;
	int month;
	int day;
	int year;
	boolean loaned = false;
	boolean overdue = false;
	
	public Books(String bn, String a, int m, int d, int y) {
		bookName = bn;
		author = a;
		month = m;
		day = d;
		year = y;
	}
	public void setLoaned() {
		loaned = !loaned;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthor() {
		return author;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public boolean getLoaned() {
		return loaned;
	}
	public boolean getOverdue() {
		return overdue;
	}
	
}
