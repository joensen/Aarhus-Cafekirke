package newsletter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class Menu {
	
	private List<SelectItem> langItemsEn;
	private List<SelectItem> langItemsDa;
	
	public Menu() {
		langItemsEn = new ArrayList<SelectItem>();
		langItemsDa = new ArrayList<SelectItem>();
		langItemsEn.add(new SelectItem("en", "English"));
		langItemsEn.add(new SelectItem("da", "Danish"));
		langItemsDa.add(new SelectItem("da", "Dansk"));
		langItemsDa.add(new SelectItem("en", "Engelsk"));
	}
	
	public List<SelectItem> getLangItems() {
		String lang = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
		if (lang.equals("en"))
			return langItemsEn;
		return langItemsDa;
	}

}
