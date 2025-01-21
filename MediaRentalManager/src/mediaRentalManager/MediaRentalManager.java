package mediaRentalManager;

import java.util.*;
import java.util.ArrayList;

public class MediaRentalManager implements MediaRentalManagerInt {

	// customer and media database
	private ArrayList<Customer> customerDatabase = new ArrayList<Customer>();
	private ArrayList<Media> mediaDatabase = new ArrayList<Media>();
	private static int planLimit = 2;

	/**
	 * Adds the specified customer to the database. The address is a physical
	 * address (not e-mail). The plan options available are: <b>LIMITED</b> and
	 * <b>UNLIMITED</b>. LIMITED defines a default maximum of two media that can be
	 * rented.
	 * 
	 * @param name
	 * @param address
	 * @param plan
	 */
	public void addCustomer(String name, String address, String plan) {
		Customer customer = new Customer(name, address, plan);
		customerDatabase.add(customer);
	}

	/**
	 * Adds the specified movie to the database. The possible values for rating are
	 * "PG", "R", "NR".
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @param rating
	 */
	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie movie = new Movie(title, copiesAvailable, rating);
		mediaDatabase.add(movie);
	}

	/**
	 * Adds the specified album to the database. The songs String includes a list of
	 * the title of songs in the album (song titles are separated by commas).
	 * 
	 * @param title
	 * @param copiesAvailable
	 * @param artist
	 * @param songs
	 */
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album album = new Album(title, copiesAvailable, artist, songs);
		mediaDatabase.add(album);
	}

	/**
	 * This sets the number of media associated with the LIMITED plan.
	 * 
	 * @param value
	 */
	public void setLimitedPlanLimit(int value) {
		planLimit = value;
	}

	/**
	 * This returns the number of media associated with the LIMITED plan.
	 * 
	 * @param value
	 */
	public static double getLimitedPlanLimit() {
		return planLimit;
	}

	/**
	 * Returns information about the customers in the database. The information is
	 * presented sorted by customer name. See the public tests for the format to
	 * use.
	 * 
	 * @return
	 */
	public String getAllCustomersInfo() {
		String value = "***** Customers' Information *****\n";
		Collections.sort(customerDatabase);
		for (Customer cust : customerDatabase) {
			value += "Name: " + cust.getName() + ", Address: " + cust.getAddress() + ", Plan: " + cust.getPlan()
					+ "\nRented: " + cust.getRented() + "\nQueue: " + cust.getQ() + "\n";
		}
		return value;
	}

	/**
	 * Returns information about all the media (movies and albums) that are part of
	 * the database. The information is presented sorted by media title. See the
	 * public tests for the format to use.
	 * 
	 * @return
	 */
	public String getAllMediaInfo() {
		Movie movie = new Movie("test", 0, "test");
		Album album = new Album("test", 0, "test", "test");

		String value = "***** Media Information *****\n";
		Collections.sort(mediaDatabase);
		for (Media med : mediaDatabase) {
			if (med.getClass() == movie.getClass()) {
				Movie film = (Movie) med;
				value += "Title: " + film.getTitle() + ", Copies Available: " + film.getCopiesAvailable() + ", Rating: "
						+ film.getRating() + "\n";
			}
			if (med.getClass() == album.getClass()) {
				Album mixtape = (Album) med;
				value += "Title: " + mixtape.getTitle() + ", Copies Available: " + mixtape.getCopiesAvailable()
						+ ", Artist: " + mixtape.getArtist() + ", Songs: " + mixtape.getSongs() + "\n";
			}
		}
		return value;

	}

	/**
	 * Adds the specified media title to the queue associated with a customer.
	 * 
	 * @param customerName
	 * @param mediaTitle
	 * @return false if the mediaTitle is already part of the queue (it will not be
	 *         added)
	 */
	public boolean addToQueue(String customerName, String mediaTitle) {
		Customer temp = new Customer("", "", "");
		for (int i = 0; i < this.customerDatabase.size(); i++) {
			if (this.customerDatabase.get(i).getName().equals(customerName)) {
				temp = this.customerDatabase.get(i);
			}
		}

		for (int i = 0; i < temp.getQ().size(); i++) {
			if (temp.getQ().get(i).equals(mediaTitle)) {
				return false;
			}
		}

		temp.addMediaTitle(mediaTitle);
		return true;
	}

	/**
	 * Removes the specified media title from the customer's queue.
	 * 
	 * @param customerName
	 * @param mediaTitle
	 * @return false if removal failed for any reason (e.g., customerName not found)
	 */
	public boolean removeFromQueue(String customerName, String mediaTitle) {
		Customer temp = new Customer("", "", "");
		for (int i = 0; i < this.customerDatabase.size(); i++) {
			if (this.customerDatabase.get(i).getName().equals(customerName)) {
				temp = this.customerDatabase.get(i);
			}
		}

		for (int i = 0; i < temp.getQ().size(); i++) {
			if (temp.getQ().get(i).equals(mediaTitle)) {
				temp.removeMediaTitle(i);
				return false;
			}
		}
		return false;
	}

	/**
	 * Processes the requests queue of each customer. The customers will be
	 * processed in alphabetical order. For each customer, the requests queue will
	 * be checked and media will be added to the rented queue, if the plan
	 * associated with the customer allows it, and if there is a copy of the media
	 * available. For UNLIMITED plans the media will be added to the rented queue
	 * always, as long as there are copies associated with the media available. For
	 * LIMITED plans, the number of entries moved from the requests queue to the
	 * rented queue will depend on the number of currently rented media, and whether
	 * copies associated with the media are available.<br>
	 * <br>
	 * For each media that is rented, the following message will be generated:<br>
	 * "Sending [mediaTitle] to [customerName]" <br>
	 * 
	 * @return
	 */
	public String processRequests() {
		Collections.sort(customerDatabase);
		String value = "";
		Customer temp = new Customer("", "", "");
		boolean valid = false;

		for (int i = 0; i < this.customerDatabase.size(); i++) {
			if (this.customerDatabase.get(i).getQ().size() > 0) {
				temp = this.customerDatabase.get(i);

				for (int k = 0; k < temp.getQ().size(); k++) {
					if (temp.getRented().size() < temp.getPlanLimit()) {
						String mediaTitle = temp.getQ().get(k);

						for (int j = 0; j < mediaDatabase.size(); j++) {
							if (mediaDatabase.get(j).getTitle().equals(mediaTitle)) {
								if (mediaDatabase.get(j).getCopiesAvailable() > 0) {
									valid = true;
									mediaDatabase.get(j)
											.setCopiesAvailable(mediaDatabase.get(j).getCopiesAvailable() - 1);
									break;
								}
							}
						}
						if (valid) {
							value += "Sending " + temp.getQ().get(k) + " to " + temp.getName() + "\n";
							temp.getRented().add(temp.getQ().get(k));
							removeFromQueue(temp.getName(), mediaTitle);
							k--; // ensures no elements are skipped in arrayList
							valid = false;
						}
					}
				}
			}
		}
		return value;
	}

	/**
	 * This is how a customer returns a rented media. This method will remove the
	 * item from the rented queue and adjust any other values that are necessary
	 * (e.g., copiesAvailable)
	 * 
	 * @param customerName
	 * @param mediaTitle
	 * @return
	 */
	public boolean returnMedia(String customerName, String mediaTitle) {
		Customer temp = new Customer("", "", "");
		boolean value = false;

		for (int i = 0; i < this.customerDatabase.size(); i++) {
			if (this.customerDatabase.get(i).getName().equals(customerName)) {
				temp = this.customerDatabase.get(i);
			}
		}

		for (int i = 0; i < temp.getRented().size(); i++) {
			if (temp.getRented().get(i).equals(mediaTitle)) {
				temp.getRented().remove(i);
				value = true;
				break;
			}
		}

		for (int i = 0; i < mediaDatabase.size(); i++) {
			if (mediaDatabase.get(i).getTitle().equals(mediaTitle)) {
				mediaDatabase.get(i).setCopiesAvailable(mediaDatabase.get(i).getCopiesAvailable() + 1);
				break;
			}
		}

		return value;
	}

	/**
	 * Returns a SORTED ArrayList with media titles that satisfy the provided
	 * parameter values. If null is specified for a parameter, then that parameter
	 * should be ignore in the search. Providing null for all parameters will return
	 * all media titles.
	 * 
	 * @param title
	 * @param rating
	 * @param artist
	 * @param songs
	 * @return
	 */
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> value = new ArrayList<String>();
		Movie movie = new Movie("test", 0, "test");
		Album album = new Album("test", 0, "test", "test");

		if (title == null && rating == null && artist == null && songs == null) {
			for (int i = 0; i < mediaDatabase.size(); i++) {
				value.add(this.mediaDatabase.get(i).getTitle());
			}
		} else {
			for (int i = 0; i < mediaDatabase.size(); i++) {

				if (title != null && this.mediaDatabase.get(i).getTitle().equals(title)) {
					value.add(this.mediaDatabase.get(i).getTitle());

				} else if (this.mediaDatabase.get(i).getClass() == movie.getClass()) {
					Movie temp = (Movie) this.mediaDatabase.get(i);
					if (temp.getRating() != null && rating != null && temp.getRating().equals(rating)) {
						value.add(temp.getTitle());
					}
				} else if (this.mediaDatabase.get(i).getClass() == album.getClass()) {
					Album temp = (Album) this.mediaDatabase.get(i);
					if (songs != null && (temp.getArtist().equals(artist) || temp.getSongs().contains(songs))) {
						value.add(temp.getTitle());
					}
				}
			}
		}

		Collections.sort(value);
		return value;
	}
}
