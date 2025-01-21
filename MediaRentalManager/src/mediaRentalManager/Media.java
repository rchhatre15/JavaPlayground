package mediaRentalManager;

public interface Media extends Comparable<Media> {
	// any classes in media interface must define these 3 methods

	public String getTitle();

	public int getCopiesAvailable();

	public void setCopiesAvailable(int copiesAvailable);
}
