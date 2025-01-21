package model;

/**
 * Represents an &lt;img&gt; tag. For this project you can assume we will not
 * update any of the attributes associated with this tag.
 * 
 * @author UMCP
 *
 */
public class ImageElement extends TagElement {
	private String imageURL;
	private int width;
	private int height;
	private String alt;

	// constructor
	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {
		super("img", false, null, attributes);
		this.imageURL = imageURL;
		this.width = width;
		this.height = height;
		this.alt = alt;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String genHTML(int indentation) {
		String value = "";
		value += Utilities.spaces(indentation);
		value += "<img" + getStringId() + " src=\"" + getImageURL() + "\" width=\"" + this.width + "\" height=\""
				+ this.height + "\" alt=\"" + this.alt + "\" " + getAttributes() + ">";
		value += getEndTag();
		return value;
	}

}
