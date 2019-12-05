package library;

public class Books {
	private String title;
	private String author;
	private String borrower;
	private int month;
	private int day;
	private int year;
	private boolean loaned = true;
	private boolean overdue = false;

	private Date checkOutDate;

	public Books(String t, String a) {
		title = t;
		author = a;
		borrower = null;
		checkOutDate = new Date();
	}

	public void setLoaned() {
		loaned = !loaned;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getBorrower() {
		return borrower;
	}

	public int getDay() {
		return checkOutDate.getDay();
	}

	public int getMonth() {
		return checkOutDate.getMonth();
	}

	public int getYear() {
		return checkOutDate.getYear();
	}

	public boolean getLoaned() {
		return loaned;
	}

	public boolean getOverdue() {
		return overdue;
	}

	public void setDate(Date d) {
		checkOutDate = d;
	}

	public void setBorrower(String nm) {
		borrower = nm;
	}

	public long getTimeInMili() {
		return checkOutDate.setTimeMili();
	}

	public void setDay(int d) {
		checkOutDate.setDay(d);
	}

	public void setMonth(int m) {
		checkOutDate.setMonth(m);
	}

	public void setYear(int y) {
		checkOutDate.setYear(y);
	}

	public String toStringBorrowed() {
		String str = ("Title: " + title + " \nAuthor:" + author + " \nAvailability: Not Available" + " \nBorrowed By: "
				+ borrower + " \nBorrowed on: " + checkOutDate.getMonth() + "/" + checkOutDate.getDay() + "/" + checkOutDate.getYear() + "\nStatus: " + overdue);
		return str;
	}

	public String toStringAvail() {
		String str = ("Title: " + title + " \nAuthor:" + author + " \nAvailability : Available");
		return str;
	}
}
