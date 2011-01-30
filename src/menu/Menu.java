package menu;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


public class Menu {
	
	private boolean renderKalender;
	
	public Menu() {
		renderKalender = false;
	}

	public void showKalender(ActionEvent e) {
		renderKalender = true;
	}
	
	public boolean isRenderKalender() {
		return renderKalender;
	}
	
	public void setRenderKalender(boolean renderKalender) {
		this.renderKalender = renderKalender;
	}
	
	public String getKalender() {
		if (renderKalender) {
			if (FacesContext.getCurrentInstance().getViewRoot().getLocale().toString().equals("en"))
				return "<iframe src=\"http://bit.ly/9sQ0Of\" width=\"600\" height=\"400\" frameborder=\"0\" scrolling=\"no\" />";
			else
				return "<iframe src=\"http://bit.ly/bAIaiZ\" width=\"600\" height=\"400\" frameborder=\"0\" scrolling=\"no\" />";
		} else {
			return "";
		}
	}
	
}
