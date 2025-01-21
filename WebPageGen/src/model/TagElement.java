package model;

/**
 * 
 * Represents an HTML tag element (<&lt;p&gt;, &lt;ul&gt;, etc.). Each tag has
 * an id (ids start at 1). By default the start tag will have an id (e.g.,
 * <&lt;p id="a1"&gt;&lt;/p&gt;) when the HTML for the tag is generated. This
 * can be disabled by using enableId.
 * 
 * @author UMCP
 *
 */
public class TagElement implements Element {
	private String tagName;
	private boolean endTag;
	private Element content;
	private String attributes;
	public int id;
	public static int idCount = 1;
	public static boolean enabled = false;

	// default construct for tagElemnt parent class
	public TagElement(String tagName, boolean endTag, Element content, String attributes) {
		this.tagName = tagName;
		this.endTag = endTag;
		this.content = content;
		this.setAttributes(attributes);
		this.id = idCount;
		idCount++;
	}

	public String getStringId() {
		if (enabled) {
			return " id=\"" + tagName + getId() + "\"";
		}
		return "";
	}

	public int getId() {
		return id;
	}

	public String getStartTag() {
		return "<" + tagName + getStringId() + getAttributes() + ">";
	}

	public String getEndTag() {
		if (endTag) {
			return "</" + tagName + ">";
		}
		return "";
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	// resets static id count
	public static void resetIds() {
		idCount = 1;
	}

	// controls whether HTML elements contain an id
	public static void enableId​(boolean choice) {
		enabled = choice;
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		value += getStartTag();
		value += content.genHTML(0);
		value += getEndTag();
		return value;
	}

	public String getAttributes() {
		if (attributes == null) {
			return "";
		}
		return " " + attributes;
	}
}