package main;
import model.*;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CheckInOut {

    public void CheckIn() {
    	
    	/**
         * Allow user to process guest check-in
         */
        Console.printTitle("Check In");
        List<Reservation> reservedReservations = Reservations.reservationList.stream()
                .filter(reservation -> reservation.getStatus()
                        .equalsIgnoreCase(ReservationStatus.RESERVED.getStatus()) &&
                Console.isNowBetweenTwoDates(reservation.getCheckIn(), reservation.getCheckOut()))
                .collect(Collectors.toList());

        if (!reservedReservations.isEmpty()) {
            Reservations.printReservationList(reservedReservations);
            int reservationId = Console.getIntegerFromUser("Reservation ID");
            boolean found = false;
            boolean updated = false;
            for (Reservation reservation : Reservations.reservationList) {
                if (reservation.getId() == reservationId
                        && reservedReservations.contains(reservation)) {
                    found = true;
                    String confirm = Console.getInputFromUser("Confirm Check-In? Y (Yes) or N (No)");
                    boolean verify = false;
                    if (Console.validateInputTrueFalse(confirm))
                        verify = Console.stringToBool(confirm);

                    if (verify) {
                        reservation.setStatus(ReservationStatus.CHECKIN.getStatus());
                        Rooms.updateRoomStatus(reservation.getRoomNumber(),
                                AvailabilityStatus.OCCUPIED.getStatus());
                        Rooms.updateRoomList();
                        Console.print("Reservation #" + reservation.getId() + " checked in.");
                        updated = true;
                    }
                }
            }
            if (updated) Reservations.updateReservationList();
            if (!found) Console.print("Sorry, no such reservation available for check in.");
        } else {
            Console.print("Sorry, no reserved reservations available for Check-In.");
        }
        Console.enterToContinue();
    }

    /**
     * Allow user to process guest check-out
     */
    public void CheckOut() {
        Console.printTitle("Check Out");
        List<Reservation> checkinReservations = Reservations.reservationList.stream()
                .filter(reservation -> reservation.getStatus()
                    .equalsIgnoreCase(ReservationStatus.CHECKIN.getStatus()))
                .collect(Collectors.toList());
        if (!checkinReservations.isEmpty()) {
            Reservations.printReservationList(checkinReservations);
            int rId = Console.getIntegerFromUser("Reservation ID");
            Reservation checkoutReservation = checkinReservations.stream()
                    .filter(reservation -> reservation.getId() == rId)
                    .findFirst().orElse(null);

            if (checkoutReservation != null) {
            	Date initialDate = checkoutReservation.getCheckOut();
            	checkoutReservation.setCheckOut(new Date());
            	printReservationDetails("Reservation Details - ID No.: " 
            			+ checkoutReservation.getId(), checkoutReservation);
            	checkoutReservation.setCheckOut(initialDate);
            	
                boolean confirm = Console.stringToBool(
                        Console.getInputFromUser("Confirm Check-Out? Y (yes) or N (no)"));
                if (confirm) {
                    double discount;
                    String mode = null;

                    Console.print("Payment mode: ");
                    for (int i = 0; i < PaymentMode.values().length; i++) {
                        System.out.print("(" + (i+1) + ") " + PaymentMode.values()[i].getMode() + " ");
                    }
                    System.out.println();
                    int option = Console.getOptionFromUser();
                    if (option > 0 && option <= PaymentMode.values().length) {
                        mode = PaymentMode.values()[option - 1].getMode();
                        
                        try {
                            discount = Double.parseDouble(Console.getInputFromUser("Discount"));
                        } catch (Exception e) {
                            discount = 0.0;
                        }
                        
                        Date now = new Date();
                        boolean updated = Reservations.updateCheckOutReservation(
                                checkoutReservation.getId(), now);
                        checkoutReservation.setCheckOut(now);
                        checkoutReservation.setStatus(ReservationStatus.CHECKOUT.getStatus());

                        Payment payment = new Payment();
                        payment.setId(new Date().getTime());
                        payment.setAmount(checkoutReservation.getTotalBill() - discount);
                        payment.setMode(mode);
                        payment.setBillingAddr(Guests
                        		.searchGuestsById(checkoutReservation.getGuestId())
                        		.getAddress());
                        payment.setStatus("Success");
                        checkoutReservation.setPayment(payment);

                        if (updated) {
                            updated = Rooms.updateRoomStatus(checkoutReservation.getRoomNumber(),
                                    AvailabilityStatus.VACANT.getStatus());
                            if (updated) {
                                System.out.println();
                                printReservationDetails("Bill Invoice - Reservation No.: "
                                        + checkoutReservation.getId(), checkoutReservation);
                                System.out.format("** %-18s: %-15s\t %15s\n", "Discount", "",
                                        NumberFormat.getCurrencyInstance().format(discount));
                                Console.printDivider();
                                System.out.format("** %-18s: %-15s\t %15s\n", "Amount Paid", "",
                                        NumberFormat.getCurrencyInstance().format(
                                                checkoutReservation.getPayment().getAmount()));
                                Console.printDivider();
                                System.out.format("** %-18s: %s\n", "Payment Mode",
                                        checkoutReservation.getPayment().getMode());
                                if (option == 2){
                                System.out.format("** %-18s: %s\n","Charge To",
                                        Guests.searchGuestsById(
                                        		checkoutReservation.getGuestId()).getCreditCard());
                                
                                System.out.format("** %-18s: %s\n", "Billing Address",
                                		Guests.searchGuestsById(
                                				checkoutReservation.getGuestId()).getAddress());
                                }
                                System.out.format("** %-18s: %s\n","Payment Status",
                                        checkoutReservation.getPayment().getStatus());
                                Console.printDivider();
                                System.out.println();
                                Reservations.updateReservationList();
                            }
                        }
                    } else {
                        Console.print("Invalid Payment mode");
                    }
                }
            } else {
                Console.print("Sorry, no such reservation.");
            }
        } else {
            Console.print("Sorry, currently no Checked-In reservations.");
        }
        Console.enterToContinue();
    }

    /**
     * Display details of  reservations to user
     * @param title passed as String value to display Reservation id and details
     * @param reservation passed as object of Reservation to pass details of this reservation.
     */
    public static void printReservationDetails(String title, Reservation reservation) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yy, hh:mm aaa");
        Console.printTitle(title);
        System.out.format("** %-18s: %s\n", "Name",
                Guests.searchGuestsById(reservation.getGuestId()).getName());
        System.out.format("** %-18s: %s\n", "Room", reservation.getRoomNumber() + " - "
                + Rooms.searchRoomByRoomNumber(
                reservation.getRoomNumber()).getRoomName());
        System.out.format("** %-18s: %s\n", "Contact No.",
        		Guests.searchGuestsById(reservation.getGuestId()).getContactNo());
        System.out.format("** %-18s: %s\n", "Date of Check-In",
                dateFormat.format(reservation.getCheckIn()));
        System.out.format("** %-18s: %s\n", "Date of Check-Out",
                dateFormat.format(reservation.getCheckOut()));
        System.out.format("** %-18s: %s\n", "Status", reservation.getStatus());
        System.out.format("** %-18s: %s\n", "Total Days", reservation.numOfWeekdays() 
        		+ reservation.numOfWeekends());
        System.out.format("** %-18s: %s\n", "No. of Adults", reservation.getNumOfAdults());
        System.out.format("** %-18s: %s\n", "No. of Children", reservation.getNumOfChildren());

        Console.printDivider();
        System.out.format("** %-18s: %s\n", "Base Rate",
                NumberFormat.getCurrencyInstance().format(reservation.getBaseRate()) + " / day");

        System.out.format("** %-18s: %-2s x %-10s\t %15s\n", "Weekday Total", reservation.numOfWeekdays(),
                NumberFormat.getCurrencyInstance().format(reservation.getBaseRate()),
                NumberFormat.getCurrencyInstance().format(reservation.weekdaysTotal()));
        System.out.format("** %-18s: %-2s x %-10s\t %15s\n", "Weekend Total", reservation.numOfWeekends(),
                NumberFormat.getCurrencyInstance().format((1.05)*reservation.getBaseRate()),
                NumberFormat.getCurrencyInstance().format(reservation.weekendsTotal()));
        Console.printDivider();

        if (reservation.getOrders() != null) {
            List<RoomServiceOrderItem> deliveredOrder = reservation.getOrders().stream().filter(item ->
                    item.getStatus().equalsIgnoreCase(RoomServiceOrderStatus.DELIVERED.getStatus()))
                    .collect(Collectors.toList());
            if (!deliveredOrder.isEmpty()) {
                for (RoomServiceOrderItem item : deliveredOrder) {
                    Console.print("** " + item.getName());
                    System.out.format("** %-22s x %-10s\t %15s\n",
                            NumberFormat.getCurrencyInstance().format(item.getPrice()),
                            String.valueOf(item.getQuantity()),
                            NumberFormat.getCurrencyInstance()
                                    .format(item.getQuantity() * item.getPrice()));
                }
                Console.printDivider();
            }
        }

        System.out.format("** %-18s: %-15s\t %15s\n", "Room Service", "",
                NumberFormat.getCurrencyInstance().format(reservation.getRoomServiceTotal()));
        Console.printDivider();
        System.out.format("** %-18s: %-15s\t %15s\n", "Sub Total", "",
                NumberFormat.getCurrencyInstance().format(reservation.getSubTotal()));
        System.out.format("** %-18s: %-15s\t %15s\n", "GST", "",
                NumberFormat.getCurrencyInstance().format(reservation.getGST()));
        Console.printDivider();
        System.out.format("** %-18s: %-15s\t %15s\n", "Total", "",
                NumberFormat.getCurrencyInstance().format(reservation.getTotalBill()));
        Console.printDivider();
    }
}
