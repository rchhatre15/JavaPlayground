package photomanager;

import java.util.ArrayList;

/**
 * The Photo class represents a photo. A photo has a source (url o path to the
 * file), the width and height in pixels, the date the photo was taken and
 * comments the user has added (if any). If you look at the class definition,
 * after "public class Photo" you will see "implements Comparable&lt;Photo&gt;".
 * You can ignore it; it means that the Photo class must implement a method
 * called compareTo that takes a Photo as a parameter and returns an integer.
 * Why we need it? Because it will allow us to sort ArrayList of Photos using
 * the compareTo method that you will define. This description has been written
 * under the influence of a lot of caffeine :)
 * 
 * @author UMCP CS Department
 *
 */
public class Photo implements Comparable<Photo> {
	private String photoSource;
	private int width, height;
	private String date;
	private StringBuffer comments;

	/**
	 * Initializes the instance variables with the provided parameter values and
	 * initializes comments with a StringBuffer object. It will throw an
	 * IllegalArgumentException with the message "Constructor: Invalid arguments" if
	 * any string parameter is null or blank, or if the width or height (or both)
	 * are negative or zero. Use the String class isBlank() method to verify whether
	 * a string is blank. You can assume that if a date is provided, it represents a
	 * valid date. You don't need to verify whether photoSource represents a photo
	 * that exists.
	 * 
	 * @param photoSource Url or file location.
	 * @param width       Photo's width in pixels.
	 * @param height      Photo's height in pixels.
	 * @param date        Date the photo was taken.
	 * @throws IllegalArgumentException For invalid parameter.
	 */
	public Photo(String photoSource, int width, int height, String date) {
		boolean error = photoSource == null || date == null || photoSource.isBlank() || date.isBlank() || width < 1
				|| height < 1;
		if (error) {
			throw new IllegalArgumentException("Constructor: Invalid arguments");
		} else {
			this.photoSource = photoSource;
			this.width = width;
			this.height = height;
			this.date = date;
			this.comments = new StringBuffer();
		}

//		try {
//			if (error) {
//				throw new IllegalArgumentException("Constructor: Invalid arguments");
//			} else {
//				this.photoSource = photoSource;
//				this.width = width;
//				this.height = height;
//				this.date = date;
//				this.comments = new StringBuffer();
//			}
//		} catch (IllegalArgumentException e) {
//			e.getMessage();
//		}
	}

	/**
	 * Returns a string with photoSource, width, height and date values separated by
	 * commas. Comments are not part of the string.
	 * 
	 * @return String with values separated by commas.
	 */
	public String toString() {
		return (this.getPhotoSource() + "," + this.getWidth() + "," + this.getHeight() + "," + this.getDate());
	}

	/**
	 * Get method for photoSource.
	 * 
	 * @return photoSource.
	 */
	public String getPhotoSource() {
		return this.photoSource;
	}

	/**
	 * Get method for width.
	 * 
	 * @return width.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Get method for height.
	 * 
	 * @return height.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Get method for date.
	 * 
	 * @return date.
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * Appends the newComment parameter to the comments StringBuffer. Comments must
	 * be separated by commas (the last comment should not be followed by a comma).
	 * If the parameter is null or blank (according to the String class isBlank()
	 * method) no comment will be appended, and the IllegalArgumentException with
	 * the message "Invalid comment" will be thrown. The method returns a reference
	 * to the current object.
	 * 
	 * @param newComment Comment to add.
	 * @return Reference to the current object.
	 */
	public Photo addComments(String newComment) {
		boolean error = newComment == null || newComment.isBlank();
//		try {
//			if (error) {
//				throw new IllegalArgumentException("Invalid comment");
//			} else {
//				if (comments.length() == 0) {
//					this.comments.append(newComment);
//				} else {
//					this.comments.append("," + newComment);
//				}
//			}
//		} catch (IllegalArgumentException e) {
//			e.getMessage();
//		}
//		return this;

		if (error) {
			throw new IllegalArgumentException("Invalid comment");
		} else {
			if (comments.length() == 0) {
				this.comments.append(newComment);
			} else {
				this.comments.append("," + newComment);
			}
		}
		return this;
	}

	/**
	 * Returns a string that corresponds to the comments.
	 * 
	 * @return String corresponding to comments.
	 */
	public String getComments() {
		String value = comments.toString();
		return value;
	}

	/**
	 * Copy constructor. Modifications to the new object should not affect the
	 * original (parameter) object.
	 * 
	 * @param photo To copy.
	 */
	public Photo(Photo photo) {
		this(photo.photoSource, photo.width, photo.height, photo.date);
		this.comments.append(photo.comments.toString());
	}

	/**
	 * This method will compare the date of the current object against the
	 * parameter's object. Use the Utilities.getDate() method that takes a string as
	 * a parameter and returns an integer (of type long) representing the date. We
	 * can represent dates (including time) using integers. The number returned by
	 * Utilities.getDate() represents the number of seconds that have elapsed since
	 * the Unix epoch (00:00:00 UTC on 1 January 1970). Run the main method of the
	 * Utilities.java class to see examples of these integer values.
	 * 
	 * The compareTo method will return a negative value if the date of the current
	 * object precedes the date of the parameter, zero if the dates are the same,
	 * and a positive value otherwise. Don't be surprise if the amount of code
	 * required for compareTo method is minimal. Do not using casting to convert a
	 * long to int as this could lead to wrong results.
	 * 
	 */
	public int compareTo(Photo photo) {
		Long value = Utilities.getDate(this.getDate()) - Utilities.getDate(photo.getDate());
		int valueReturn = value > 0 ? 1 : value < 0 ? -1 : 0;
		return valueReturn;
	}
}