package oop;

import java.util.*;

public class EventSystem {

	private Event[] events = new Event[100];// array that stores the objects i class Event and also SecialEvent because
											// of inheritance.
	private int count = 0;

	public void runAll() {
		Scanner input = new Scanner(System.in);
		int choice;

		for (;;) {
			showmenu();
			System.out.println("please enter your choise: ");
			choice = input.nextInt();

			if (choice == 1) {
				addEvents(input);
			} else if (choice == 2) {
				listEvents();
			} else if (choice == 3) {
				registerParticipant(input);
			} else if (choice == 4) {
				showSortedEvents();
			} else if (choice == 0) {
				System.out.println("THANKS FOR CHOOSING US");
				System.out.println("EXITING THE SYSTEM");
				break;
			} else {
				System.out.println("INVALID INPUT, PLEASE TRY AGAIN");
			}

		}

	}

	public void showmenu() {
		System.out.println("<<<<<<<<<<< EVENT REGISTRATION SYSTEM >>>>>>>>>>>");
		System.out.println("1- TO ADD NEW EVENTS ");
		System.out.println("2- TO LIST ALL EVENTS");
		System.out.println("3- TO REGISTER PARTICIPANT FOR EVENT");
		System.out.println("4- TO DISPLAY UPCOMING EVENTS (SORTED BY ORDER DATE)");
		System.out.println("0- TO EXIT THE SYSTEM");

	}

	public void addEvents(Scanner input) {

		System.out.println("<<<<<<<<<ADDING NEW EVENT>>>>>>>>>");
		System.out.println("please enter evenr id: ");
		int idv = input.nextInt();
		input.nextLine();// used to clean the buffer

		System.out.println("please enter the event name :");
		String namev = input.nextLine();

		System.out.println("please enter the event date (YYYYMMDD): ");
		int datev = input.nextInt();

		input.nextLine();// to clean the buffer and let you write the place event
		System.out.println("please enter the event venue:(place) ");
		String venuev = input.nextLine();

		System.out.println("please enter the event max capacity: ");
		int capacityv = input.nextInt();
		input.nextLine();

		System.out.println("is it a special event: [Y,N]");
		char answer = input.next().charAt(0);
		input.nextLine();

		if (answer == 'y') {
			System.out.println("whos the sponsor: ");
			String sponsorv = input.nextLine();
			events[count++] = new Event(idv, datev, capacityv, namev, venuev, sponsorv);
		} else {

			events[count++] = new Event(idv, datev, capacityv, namev, venuev);
		}
		System.out.println("EVENT ADDED SUCCESSFULLY");

	}

	public void listEvents() {
		if (count == 0) {
			System.out.println("NO EVENTS ADDED YET");
			return;
		}
		for (int i = 0; i < count; i++) {
			events[i].printInfo();
		}
	}

	private void registerParticipant(Scanner input) {// just to increase the number of registered
		System.out.println("ENETER THE EVENT ID : ");
		int id = input.nextInt();

		Event M = findEvent(id);
		if (M == null) {
			System.out.println("the event is not found");
			return;
		}
		if (M.registerOne()) {
			System.out.println("registered successfully");
		} else {
			System.out.println("event is full");
		}
	}

	private Event findEvent(int id) {// to check the event id
		for (int i = 0; i < count; i++) {
			if (events[i].getIdv() == id) {
				return events[i];
			}
		}
		return null;
	}

	private void showSortedEvents() {
		for (int i = 0; i < count - 1; i++) {

			for (int j = 0; j < count - 1; j++) {
				if (events[j].getDatev() > events[j + 1].getDatev()) {
					// define by Event because we want to swap the objects in the array
					// events
					Event temp = events[j];
					events[j] = events[j + 1];
					events[j + 1] = temp;
				}
			}

		}

		System.out.println("EVENTS SORTED SUCCESSFULLY");
		for (int m = 0; m < count; m++) {
			System.out.println("Name: " + events[m].getNamev() + " | Date: " + events[m].getDatev());
		}

	}

}
