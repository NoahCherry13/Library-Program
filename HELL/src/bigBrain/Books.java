package bigBrain;

public class Books {
	private String bookName;
	private String author;
	private String borrower;
	private int month;
	private int day;
	private int year;
	private boolean loaned = false;
	private boolean overdue = false;
	
	private Date d;
	
	public Books(String bn, String a) {
		bookName = bn;
		author = a;
		borrower = null;
		d = new Date();
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
