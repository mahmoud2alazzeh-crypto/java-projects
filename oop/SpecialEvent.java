package oop;

public class SpecialEvent extends Event {

	private String sponsor;

	public SpecialEvent(int idv, int datev, int capacityv, String namev, String venuev, String sponsor) {
		super(idv, datev, capacityv, namev, venuev);// call the parent constructor
		this.sponsor = sponsor;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsorv) {
		this.sponsor = sponsorv;
	}

	// override tool
	public void printInfo() {
		super.printInfo();// call the parents method
		System.out.println(" Sponsor: " + sponsor);

	}

}
