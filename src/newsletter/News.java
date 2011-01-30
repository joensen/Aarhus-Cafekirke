package newsletter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class News {

	
	private int week;
	private int year;
	
	public News() {
		Calendar c = GregorianCalendar.getInstance();
		week = c.get(Calendar.WEEK_OF_YEAR);
		year = c.get(Calendar.YEAR);
	}
	
	public NewsItem getLatest() throws MalformedURLException, IOException {
		
		NewsItem news = new NewsItem(year, week);
		
		int uge = week;
		int aar = year;
		
		while (!new URL("http://www.aarhuscafekirke.dk/" + news.getUrl()).openConnection().getHeaderField(0).contains("200")) {
			uge--;
			if (uge <=0) {
				aar--;
				news.setYear(aar);
				uge = new GregorianCalendar(aar, 11, 31).get(Calendar.WEEK_OF_YEAR);
			}
				
			news.setWeek(uge);
		}
		
		return news;
	}

}
