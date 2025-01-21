package mediaRentalManager;

public class Movie implements Media, Comparable<Media> {
	private String title;
	private int copiesAvailable;
	private String rating;

	// default constructor for movies
	public Movie(String title, int copiesAvailable, String rating) {
		this.setTitle(title);
		this.setCopiesAvailable(copiesAvailable);
		if (rating.equals("PG")) {
			this.setRating(rating);
		} else if (rating.equals("R")) {
			this.setRating(rating);
		} else if (rating.equals("NR")) {
			this.setRating(rating);
		} else {
			this.setRating(rating);
		}
	}

	// getters and setters
	public String getTitle() {
		String temp = title;
		return temp;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCopiesAvailable() {
		int temp = copiesAvailable;
		return temp;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getRating() {
		String temp = rating;
		return temp;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	// compareTo method which relies on title
	@Override
	public int compareTo(Media o) {
		return this.getTitle().compareTo(o.getTitle());
	}
}
