package podcast;


public class Item implements Comparable<Item> {

	private String title;
	private PubDate date;
	private int guid;
	private String podcastUrl;
	private long length;
	private String duration;
	private String author;
	private String lang;

	public Item() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PubDate getDate() {
		return date;
	}

	public void setDate(PubDate date) {
		this.date = date;
	}

	public int getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = Integer.parseInt(guid);
	}

	public String getPodcastUrl() {
		return podcastUrl;
	}

	public void setPodcastUrl(String podcastUrl) {
		this.podcastUrl = podcastUrl;
	}

	public long getLength() {
		return length;
	}
	
	public int getMB() {
		return (int) Math.round(length / 1024.0 / 1024.0);
	}

	public void setLength(String length) {
		this.length = Long.parseLong(length);
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Item [author=" + author + ", date=" + date + ", duration=" + duration + ", guid=" + guid + ", length=" + length + ", podcastUrl=" + podcastUrl + ", title=" + title + "]";
	}

	@Override
	public int compareTo(Item o) {
		return o.getGuid() - guid;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getLang() {
		return lang;
	}
	
	

}
