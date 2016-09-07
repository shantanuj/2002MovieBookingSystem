package main;
import model.Storage;
import model.AvailabilityStatus;
import model.room.*;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

public class Rooms {
	public static List<Room> roomList;

	  /**
     * Constructor to allow user to manage the list of rooms of hotel
     */
	public Rooms() {
		int option = -1;
		while (option != 0) {
			Console.printTitle("Room Menu");
			Console.print("(1) Create Room");
			Console.print("(2) Update Room Details");
			Console.print("(3) Update Room Rates");
			Console.print("(4) List All Rooms");
			Console.print("(0) Return to Main Menu");

			option = Console.getOptionFromUserRefresh();

			switch (option) {
			case 1:
				CreateRoom();
				break;
			case 2:
				UpdateRoom();
				break;
			case 3:
				UpdateRoomRates();
				break;
			case 4:
				ListAllRooms();
				break;

			default:
			}
		}
	}

	/**
	 * Create a room.
	 */
	private void CreateRoom() {
		Console.printTitle("Create Room");
		Console.print("(1) Single Room");
		Console.print("(2) Single Room with Sea View");
		Console.print("(3) Single Room with Garden View");
		Console.print("(4) Double Room");
		Console.print("(5) Double Room with Sea View");
		Console.print("(6) Double Room with Garden View");
		Console.print("(7) Deluxe Room");
		Console.print("(8) Deluxe Room with Sea View");
		Console.print("(9) Deluxe Room with Garden View");
		Console.print("(10) VIP Suite");
		Console.print("(11) VIP Suite with Sea View");
		Console.print("(12) VIP Suite with Garden View");

		int option = Console.getOptionFromUserRefresh();
		Room room = null;

		switch (option) {
		case 1:
			room = new SingleRoom();
			room.setRate(Storage.singleRate);
			break;
		case 2:
			room = new SingleSeaRoom();
			room.setRate(Storage.singleSeaRate);
			break;
		case 3:
			room = new SingleSeaRoom();
			room.setRate(Storage.singleGardenRate);
			break;
		case 4:
			room = new DoubleRoom();
			room.setRate(Storage.doubleRate);
			break;
		case 5:
			room = new DoubleSeaRoom();
			room.setRate(Storage.doubleSeaRate);
			break;
		case 6:
			room = new DoubleSeaRoom();
			room.setRate(Storage.doubleGardenRate);
			break;
		case 7:
			room = new DeluxeRoom();
			room.setRate(Storage.deluxeRate);
			break;
		case 8:
			room = new DeluxeSeaRoom();
			room.setRate(Storage.deluxeSeaRate);
			break;
		case 9:
			room = new DeluxeSeaRoom();
			room.setRate(Storage.deluxeGardenRate);
			break;
		case 10:
			room = new VIPSuite();
			room.setRate(Storage.vipSuiteRate);
			break;
		case 11:
			room = new VIPSuiteSea();
			room.setRate(Storage.vipSuiteSeaRate);
			break;
		case 12:
			room = new VIPSuiteSea();
			room.setRate(Storage.vipSuiteGardenRate);
			break;

		default:
		}

		if (room != null) {
			int counter = 1;
			String roomNumber = Console.getInputFromUser("Room Number").trim();
			if (roomList.stream().filter(x -> x.getRoomNumber().equalsIgnoreCase(roomNumber)).findFirst()
					.orElse(null) != null) {
				Console.print("Room already exists");
				Console.enterToContinue();
				return;
			}
			if (!roomNumber.isEmpty())
				room.setRoomNumber(roomNumber);
			else
				return;
			String wifi = Console.getInputFromUser("WiFi (Yes/No)");
			if (Console.validateInputTrueFalse(wifi))
				room.setWifi(Console.stringToBool(wifi));
			else
				return;
			String smoking = Console.getInputFromUser("Smoking (Yes/No)");
			if (Console.validateInputTrueFalse(smoking))
				room.setSmoking(Console.stringToBool(smoking));
			else
				return;
			Console.print("Availability Status");
			for (int i = 0; i < AvailabilityStatus.values().length; i++)
				System.out.print("(" + (i + 1) + ") " + AvailabilityStatus.values()[i].getStatus() + " ");
			System.out.println();
			option = Console.getOptionFromUser();
			if (option > 0 && option <= AvailabilityStatus.values().length)
				room.setAvailability(AvailabilityStatus.values()[option - 1].getStatus());

			Console.printDivider();
			System.out.format("%-18s: %s\n", "Room No.", room.getRoomNumber());
			System.out.format("%-18s: %s\n", "Room Type", room.getRoomType());
			System.out.format("%-18s: %s\n", "Bed Type", room.getBedType());
			System.out.format("%-18s: %d\n", "No. of Beds", room.getNumOfBeds());
			System.out.format("%-18s: %d\n", "Max. Occupants", room.getMaxOccupants());
			System.out.format("%-18s: %s\n", "WiFi", Console.booleanToYesNo(room.isWifi()));
			System.out.format("%-18s: %s\n", "Smoking", Console.booleanToYesNo(room.isSmoking()));
			System.out.format("%-18s: %s\n", "Status", room.getAvailability());
			System.out.format("%-18s: %s\n", "Base Rate", NumberFormat.getCurrencyInstance().format(room.getRate()));
			Console.printDivider();

			boolean verify = false;
			String confirm = Console.getInputFromUser("Correct? Y (Yes) or N (No)");
			if (Console.validateInputTrueFalse(confirm))
				verify = Console.stringToBool(confirm);

			if (verify) {
				roomList.add(room);
				// Sort them according to room number
				roomList.sort((o1, o2) -> o1.getRoomNumber().compareToIgnoreCase(o2.getRoomNumber()));
				Console.print(room.getRoomType() + " Room Created.");
				updateRoomList();
			}
		}
		Console.enterToContinue();
	}

