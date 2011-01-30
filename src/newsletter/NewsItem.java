package newsletter;

public class NewsItem {
	
	private int year;
	private int week;
	
	public NewsItem(int year, int week) {
		super();
		this.year = year;
		this.week = week;
	}

	public int getWeek() {
		return week;
	}
	
	public void setWeek(int week) {
		this.week = week;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	public String getUrl() {
		return "news/news_" + year + "_" + week + ".html";
	}

}
