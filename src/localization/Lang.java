package localization;


public class Lang {
	
	private String locale;
	
	public void setLocale(String locale) {
		this.locale = locale;
		locale = "";
	}
	
	public String getLocale() {
		return locale;
	}
	
	public String danish() {
		locale = "da";
		return "reset";
	}
	
	public String english() {
		locale = "en";
		return "reset";
	}

}
