package flightsearch.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class ApplicationUI extends UI {

	private static final long serialVersionUID = 1L;

	private static final String APPLICATION_NAME = "Flight Search Application";

	@Override
	protected void init(VaadinRequest request) {
		Page.getCurrent().setTitle(APPLICATION_NAME);
		setContent(buildLayout());
	}
	
	private VerticalLayout buildLayout(){
		Label appName = new Label(APPLICATION_NAME);
//		appName.setWidth(null);
		appName.setStyleName("h1");
		
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.addComponent(appName);
		mainLayout.addComponent(new SearchForm());
		mainLayout.setComponentAlignment(appName, Alignment.MIDDLE_CENTER);
		
		return mainLayout;
	}
	
}