package mediaRentalManager;

import java.util.ArrayList;

public class Customer implements Comparable<Object> {
	private ArrayList<String> q;
	private ArrayList<String> rented;
	private String name;
	private String address;
	private String plan;
	private double planLimit;

	// default constructor for customer
	public Customer(String name, String address, String plan) {
		this.setName(name);
		this.setAddress(address);
		if (plan.equals("LIMITED")) {
			this.setPlan(plan);
			setPlanLimit((double) MediaRentalManager.getLimitedPlanLimit());
		} else {
			this.setPlan(plan);
			setPlanLimit(Double.POSITIVE_INFINITY);
		}
		this.q = new ArrayList<String>();
		this.rented = new ArrayList<String>();
	}

	// Support methods for addToQueue and removeFromQueue
	public void removeMediaTitle(int index) {
		q.remove(index);
	}

	public void addMediaTitle(String title) {
		q.add(title);
	}

	// getters and setters
	public String getName() {
		String temp = name;
		return temp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		String temp = address;
		return temp;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlan() {
		String temp = plan;
		return temp;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public ArrayList<String> getQ() {
		ArrayList<String> temp = this.q;
		return temp;
	}

	public ArrayList<String> getRented() {
		ArrayList<String> temp = this.rented;
		return temp;
	}

	public double getPlanLimit() {
		double temp = planLimit;
		return temp;
	}

	public void setPlanLimit(double planLimit) {
		this.planLimit = planLimit;
	}

	// compareTo method which relies on customer name
	@Override
	public int compareTo(Object o) {
		Customer cust = (Customer) o;
		return this.getName().compareTo(cust.getName());
	}
}
