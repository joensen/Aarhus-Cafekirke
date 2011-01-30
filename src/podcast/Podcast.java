package podcast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class Podcast {

	private List<Item> items;
	public static final int no = 5;

	public Podcast() {
		items = new ArrayList<Item>();
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public List<Item> getAllItems() {
		return items;
	}
	
	public Item[] getItems() {
		Item[] items_sub = new Item[no];
		if (items.size() > 0) {
			Collections.sort(items);
			for (int i = 0; i < no; i++) {
				items_sub[i] = items.get(i);
			}
		}
		return items_sub;
	}
	

	public int sortDate(Object o, Object p) {
		if (((PubDate) p).getYear() == ((PubDate) o).getYear()) {
			if (((PubDate) p).getMonth() == ((PubDate) o).getMonth()) {
				return ((PubDate) p).getDay() - ((PubDate) o).getDay();
			} else {
				return ((PubDate) p).getMonth() - ((PubDate) o).getMonth();
			}
		} else {
			return ((PubDate) p).getYear() - ((PubDate) o).getYear();
		}
	}
	
	public int sortDuration(Object o, Object p) {
		int min1 = Integer.parseInt(((String) o).substring(0, ((String) o).indexOf(':')));
		int min2 = Integer.parseInt(((String) p).substring(0, ((String) p).indexOf(':')));
		int sec1 = Integer.parseInt(((String) o).substring(((String) o).indexOf(':') + 1));
		int sec2 = Integer.parseInt(((String) p).substring(((String) p).indexOf(':') + 1));
		
		if (min1 == min2)
			return sec1 - sec2;
		return min1 - min2;
	}
	
	public int sortSize(Object o, Object p) {
		int size1 = (Integer) o;
		int size2 = (Integer) p;
		return size1 - size2;
	}

	public String createItems() {
		items.clear();
		URL url;
		try {
			url = new URL("http://www.aarhuscafekirke.dk/podcast/rss.xml");
			URLConnection connect = url.openConnection();
			InputStream in = connect.getInputStream();
			XMLInputFactory factoryin = XMLInputFactory.newInstance();
			XMLStreamReader reader = factoryin.createXMLStreamReader(in);

			int eventCode;
			boolean inItem = false;
			Item item = new Item();

			while (reader.hasNext()) {
				eventCode = reader.next();
				if (eventCode == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals("item")) {
					inItem = true;
					item = new Item();
				} else if (inItem && eventCode == XMLStreamConstants.START_ELEMENT) {
					String element = reader.getLocalName();
					if (element.equals("title")) {
						item.setTitle(reader.getElementText());
					}
					else if (element.equals("pubDate")) {
						item.setDate(new PubDate(reader.getElementText()));
					} 
					else if (element.equals("guid")) {
						item.setGuid(reader.getElementText());
					} 
					else if (element.equals("enclosure")) {
						item.setPodcastUrl(reader.getAttributeValue(0));
						item.setLength(reader.getAttributeValue(1));
					} 
					else if (element.equals("duration")) {
						item.setDuration(reader.getElementText());
					} 
					else if (element.equals("author")) {
						item.setAuthor(reader.getElementText());
					}
					else if (element.equals("language")) {
						item.setLang(reader.getElementText());
					}
				} else if (inItem && eventCode == XMLStreamConstants.END_ELEMENT && reader.getLocalName().equals("item")) {
					inItem = false;
					items.add(item);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return "";
	}
}
