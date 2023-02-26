package com.candorgrc.idfusion.sandbox.client.datapresentation.cell;

import com.candorgrc.idfusion.sandbox.client.model.PersonJso;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ValueUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.BrowserEvents;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class PersonCell extends AbstractCell<PersonJso> {

	public static enum Action {
		CREATE, UPDATE, COPY, DELETE
	}

	/*
	 * Safe XHTML5 Template instance.
	 */
	private Template template;

	/*
	 * Constructor method
	 */
	public PersonCell() {
		/*
		 * register for consuming click events
		 */
		super(BrowserEvents.CLICK);

		// instantiate Safe HTML Template
		if (template == null) {
			template = GWT.create(Template.class);
		}
	}

	/*
	 * HTML render method.
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#render(com.google.gwt.cell.client
	 * .Cell.Context, java.lang.Object,
	 * com.google.gwt.safehtml.shared.SafeHtmlBuilder)
	 */
	@Override
	public void render(Context context, PersonJso value, SafeHtmlBuilder sb) {
		if (value != null) {

			// build
			//@formatter:off
			sb.append(template.build(value.getTitle(), 			// 0
								     value.getFirstName(), 		// 1
								     value.getLastName(),  		// 2
								     value.getSuffix(), 		// 3
								     value.getGender(), 		// 4
								     value.getRace(), 			// 5
								     value.getLanguage(), 		// 6
								     value.getUniversity(),		// 7
								     value.getBuzzword(),  		// 8
								     value.getEmail(),  		// 9
								     value.getJobTitle(), 		// 10
								     value.getLinkedinSkill(), 	// 11
								     value.getAvatar(), 		// 12
								     value.getCompany(), 		// 13
								     value.getDepartment(), 	// 14
								     value.getEin(), 			// 15
								     Action.UPDATE.name(), 		// 16
								     Action.COPY.name(), 		// 17
								     Action.DELETE.name())); 	// 18
			//@formatter:on

			// other asynchronous workers may be added here
		}
	}

	/*
	 * Handle Browser Event(s).
	 *
	 * (non-Javadoc)
	 *
	 * @see
	 * com.google.gwt.cell.client.AbstractCell#onBrowserEvent(com.google.gwt.
	 * cell.client.Cell.Context, com.google.gwt.dom.client.Element,
	 * java.lang.Object, com.google.gwt.dom.client.NativeEvent,
	 * com.google.gwt.cell.client.ValueUpdater)
	 */
	@Override
	public void onBrowserEvent(Context context, Element parent, PersonJso value, NativeEvent event, ValueUpdater<PersonJso> valueUpdater) {
		super.onBrowserEvent(context, parent, value, event, valueUpdater);
		final Element element = event.getEventTarget().cast();
		final String action = element.getAttribute("action");

		if (!action.isEmpty()) {
			value.setAction(action);
			valueUpdater.update(value);
		}
	}

	/**
	 * Cell XHTML Template.
	 * 
	 * @designer: feel free to modify it in order to meet your expectations
	 *
	 */
	public interface Template extends SafeHtmlTemplates {
		//@formatter:off
		@Template("<div class='person-cell'>"
				 	+ "<header>"
				 		+ "<figure>"
				 			+ "<img class='avatar' src=\"{12}\"></img>"
				 			+ "<figcaption class='caption'>"
				 				+ "<span class='title' title='Title'><i class='fa-solid fa-user'></i> {0}</span>"
				 				+ "<span class='first-name' title='First Name'>{1}</span>"
				 				+ "<span class='last-name' title='Last Name'>{2}</span>"
				 				+ "<span class='suffix' title='Suffix'>{3}</span>"
				 			+ "</figcaption>"
				 		+ "</figure>"
					+ "</header>"
					+ "<section>"
						+ "<div class='section-inner-wrap'>"
							+ "<div class='personal-info'>"
								+ "<i class='{4}' title='{4}'></i>"
								+ "<div class='race' title='Race'><i class='fa-solid fa-image-portrait'></i> {5}</div>"
								+ "<div class='language' title='Language'><i class='fa-solid fa-language'></i> {6}</div>"
							+ "</div>"
							+ "<div class='education'>"
								+ "<div class='university' title='University'><i class='fa-solid fa-building-columns'></i> {7}</div>"
							+ "</div>"
							+ "<div class='work'>"
								+ "<div class='job-title' title='Job Title'><i class='fa-solid fa-chalkboard'></i> {10}</div>"
								+ "<div class='company' title='Company'><i class='fa-solid fa-chalkboard'></i> {13}</div>"
								+ "<div class='department' title='Department'><i class='fa-solid fa-building-user'></i> {14}</div>"
								+ "<div class='ein' title='Employer Identification Number'><i class='fa-solid fa-id-card'></i> {15}</div>"
								+ "<div class='email' title='E-Mail'><i class='fa-solid fa-square-envelope'></i> {9}</div>"
							+ "</div>"
							+ "<aside>"
								+ "<div class='linkedin-skill' title='LinkedIn Skill'><i class='fa-brands fa-linkedin'></i> {11}</div>"
								+ "<div class='buzzword' title='Buzzword'><i class='fa-solid fa-pen-to-square'></i> {8}</div>"
							+ "</aside>"
						+ "</div>"
					+ "</section>"
					+ "<footer>"
						+ "<nav class='controls'>"
							+ "<button class='edit' action='{16}' title='Edit'><i class='edit fa-solid fa-pen' action='{16}'></i> Edit</button>"
							+ "<button class='copy' action='{17}' title='Copy'><i class='copy fa-regular fa-copy' action='{17}'></i> Copy</button>"
							+ "<button class='delete' action='{18}' title='Delete'><i class='delete fa-solid fa-trash' action='{18}'></i> Delete</button>"
						+ "</nav>"
					+ "</footer>"
				+ "</div>")
		//@formatter:on
		SafeHtml build(String title, String firstName, String lastName, String suffix, String gender, String race, String language, String university, String buzzword,
				String email, String jobTitle, String linkedinSkill, String avatar, String company, String department, String ein, String editAction, String copyAction,
				String deleteAction);
	}

}