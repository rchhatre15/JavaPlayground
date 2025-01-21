package mediaRentalManager;

public class Album implements Media, Comparable<Media> {
	private String title;
	private int copiesAvailable;
	private String artist;
	private String songs;

	// Constructor for album
	public Album(String title, int copiesAvailable, String artist, String songs) {
		this.setTitle(title);
		this.setCopiesAvailable(copiesAvailable);
		this.setArtist(artist);
		this.setSongs(songs);
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

	public String getArtist() {
		String temp = artist;
		return temp;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSongs() {
		String temp = songs;
		return temp;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	// compareTo method which relies on title
	@Override
	public int compareTo(Media o) {
		return this.getTitle().compareTo(o.getTitle());
	}
}
