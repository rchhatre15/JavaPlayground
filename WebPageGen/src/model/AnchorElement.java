package model;

/**
 * Represents the &lt;a&gt; tag.
 * 
 * @author UMCP
 *
 */
public class AnchorElement extends TagElement {
	private String linkText;
	private String url;

	// constructor
	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, null, attributes);
		this.linkText = linkText;
		this.url = url;
	}

	public String getLinkText() {
		return linkText;
	}

	public String getUrlText() {
		return url;
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		value += "<" + "a" + getStringId() + " href=\"" + getUrlText() + "\"" + getAttributes() + ">";
		value += getLinkText();
		value += getEndTag();
		return value;
	}

}
