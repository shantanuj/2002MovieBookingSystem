package main;
import model.Storage;
import model.Reservation;
import model.RoomServiceItem;
import model.RoomServiceOrderItem;
import model.RoomServiceOrderStatus;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
	public static List<RoomServiceItem> roomServiceItemList;

    /**
     * Constructor to allow user to edit room service menu and items
     */
	public RoomService() {
		roomServiceItemList.sort((item1, item2) -> Double.compare(item2.getPrice(), item1.getPrice()));

		int option = -1;
		while (option != 0) {
			Console.printTitle("Room Service Menu");
			Console.print("(1) Create Item");
			Console.print("(2) Update Item");
			Console.print("(3) Remove Item");
			Console.print("(4) List All Items");
			Console.print("(5) Order Room Service");
			Console.print("(6) List Room Service Orders");
			Console.print("(7) Update Room Service Order Status");
			Console.print("(0) Back to Main Menu");

			option = Console.getOptionFromUserRefresh();

			switch (option) {
			case 1:
				CreateItem();
				break;
			case 2:
				UpdateItem();
				break;
			case 3:
				RemoveItem();
				break;
			case 4:
				ListItems();
				break;
			case 5:
				OrderRoomService();
				break;
			case 6:
				ListRoomServiceOrder();
				break;
			case 7:
				UpdateRoomServiceOrderStatus();
				break;

			default:
			}
		}
	}

	  /**
     * Allows user to create a new room service item
     */
	private void CreateItem() {
		Console.printTitle("Create Item");
		RoomServiceItem item = new RoomServiceItem();
		item.setName(Console.getInputFromUser("Name"));
		item.setDescription(Console.getInputFromUser("Description"));
		item.setPrice(Console.getDoubleFromUser("Price"));

		Console.printTitle("You have entered the following details:");
		Console.printTitle("Name: " + item.getName() + "\n** Description: " + item.getDescription() + "\n** Price: "
				+ NumberFormat.getCurrencyInstance().format(item.getPrice()));
		boolean verify = Console.stringToBool(Console.getInputFromUser("Correct? Y (yes) or N (no)"));

		if (verify) {
			roomServiceItemList.add(item);
			updateRoomServiceItemList();

			System.out.println();
			Console.print("Item Created.");
		}

		Console.enterToContinue();
	}

	/**
	 * To update the item status
	 */
	private void UpdateItem() {
		Console.printTitle("Update Item");
		if (!roomServiceItemList.isEmpty()) {
			printRoomServiceItemList(roomServiceItemList);

			int itemId = Console.getIntegerFromUser("Item No.");

			if (itemId > 0 && itemId <= roomServiceItemList.size()) {
				RoomServiceItem updateItem = roomServiceItemList.get(itemId - 1);

				updateItem.setName(Console.getInputFromUser("Name (" + updateItem.getName() + ")"));
				updateItem
						.setDescription(Console.getInputFromUser("Description (" + updateItem.getDescription() + ")"));
				updateItem.setPrice(Console.getDoubleFromUser("Price (" + updateItem.getPrice() + ")"));

				updateRoomServiceItemList();

				Console.print("Item Updated.");
			} else {
				;
				Console.print("Sorry, no such Item No.");
			}
		} else {
			Console.print("No Items Found.");
		}
		Console.enterToContinue();
	}

	/**
	 * To remove item
	 */
	private void RemoveItem() {
		Console.printTitle("Remove Item");
		if (!roomServiceItemList.isEmpty()) {
			printRoomServiceItemList(roomServiceItemList);

			int itemId = Console.getIntegerFromUser("Item No.");

			if (itemId > 0 && itemId <= roomServiceItemList.size()) {
				roomServiceItemList.remove(itemId - 1);
				updateRoomServiceItemList();

				Console.print("Item Removed.");
			} else {
				Console.print("Sorry, no such Item No.");
			}
		} else {
			Console.print("No Items Found.");
		}
		Console.enterToContinue();
	}

	/**
	 * List All items
	 */
	private void ListItems() {
		Console.printTitle("List All Items");
		if (!roomServiceItemList.isEmpty()) {
			printRoomServiceItemList(roomServiceItemList);
		} else {
			Console.print("No Items Found.");
		}
		Console.enterToContinue();
	}

	/**
     * Order room service
     */
	private void OrderRoomService() {
		Console.printTitle("Order Room Service");

		if (!roomServiceItemList.isEmpty()) {
			List<Reservation> checkinReservations = Reservations.GetCheckinReservations();
			if (!checkinReservations.isEmpty()) {
				Reservations.printReservationList(checkinReservations);
				int rId = Console.getIntegerFromUser("Reservation ID");
				Reservation orderReverservation = checkinReservations.stream()
						.filter(reservation -> reservation.getId() == rId).findFirst().orElse(null);
				if (orderReverservation != null) {
					List<RoomServiceOrderItem> orders = orderReverservation.getOrders();
					if (orders == null) {
						orders = new ArrayList<>();
					}
					printRoomServiceItemList(roomServiceItemList);

					int itemId = Console.getIntegerFromUser("Item No.");
					if (itemId > 0 && itemId <= roomServiceItemList.size()) {
						RoomServiceItem item = roomServiceItemList.get(itemId - 1);
						int quantity = Console.getIntegerFromUser("Quantity");
						if (quantity >= 1) {

							RoomServiceOrderItem orderItem = new RoomServiceOrderItem();
							orderItem.setName(item.getName());
							orderItem.setDescription(item.getDescription());
							orderItem.setPrice(item.getPrice());
							orderItem.setQuantity(quantity);
							orderItem.setPreparation(Console.getInputFromUser("Preparation"));
							orderItem.setStatus(RoomServiceOrderStatus.CONFIRMED.getStatus());
							orders.add(orderItem);
							orderReverservation.setOrders(orders);
							printOrderList(orders);
							Console.print("Item Updated.");
						} else {
							Console.print("Sorry, quantity is 0");
						}
					} else {
						Console.print("Sorry, no such Item No.");
					}
				} else {
					Console.print("Sorry, no such reservation.");
				}
			} else {
				Console.print("Sorry, no available checked-in reservations currently.");
			}
		} else {
			Console.print("No Items Found.");
		}

		Console.enterToContinue();
	}

	/**
     * List room service ordered
     */
	private void ListRoomServiceOrder() {
		Console.printTitle("List Room Service Orders");
		List<Reservation> checkinReservations = Reservations.GetCheckinReservations();
		if (!checkinReservations.isEmpty()) {
            checkinReservations.stream().filter(reservation -> reservation.getOrders() != null)
                    .forEach(reservation -> {
                        Console.printTitle("Room Service Order - ID No.: " + reservation.getId());
                        System.out.format("** %-18s: %s\n", "Room No.", reservation.getRoomNumber());
                        System.out.format("** %-18s: %s\n", "Guest",
                                Guests.searchGuestsById(
                                        reservation.getGuestId()).getName());
                        Console.printDivider();
				printOrderList(reservation.getOrders());
			});
		} else {
			Console.print("Sorry, no available checked-in reservations currently.");
		}
		Console.enterToContinue();
	}

	/**
     * Update room service status
     */
	private void UpdateRoomServiceOrderStatus() {
		Console.printTitle("Update Room Service Order Status");
		List<Reservation> checkinReservations = Reservations.GetCheckinReservations();
		int rId = Console.getIntegerFromUser("Reservation ID.");
		if (!checkinReservations.isEmpty()) {
			Reservation orderReverservation = checkinReservations.stream()
					.filter(reservation -> reservation.getId() == rId).findFirst().orElse(null);

			if (orderReverservation != null) {
				if (orderReverservation.getOrders() != null) {
					List<RoomServiceOrderItem> orders = orderReverservation.getOrders();
					for (RoomServiceOrderItem item : orders) {
						if (!item.getStatus().toUpperCase().equals("CONFIRMED")) {
							Console.print(item.getName() + " x " + item.getQuantity());
							Console.print("Preparation: " + item.getPreparation());
							Console.print("Status (" + item.getStatus() + "): ");
							for (int i = 0; i < RoomServiceOrderStatus.values().length; i++) {
								System.out.print(
										"(" + (i + 1) + ") " + RoomServiceOrderStatus.values()[i].getStatus() + " ");
							}
							System.out.println();
							int select = Console.getOptionFromUser();
							if (select >= 1 && select <= 3) {
								item.setStatus(RoomServiceOrderStatus.values()[select - 1].getStatus());
								orderReverservation.setOrders(orders);
								printOrderList(orderReverservation.getOrders());
								System.out.println();
								Console.print("Item Updated.");
							} else
								Console.print("Invalid Option");
							Console.print("");
						}
					}

				} else {
					Console.print("No orders for this reservation.");
				}
			} else {
				Console.print("Sorry, no service ordered for the reservation");
			}
		} else {
			Console.print("Sorry, no available checked-in reservations currently.");
		}
		Console.enterToContinue();
	}

	/**
     * Get room service list
     * @param roomServiceItemList room service Item List
     */
	public static void printRoomServiceItemList(List<RoomServiceItem> roomServiceItemList) {
		System.out.println();
		int i = 1;
		TableBuilder builder = new TableBuilder("No.", "Name", "Price", "Description");
		for (RoomServiceItem item : roomServiceItemList) {
			builder.addRow(String.valueOf(i), item.getName().toUpperCase(),
					NumberFormat.getCurrencyInstance().format(item.getPrice()), item.getDescription().toUpperCase());
			i++;
		}
		builder.print();
	}

	/**
     * Get room service list ordered
     * @param orders room service ordered
     */
	public static void printOrderList(List<RoomServiceOrderItem> orders) {
		System.out.println();
		TableBuilder builder = new TableBuilder("Name", "Price", "Quantity", "Preparation", "Status");
		for (RoomServiceOrderItem item : orders) {
			builder.addRow(item.getName().toUpperCase(), NumberFormat.getCurrencyInstance().format(item.getPrice()),
					String.valueOf(item.getQuantity()), item.getPreparation().toUpperCase(),
					item.getStatus().toUpperCase());
		}
		builder.print();
	}

	public static void updateRoomServiceItemList() {
		Storage.storeRoomServiceItemList(roomServiceItemList);
	}
}
