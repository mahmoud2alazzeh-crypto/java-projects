package oop;

public class Event {

	private int idv;
	private int datev;
	private int capacityv;
	private int registeredv;
	private String namev;
	private String venuev;

	// constructor overloading
	public Event(int idv, int datev, int capacityv, String namev, String venuev) {
		this.idv = idv;
		this.datev = datev;
		this.capacityv = capacityv;
		this.namev = namev;
		this.venuev = venuev;
	}

	public Event(int idv, int datev, int capacityv, String namev, String venuev, String sponsorv) {
		// TODO Auto-generated constructor stub
		this.idv = idv;
		this.datev = datev;
		this.capacityv = capacityv;
		this.namev = namev;
		this.venuev = venuev;
	}

	public int getIdv() {
		return idv;
	}

	public void setIdv(int idv) {
		this.idv = idv;
	}

	public int getDatev() {
		return datev;
	}

	public void setDatev(int datev) {
		this.datev = datev;
	}

	public int getCapacityv() {
		return capacityv;
	}

	public void setCapacityv(int capacityv) {
		this.capacityv = capacityv;
	}

	public int getRegisteredv() {
		return registeredv;
	}

	public void setRegisteredv(int registeredv) {
		this.registeredv = registeredv;
	}

	public String getNamev() {
		return namev;
	}

	public void setNamev(String namev) {
		this.namev = namev;
	}

	public String getVenuev() {
		return venuev;
	}

	public void setVenuev(String venuev) {
		this.venuev = venuev;
	}

	public boolean registerOne() {
		if (registeredv < capacityv) {
			registeredv++;
			return true;
		}
		return false;
	}

	public void printInfo() {
		System.out.println("EVENTS DATA");
		System.out.println(" ID : " + idv + " NAME : " + namev + " DATE : " + datev + " VENUE : " + venuev
				+ " CAPCITY: " + capacityv + " REGISTERED : " + registeredv);
	}

}
