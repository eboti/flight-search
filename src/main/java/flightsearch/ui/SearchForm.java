package flightsearch.ui;

import static com.vaadin.ui.Alignment.MIDDLE_CENTER;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class SearchForm extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private static final String TO = "To";
	private static final String FROM = "From";
	private static final String SEARCH = "Search";
	private static final String ONE_WAY = "One way";
	private static final String ARRIVAL = "Arrival";
	private static final String DEPARTURE = "Departure";
	private static final String TOWN_OR_COUNTRY = "town or country";
	private static final String SEARCHING_FLIGHTS = "Searching flights...";

	SearchForm() {
		super();
		buildForm();
	}

	private void buildForm() {
		setMargin(true);
		setSpacing(true);

		HorizontalLayout countrySelector = buildCountrySelectors();
		addComponent(countrySelector);

		HorizontalLayout dateSelector = buildDateSelectors();
		addComponent(dateSelector);

		HorizontalLayout searchLayout = buildSearchLayout();

		addComponent(searchLayout);

		setComponentAlignment(countrySelector, MIDDLE_CENTER);
		setComponentAlignment(dateSelector, MIDDLE_CENTER);
		setComponentAlignment(searchLayout, MIDDLE_CENTER);
	}

	private HorizontalLayout buildCountrySelectors() {
		Label town = new Label(TOWN_OR_COUNTRY);
		TextField countryFrom = new TextField(FROM, town.getValue());
		TextField countryTo = new TextField(TO);
		HorizontalLayout countrySelector = new HorizontalLayout(countryFrom,
				countryTo);
		countrySelector.setSpacing(true);
		return countrySelector;
	}

	private HorizontalLayout buildDateSelectors() {
		DateField dateFrom = new DateField(DEPARTURE);
		DateField dateTo = new DateField(ARRIVAL);
		HorizontalLayout dateSelector = new HorizontalLayout(dateFrom, dateTo);
		dateSelector.setSpacing(true);
		return dateSelector;
	}

	private HorizontalLayout buildSearchLayout() {
		CheckBox checkBox = new CheckBox(ONE_WAY);
		HorizontalLayout searchLayout = new HorizontalLayout(new Button(SEARCH,
				e -> Notification.show(SEARCHING_FLIGHTS,
						Notification.Type.WARNING_MESSAGE)), checkBox);
		searchLayout.setSpacing(true);
		return searchLayout;
	}
}
