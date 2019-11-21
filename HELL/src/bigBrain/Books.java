package bigBrain;

import java.util.ArrayList;

public class Books {
	String bookName;
	String author;
	String borrower;
	int month;
	int day;
	int year;
	boolean loaned = false;
	boolean overdue = false;
	ArrayList<Books> books;
	
	public Books(String bn, String a, int m, int d, int y, ArrayList<Books> c) {
		bookName = bn;
		author = a;
		month = m;
		day = d;
		year = y;
		books = c;
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
	public String getBorrower() {
		return borrower;
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
