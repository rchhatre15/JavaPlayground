package model;

import java.util.ArrayList;

/**
 * Represents the &lt;ul&gt and the &lt;ol&gt; tags. An ArrayList is used to
 * keep track of the Element objects of the list.
 * 
 * @author UMCP
 *
 */
public class ListElement extends TagElement {
	private ArrayList<Element> items;
	private boolean ordered;

	// constructor
	public ListElement(boolean ordered, String attributes) {
		super("ul", true, null, attributes);
		this.ordered = ordered;
		items = new ArrayList<>();
	}

	public void addItem​(Element item) {
		items.add(item);
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		if (ordered && getStringId().length() > 0) {
			String orderedId = getStringId().substring(0, 5) + 'o' + getStringId().substring(6);
			value += "<ol" + orderedId + getAttributes() + ">\n   ";
		} else if (ordered) {
			value += "<ol" + getStringId() + getAttributes() + ">\n   ";
		} else {
			value += "<ul" + getStringId() + getAttributes() + ">\n   ";
		}
		for (Element item : items) {
			value += Utilities.spaces(indentation);
			value += "<li>\n      ";
			value += item.genHTML(indentation) + "\n   ";
			value += Utilities.spaces(indentation);
			value += "</li>\n   ";
		}
		value += Utilities.spaces(indentation);
		if (ordered) {
			value += "</ol>";
		} else {
			value += "</ul>";
		}
		return value;
	}

}
