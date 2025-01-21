package model;

import java.util.ArrayList;

/**
 * 
 * Represents a paragraph (&lt;p&gt;) tag. It relies on an ArrayList in order to
 * keep track of the set of Element objects that are part of the paragraph.
 * 
 * @author UMCP
 *
 */
public class ParagraphElement extends TagElement {
	private ArrayList<Element> items;

	// constructor
	public ParagraphElement(String attributes) {
		super("p", true, null, attributes);
		items = new ArrayList<>();
	}

	// adds Element to items arraylist
	public void addItem​(Element item) {
		items.add(item);
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		value += getStartTag() + "\n   ";
		for (Element item : items) {
			value += item.genHTML(indentation) + "\n   ";
		}
		value += getEndTag();
		return value;
	}

}
