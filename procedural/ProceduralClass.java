package procedural;

import java.util.*;

public class ProceduralClass {

	static final int MaxNumOfEvents = 50;
	static final int MaxNumOfparticpant = 200;

	// some arrays related to the events
	static int[] eventIds = new int[MaxNumOfEvents];
	static String[] eventname = new String[MaxNumOfEvents];
	static int[] eventDate = new int[MaxNumOfEvents];
	static int[] eventDuration = new int[MaxNumOfEvents];
	static String[] eventVenue = new String[MaxNumOfEvents];
	static int[] eventCapacity = new int[MaxNumOfEvents];
	static int[] eventregisteredcount = new int[MaxNumOfEvents];

	// arrays related to the participants
	static int[] participantsIds = new int[MaxNumOfEvents];
	static String[] participantsName = new String[MaxNumOfEvents];
	static String[] participantsEmail = new String[MaxNumOfEvents];
	static int[] participantEventId = new int[MaxNumOfEvents];

	// to count how many events made
	static int eventCount = 0;
	// to count how many participant registered
	static int participantCount = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		for (;;) {
			showMenu();
			System.out.println("please enter your choice (between 0-4) :");
			int choice = -1;

			try {// error handling to let the user enter only correct input
				choice = input.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("please enter a number ");
				input.nextLine();
			}

			if (choice == 1) {
				addEvent(input);
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

	public static void showMenu() {
		System.out.println("<<<<<<<<<<< EVENT REGISTRATION SYSTEM >>>>>>>>>>>");
		System.out.println("press 1 TO ADD NEW EVENTS ");
		System.out.println("press 2 TO LIST ALL EVENTS");
		System.out.println("press 3 TO REGISTER PARTICIPANT FOR EVENT");
		System.out.println("press 4 TO DISPLAY UPCOMING EVENTS (SORTED BY ORDER DATE)");
		System.out.println("press 0 TO EXIT THE SYSTEM");

	}

	// the first feature
	public static void addEvent(Scanner input) {

		if (eventCount >= MaxNumOfEvents) {
			System.out.println("you have reched the max num of events");
		}
		System.out.println("<<<<<<<<<ADDING NEW EVENT>>>>>>>>>");
		System.out.println("please enter evenr id: ");
		int idv = input.nextInt();

		// to reject any duplicate id's use the following function
		if (EventIdIndex(idv) != -1) {
			System.out.println("event is used");
			return;
		}
		input.nextLine();// used to clean the buffer

		System.out.println("please enter the event name :");
		String namev = input.nextLine();// add break points to check ant logical error

		System.out.println("please enter the event date (YYYYMMDD): ");
		int datev = input.nextInt();

		System.out.println("please eneter the event time: (ex:1820) ");
		int timev = input.nextInt();

		input.nextLine();// to clean the buffer and let you write the place event
		System.out.println("please enter the event venue:(place) ");
		String venuev = input.nextLine();

		System.out.println("please enter the event max capacity: ");
		int capacityv = input.nextInt();

		// should store all these data in the arrays to use them in the third feature
		eventIds[eventCount] = idv;
		eventname[eventCount] = namev;
		eventDate[eventCount] = datev;
		eventDuration[eventCount] = timev;
		eventVenue[eventCount] = venuev;
		eventCapacity[eventCount] = capacityv;
		eventregisteredcount[eventCount] = 0;

		eventCount++;
		System.out.println("EVENT ADDED SUCCESSFULLY");
	}

	public static void listEvents() {
		if (eventCount == 0) {
			System.out.println("NO EVENTS ADDED YET");
			return;
		}
		System.out.println("<<<<<<< list of all events >>>>>>>");
		for (int i = 0; i < eventCount; i++) {
			System.out.println("IDV: " + eventIds[i] + " ,DATEV: " + eventDate[i] + " ,NAMEV: " + eventname[i]
					+ " ,TIMEV: " + eventDuration[i] + " ,VENUEV: " + eventVenue[i] + " ,CAPACITYV: " + eventCapacity[i]
					+ " ,REGISTERED: " + eventregisteredcount[i]);
			System.out.println();
		}
	}

	public static int EventIdIndex(int idv) {
		for (int i = 0; i < eventCount; i++) {
			if (eventIds[i] == idv) {
				return i;
			}
		}

		return -1;// the event id isn't found
	}
//the second feature

	public static void registerParticipant(Scanner input) {
		if (participantCount >= MaxNumOfparticpant) {// chech the number of all participants
			System.out.println("you have reached the max num of participants");
			return;
		}
		System.out.println("<<<<<<<ADDING PARTICIPANT>>>>>>>");
		System.out.println("please enter event id to add for: ");
		int eventidv = input.nextInt();
		int eventIndex = EventIdIndex(eventidv);// to check if the event is is valid
		if (eventIndex == -1) {
			System.out.println("event not from the list");
			return;
			// check if the capacity is not full
		}
		if (eventregisteredcount[eventIndex] >= eventCapacity[eventIndex]) {// check for the participants in the event
			System.out.println("event is full, please register in another event");
			return;
		}

		System.out.println("<<<<<<participant registration>>>>>>");
		int participantid = -1;

		while (true) {// loop to keep iterate until user enter a correct input
			try {
				System.out.println("please enter the participant id: ");
				participantid = input.nextInt();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("please enter an id consist of numbers except -1");
				input.nextLine();
			}
		}
		// check if participant already registered
		if (participantIdIndex(participantid) != -1) {
			System.out.println("participant already registered");
			return;
		}
		input.nextLine();
		System.out.println("please enter the participant name: ");
		String participantName = input.nextLine();

		System.out.println("please enter the participant Email: ");
		String participantEmail = input.nextLine();

		// store all these data inside the participant arrays
		participantsIds[participantCount] = participantid;
		participantsName[participantCount] = participantName;
		participantsEmail[participantCount] = participantEmail;
		participantEventId[participantCount] = eventidv;
		participantCount++;
		eventregisteredcount[eventIndex]++;
		System.out.println("the participant added successfully");
	}

	public static int participantIdIndex(int id) {
		for (int i = 0; i < participantCount; i++) {
			if (participantsIds[i] == id) {
				return i;
			}
		}
		return -1;
	}

	// the third feature
	public static void showSortedEvents() {
		if (eventCount == 0) {
			System.out.println("no events added yet");
			return;
		}
		selectionSortEventsByDate();
		System.out.println("<<<< the upcoming events ordered by date >>>>");
		for (int i = 0; i < eventCount; i++) {
			System.out.println("date: " + eventDate[i] + " ,name: " + eventname[i]);
		}
	}

	// algo to sort the events by date
	public static void selectionSortEventsByDate() {
		for (int i = 0; i < eventCount - 1; i++) {
			for (int j = 0; j < eventCount - 1; j++) {
				if (eventDate[j] > eventDate[j + 1]) {

					// swap the dates and name
					int tempForDate = eventDate[j];
					eventDate[j] = eventDate[j + 1];
					eventDate[j + 1] = tempForDate;

					String tempForName = eventname[j];
					eventname[j] = eventname[j + 1];
					eventname[j + 1] = tempForName;
				}
			}
		}
	}

}