	/**
	 * Update a room.
	 */
	private void UpdateRoom() {
		Console.printTitle("Update Room Details");
		boolean found = false;
		String roomNumber = Console.getInputFromUser("Room No.").trim();

		if (!roomNumber.isEmpty()) {
			for (Room room : roomList) {
				if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
					if ((room.getAvailability().toUpperCase()).equals("OCCUPIED")
							|| (room.getAvailability().toUpperCase()).equals("RESERVED")) {
						Console.print("You cannot update a room that is " + room.getAvailability());
						Console.enterToContinue();
						return;
					} else {
						found = true;
						String wifi = Console.getInputFromUser("WiFi (" + Console.booleanToYesNo(room.isWifi()) + ")");
						boolean withWifi = false,withSmoke = false;
						if (Console.validateInputTrueFalse(wifi))
							withWifi = Console.stringToBool(wifi);
						String smoking = Console
								.getInputFromUser("Smoking (" + Console.booleanToYesNo(room.isSmoking()) + ")");
						if (Console.validateInputTrueFalse(smoking))
							room.setSmoking(Console.stringToBool(smoking));
						Console.print("Availability Status: (" + room.getAvailability() + ")");
						for (int i = 0; i < AvailabilityStatus.values().length; i++)
							System.out.print("(" + (i + 1) + ") " + AvailabilityStatus.values()[i].getStatus() + " ");
						System.out.println();
						int option = Console.getOptionFromUser();
						if (option == 2) {
							Console.print("You cannot update a room to occupied.");
						} else if (option == 3) {
							Console.print("You cannot update a room to Reserved.");
						} else {
							String roomAvaliable = null;
							if (option > 0 && option <= AvailabilityStatus.values().length)
								roomAvaliable = AvailabilityStatus.values()[option - 1].getStatus();
							Console.printDivider();
							System.out.format("%-18s: %s\n", "Room No.", room.getRoomNumber());
							System.out.format("%-18s: %s\n", "Room Type", room.getRoomType());
							System.out.format("%-18s: %s\n", "Bed Type", room.getBedType());
							System.out.format("%-18s: %d\n", "No. of Beds", room.getNumOfBeds());
							System.out.format("%-18s: %d\n", "Max. Occupants", room.getMaxOccupants());
							System.out.format("%-18s: %s\n", "WiFi", Console.booleanToYesNo(withWifi));
							System.out.format("%-18s: %s\n", "Smoking", Console.booleanToYesNo(withSmoke));
							System.out.format("%-18s: %s\n", "Status", roomAvaliable);
							System.out.format("%-18s: %s\n", "Base Rate",
									NumberFormat.getCurrencyInstance().format(room.getRate()));
							Console.printDivider();

							boolean verify = false;
							String confirm = Console.getInputFromUser("Correct? Y (Yes) or N (No)");
							if (Console.validateInputTrueFalse(confirm))
								verify = Console.stringToBool(confirm);
							else
								return;

							if (verify) {
								if (Console.validateInputTrueFalse(wifi))
									room.setWifi(Console.stringToBool(wifi));
								if (Console.validateInputTrueFalse(smoking))
									room.setSmoking(Console.stringToBool(smoking));
								room.setAvailability(AvailabilityStatus.values()[option - 1].getStatus());
								Console.print("Room " + room.getRoomNumber() + " updated.");
								updateRoomList();
							} else {
								Console.print("Invalid Option");
								Console.enterToContinue();
								return;
							}
						}
					}
				}
			}
			if (!found)
				Console.print("Sorry, no such room number.");
		}
		Console.enterToContinue();
	}

	/**
	 * Update all room types rates.
	 */
	private void UpdateRoomRates() {
		double singleRate = Console.getDoubleFromUser("Single Room Rate (" + Storage.singleRate + ")");
		if (singleRate > 0.0)
			Storage.singleRate = singleRate;
		double singleSeaRate = Console
				.getDoubleFromUser("Single Room with Sea View Rate (" + Storage.singleSeaRate + ")");
		if (singleSeaRate > 0.0)
			Storage.singleSeaRate = singleSeaRate;
		double singleGardenRate = Console
				.getDoubleFromUser("Single Room with Garden View Rate (" + Storage.singleGardenRate + ")");
		if (singleGardenRate > 0.0)
			Storage.singleGardenRate = singleGardenRate;
		double doubleRate = Console.getDoubleFromUser("Double Room Rate (" + Storage.doubleRate + ")");
		if (doubleRate > 0.0)
			Storage.doubleRate = doubleRate;
		double doubleSeaRate = Console
				.getDoubleFromUser("Double Room with Sea View Rate (" + Storage.doubleSeaRate + ")");
		if (doubleSeaRate > 0.0)
			Storage.doubleSeaRate = doubleSeaRate;
		double doubleGardenRate = Console
				.getDoubleFromUser("Double Room with Garden View Rate (" + Storage.doubleGardenRate + ")");
		if (doubleSeaRate > 0.0)
			Storage.doubleGardenRate = doubleGardenRate;
		double deluxeRate = Console.getDoubleFromUser("Deluxe Room Rate (" + Storage.deluxeRate + ")");
		if (deluxeRate > 0.0)
			Storage.deluxeRate = deluxeRate;
		double deluxeSeaRate = Console
				.getDoubleFromUser("Deluxe Room with Sea View Rate (" + Storage.deluxeSeaRate + ")");
		if (deluxeSeaRate > 0.0)
			Storage.deluxeSeaRate = deluxeSeaRate;
		double deluxeGardenRate = Console
				.getDoubleFromUser("Deluxe Room with Garden View Rate (" + Storage.deluxeGardenRate + ")");
		if (deluxeGardenRate > 0.0)
			Storage.deluxeGardenRate = deluxeGardenRate;
		double vipSuiteRate = Console.getDoubleFromUser("VIP Suite Rate (" + Storage.vipSuiteRate + ")");
		if (vipSuiteRate > 0.0)
			Storage.vipSuiteRate = vipSuiteRate;
		double vipSuiteSeaRate = Console
				.getDoubleFromUser("VIP Suite with Sea View Rate (" + Storage.vipSuiteSeaRate + ")");
		if (vipSuiteSeaRate > 0.0)
			Storage.vipSuiteSeaRate = vipSuiteSeaRate;
		double vipSuiteGardenRate = Console
				.getDoubleFromUser("VIP Suite with Garden View Rate (" + Storage.vipSuiteGardenRate + ")");
		if (vipSuiteGardenRate > 0.0)
			Storage.vipSuiteGardenRate = vipSuiteGardenRate;
		Console.updateHotelProperties();

		// Update rates for all rooms
		for (Room room : roomList) {
			switch (room.getRoomType()) {
			case "Single":
				if (room.getView().equalsIgnoreCase(View.SEA.getView()))
					room.setRate(Storage.singleSeaRate);
				else if (room.getView().equalsIgnoreCase(View.GARDEN.getView()))
					room.setRate(Storage.singleGardenRate);
				else
					room.setRate(Storage.singleRate);
				break;
			case "Double":
				if (room.getView().equalsIgnoreCase(View.SEA.getView()))
					room.setRate(Storage.doubleSeaRate);
				else if (room.getView().equalsIgnoreCase(View.GARDEN.getView()))
					room.setRate(Storage.doubleGardenRate);
				else
					room.setRate(Storage.doubleRate);
				break;
			case "Deluxe":
				if (room.getView().equalsIgnoreCase(View.SEA.getView()))
					room.setRate(Storage.deluxeSeaRate);
				else if (room.getView().equalsIgnoreCase(View.GARDEN.getView()))
					room.setRate(Storage.deluxeGardenRate);
				else
					room.setRate(Storage.deluxeRate);
				break;
			case "VIP Suite":
				if (room.getView().equalsIgnoreCase(View.SEA.getView()))
					room.setRate(Storage.vipSuiteSeaRate);
				else if (room.getView().equalsIgnoreCase(View.GARDEN.getView()))
					room.setRate(Storage.vipSuiteGardenRate);
				else
					room.setRate(Storage.vipSuiteRate);
				break;
			}
		}
		updateRoomList();
		Console.enterToContinue();
	}

	/**
	 * List all rooms and their current information.
	 */
	private void ListAllRooms() {
		Console.printTitle("List All Rooms");
		if (!roomList.isEmpty()) {
			printRoomList(roomList);
		} else {
			Console.print("No Rooms Found.");
		}
		Console.enterToContinue();
	}

	/**
	 * Update room status.
	 * 
	 * @param roomNumber
	 *            room number
	 * @param status
	 *            status to be updated
	 * @return true if updated, otherwise false
	 */
	public static boolean updateRoomStatus(String roomNumber, String status) {
		boolean updated = false;
		for (Room room : roomList) {
			if (room.getRoomNumber().equalsIgnoreCase(roomNumber)) {
				room.setAvailability(status);
				updated = true;
			}
		}
		// updateRoomList();
		return updated;
	}

	/**
	 * Retrieve all vacant rooms.
	 * 
	 * @return list of Room objects
	 */
	public static List<Room> getAllVacantRooms() {
		return roomList.stream()
				.filter(room -> room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
				.collect(Collectors.toList());
	}

	/**
	 * Retrieve a room based by room number.
	 * 
	 * @param roomNumber
	 *            room number
	 * @return Room object if found, otherwise null
	 */
	public static Room searchRoomByRoomNumber(String roomNumber) {
		return roomList.stream().filter(room -> room.getRoomNumber().equalsIgnoreCase(roomNumber)).findFirst()
				.orElse(null);
	}

	/**
	 * Print out room list in a table format.
	 * 
	 * @param roomList
	 *            room list
	 */
	public static void printRoomList(List<Room> roomList) {
		System.out.println();
		TableBuilder builder = new TableBuilder("Room No.", "Name", "Room Type", "Bed Type", "Beds", "Max.", "Wifi",
				"View", "Smoking", "Availability", "Rate");
		for (Room room : roomList) {
			builder.addRow(room.getRoomNumber().toUpperCase(), room.getRoomName().toUpperCase(),
					room.getRoomType().toUpperCase(), room.getBedType().toUpperCase(),
					String.valueOf(room.getNumOfBeds()), String.valueOf(room.getMaxOccupants()),
					Console.booleanToYesNo(room.isWifi()).toUpperCase(), room.getView().toUpperCase(),
					Console.booleanToYesNo(room.isSmoking()).toUpperCase(), room.getAvailability().toUpperCase(),
					NumberFormat.getCurrencyInstance().format(room.getRate()));
		}
		builder.print();
	}

	public static void updateRoomList() {
		Storage.storeRoomList(roomList);
	}
}
