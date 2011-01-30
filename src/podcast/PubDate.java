package podcast;

import javax.faces.context.FacesContext;

public class PubDate implements Comparable<PubDate>{

	// <pubDate>Sat, 05 Sep 2009 15:00:00 +0100</pubDate>
	//          0123456789012345678901234567890
	private String weekday;
	private int day;
	private int month;
	private int year;
	private int hour;
	private int minute;
	private int second;
	private String[] month_en = {"January", "February", "March", "April", "May", "June", "Juli", "August", "September", "October", "November", "December"};
	private String[] month_da = {"januar", "februar", "marts", "april", "maj", "juni", "juli", "august", "september", "oktober", "november", "december"};
	
	public PubDate(String pubDate) {
		weekday = pubDate.substring(0, 3);
		day = Integer.parseInt(pubDate.substring(5, 7));
		year = Integer.parseInt(pubDate.substring(12, 16));
		hour = Integer.parseInt(pubDate.substring(17, 19));
		minute = Integer.parseInt(pubDate.substring(20, 22));
		second = Integer.parseInt(pubDate.substring(23, 25));
		String tmpMonth = pubDate.substring(8, 11);
		if (tmpMonth.equals("Jan")) month = 1;
		if (tmpMonth.equals("Feb")) month = 2;
		if (tmpMonth.equals("Mar")) month = 3;
		if (tmpMonth.equals("Apr")) month = 4;
		if (tmpMonth.equals("May")) month = 5;
		if (tmpMonth.equals("Jun")) month = 6;
		if (tmpMonth.equals("Jul")) month = 7;
		if (tmpMonth.equals("Aug")) month = 8;
		if (tmpMonth.equals("Sep")) month = 9;
		if (tmpMonth.equals("Oct")) month = 10;
		if (tmpMonth.equals("Nov")) month = 11;
		if (tmpMonth.equals("Dec")) month = 12;
	}

	public String getWeekday() {
		return weekday;
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

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public String toString() {
		return "PubDate [day=" + day + ", hour=" + hour + ", minute=" + minute + ", month=" + month + ", second=" + second + ", weekday=" + weekday + ", year=" + year + "]";
	}
	
	public String getDate() {
		if (FacesContext.getCurrentInstance().getViewRoot().getLocale().toString().equals("en")) {
			String post = "th";
			switch(day) {
			case 1:
			case 11:
			case 21:
			case 31:
				post ="st";
				break;
			case 2:
			case 12:
			case 22:
				post ="nd";
				break;
			case 3:
			case 13:
			case 23:
				post ="rd";
				break;
			}
			return day + post + " " + month_en[month - 1] + " " + year;
		} else {
			return day + ". " + month_da[month - 1] + " " + year;
		}
	}

	@Override
	public int compareTo(PubDate o) {
		if (year == o.getYear()) {
			if (month == o.getMonth()) {
				return day - o.getDay();
			} else {
				return month - o.getMonth();
			}
		} else {
			return year - o.getYear();
		}
	}
	
}
