package newsletter;

import java.io.Serializable;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

public class Form implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String locale;
	private String message;
	private String style;
	
	public Form() {
		
		locale = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.trim();
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String clearMessage() {
		message = "";
		return "";
	}
	
	public String getStyle() {
		return style;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	
	private boolean tjekEmail() {
		System.out.println(email.length());
		if (email.length() == 0) {
			if (locale.equals("en"))
				message = "Field is empty";
			else
				message = "Feltet er tomt";
			return false;
		}
		if (!Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE).matcher(email).matches()) {
			if (locale.equals("en"))
				message = "Not a valid email";
			else
				message = "Ugyldig email";
			return false;
		}
		return true;
	}
	
	private String send(boolean sub) {
		boolean smtp = true;
		String emailURL = "";
		if (sub)
			emailURL = "news-subscribe@aarhuscafekirke.dk";
		else
			emailURL = "news-unsubscribe@aarhuscafekirke.dk";
		
		if (tjekEmail() && (smtp = new Mail(email, emailURL, "", "").send())) {
			if (sub) {
				if (locale.equals("en"))
					message = "Subsciption sent";
				else
					message = "Tilmelding afsendt";	
			} else {
				if (locale.equals("en"))
					message = "Successfully unsubscribed";
				else
					message = "Afmeldning udf&#248;rt";
			}
			style = "success";
		} else {
			style = "errors";
			if (!smtp) {
				if (locale.equals("en"))
					message = "An error has occurred!<br /> Please contact: admin@aarhuscafekirke.dk";
				else
					message = "Der er sket en fejl!<br /> Underret venligst: admin@aarhuscafekirke.dk";
			}
		}
		return "";
	}

	public String sub() {
		return send(true);
	}
	
	public String unsub() {
		return send(false);
	}
}
