package model;

import java.util.*;

/**
 * Represents a web page. Web page elements are stored in an ArrayList of
 * Element objects. A title is associated with every page. This class implements
 * the Comparable interface. Pages will be compared based on the title.
 * 
 * @author UMCP
 *
 */
public class WebPage implements Comparable<WebPage> {
	private ArrayList<Element> elements;
	private String title;

	// constructor
	public WebPage(String title) {
		this.title = title;
		elements = new ArrayList<>();
	}

	public int addElement​(Element element) {
		elements.add(element);
		if (!(element instanceof TagElement)) {
			return -1;
		}
		return ((TagElement) element).getId();
	}

	// returns a string with all the HTML elements in elements ArrayList
	public String getWebPageHTML​(int indentation) {
		String value = "";
		value += "<!doctype html>\n<html>\n";
		value += Utilities.spaces(indentation) + "<head>\n   ";
		value += Utilities.spaces(indentation) + "<meta charset=\"utf-8\"/>\n   ";
		value += Utilities.spaces(indentation) + "<title>" + this.title + "</title>\n";
		value += Utilities.spaces(indentation) + "</head>\n";
		value += Utilities.spaces(indentation) + "<body>\n";
		for (Element element : elements) {
			value += element.genHTML(indentation);
		}
		value += Utilities.spaces(indentation) + "</body>\n";
		value += "</html>";
		return value;
	}

	public void writeToFile​(String filename, int indentation) {
		Utilities.writeToFile(filename, this.getWebPageHTML​(indentation));
	}

	public Element findElem​(int id) {
		try {
			for (Element element : elements) {
				if (((TagElement) element).getId() == id) {
					return element;
				}
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

	// returns the number of HTML elements and the average table utilization
	public String stats() {
		String value = "";
		int lCount = 0;
		int pCount = 0;
		int tCount = 0;
		double tUtilization = 0;
		int utiCount = 0;

		for (Element element : elements) {
			if (element instanceof ListElement) {
				lCount++;
			} else if (element instanceof ParagraphElement) {
				pCount++;
			} else if (element instanceof TableElement) {
				tCount++;
				tUtilization += ((TableElement) element).getTableUtilization();
				utiCount++;
			}
		}

		value += "List Count: " + lCount + "\n";
		value += "Paragraph Count: " + pCount + "\n";
		value += "Table Count: " + tCount + "\n";
		value += "TableElement Utilization: " + (tUtilization / utiCount * 100);
		return value;
	}

	// compares based on the string generated by getWebHTML
	public int compareTo(WebPage webPage) {
		return this.getWebPageHTML​(0).compareTo(webPage.getWebPageHTML​(0));
	}

	// calls tagElement static method
	public static void enableId​(boolean choice) {
		enableId​(choice);
	}

}
