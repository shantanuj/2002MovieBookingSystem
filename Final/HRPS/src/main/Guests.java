package main;
import model.Storage;
import model.Guest;

import java.util.List;
import java.util.stream.Collectors;

public class Guests {
    public static List<Guest> guestList;
    public static int counter = 1;

    public Guests() {
        // Get largest incremental counter and set to +1
        guestList.stream().filter(guest -> guest.getGuestId() >= counter)
                .forEach(guest -> counter = guest.getGuestId() + 1);

        int option = -1;
        while (option != 0) {
            Console.printTitle("Guest Menu");
            Console.print("(1) Create Guest");
            Console.print("(2) Update Guest");
            Console.print("(3) Search Guest");
            Console.print("(4) List All Guest");
            Console.print("(0) Return to Main Menu");

            option = Console.getOptionFromUserRefresh();

            switch (option) {
                case 1:
                    CreateGuest();
                    break;
                case 2:
                    UpdateGuest();
                    break;
                case 3:
                    SearchGuest();
                    break;
                case 4:
					ListAllGuest();
					break;
                default:
            }
        }
    }

    /**
     * Create a guest
     */
    private void CreateGuest() {
        Console.printTitle("Create Guest");
        Guest guest = new Guest();
        guest.setGuestId(counter);

        guest.setName(Console.getInputFromUser("Name"));
        guest.setCreditCard(Console.getInputFromUser("Credit Card No. (16 digits)"));
        guest.setAddress(Console.getInputFromUser("Address"));
        guest.setCountry(Console.getInputFromUser("Country"));
        guest.setGender(Console.translateToGender(Console.getInputFromUser("Gender (Male/Female)")));
        guest.setIdentity(Console.getInputFromUser("Identity No."));
        guest.setNationality(Console.getInputFromUser("Nationality"));
        guest.setContactNo(Console.getInputFromUser("Contact No."));

        System.out.println();
        Console.print("You have entered the following details:");
        Console.printDivider();
        System.out.format("** %-18s: %s\n", "Name", guest.getName());
        System.out.format("** %-18s: %s\n", "Credit Card", guest.getCreditCard());
        System.out.format("** %-18s: %s\n", "Address", guest.getAddress());
        System.out.format("** %-18s: %s\n", "Country", guest.getCountry());
        System.out.format("** %-18s: %s\n", "Gender", guest.getGender());
        System.out.format("** %-18s: %s\n", "Identity No.", guest.getIdentity());
        System.out.format("** %-18s: %s\n", "Nationality", guest.getNationality());
        System.out.format("** %-18s: %s\n", "Contact No", guest.getContactNo());
        Console.printDivider();
        boolean verify = Console.stringToBool(Console.getInputFromUser("Correct? Y (yes) or N (no)"));

        if (verify) {
            guestList.add(guest);
            updateGuestList();
            counter++;
            Console.print("Guest Created.");
        }

        Console.enterToContinue();
    }

    /**
     * Update a guest.
     */
    private void UpdateGuest() {
        Console.printTitle("Update Guest");
        int option = Console.getIntegerFromUser("Select Guest Id");
        Guest updateGuest = guestList.stream().filter(guest -> guest.getGuestId() == option).findFirst().orElse(null);

        if (updateGuest != null) {
            String name = Console.getInputFromUser("Name (" + updateGuest.getName() + ")");
            String creditCard = Console.getInputFromUser("Credit Card No. (" + updateGuest.getCreditCard() + ")");
            String address = Console.getInputFromUser("Address (" + updateGuest.getAddress() + ")");
            String country = Console.getInputFromUser("Country (" + updateGuest.getCountry() + ")");
            String gender = Console.getInputFromUser("Gender (Male/Female)");
            String identity = Console.getInputFromUser("Identity No. (" + updateGuest.getIdentity() + ")");
            String nationality = Console.getInputFromUser("Nationality (" + updateGuest.getNationality() + ")");
            String contact = Console.getInputFromUser("Contact No. (" + updateGuest.getContactNo() + ")");

            System.out.println();
            Console.print("You have entered the following details:");
            Console.printDivider();
            System.out.format("** %-18s: %s\n", "Name", name);
            System.out.format("** %-18s: %s\n", "Credit Card", creditCard);
            System.out.format("** %-18s: %s\n", "Address", address);
            System.out.format("** %-18s: %s\n", "Country", country);
            System.out.format("** %-18s: %s\n", "Gender", gender);
            System.out.format("** %-18s: %s\n", "Identity No.", identity);
            System.out.format("** %-18s: %s\n", "Nationality", nationality);
            System.out.format("** %-18s: %s\n", "Contact No.", contact);
            Console.printDivider();
            boolean verify = Console.stringToBool(Console.getInputFromUser("Correct? Y (yes) or N (no) "));

            if (verify) {
                if (!name.isEmpty())
                    updateGuest.setName(name);
                if (!creditCard.isEmpty())
                    updateGuest.setCreditCard(creditCard);
                if (!address.isEmpty())
                    updateGuest.setAddress(address);
                if (!country.isEmpty())
                    updateGuest.setCountry(country);
                if (!gender.isEmpty())
                    updateGuest.setGender(Console.translateToGender(gender));
                if (!identity.isEmpty())
                    updateGuest.setIdentity(identity);
                if (!nationality.isEmpty())
                    updateGuest.setNationality(nationality);
                if (!nationality.isEmpty())
                    updateGuest.setContactNo(contact);

                updateGuestList();
                Console.print("Guest Updated.");
            }
        } else {
            System.out.println();
            Console.print("Sorry, no such Guest ID.");
        }

        Console.enterToContinue();
    }

    /**
     * Search guest by id.
     * @param id guest id
     * @return Guest object if found, otherwise null
     */
    public static Guest searchGuestsById(int id) {
        return guestList.stream().filter(guest -> guest.getGuestId() == id)
                .findFirst().orElse(null);
    }

    /**
     * Search guests by name, checking if name contains search input.
     * @param search search input
     * @return a list of Guest objects
     */
    public static List<Guest> searchGuestsByName(String search) {
        List<Guest> results = guestList.stream().filter(guest ->
                guest.getName().toLowerCase().matches("(?i).*" + search.toLowerCase() + ".*"))
                .collect(Collectors.toList());
        if (!results.isEmpty())
            return results;
        else
            return null;
    }

    /**
     * Search guests by name and display results, disallowing search to be empty.
     */
    private void SearchGuest() {
        Console.printTitle("Search Guest");
        String search = Console.getInputFromUser("Search By Name").trim();
        if (!search.isEmpty()) {
            List<Guest> results = searchGuestsByName(search);
            if (results != null) {
                printGuestList(results);
            } else {
                Console.print("Sorry, no results found.");
            }
        }
        Console.enterToContinue();
    }

    
    private void ListAllGuest() {
        Console.printTitle("List All Guests");
        if (!guestList.isEmpty()) {
        	printGuestList(guestList);
        } else {
            Console.print("No Guest Found.");
            System.out.println();
        }
        Console.enterToContinue();
    }
    
    /**
     * Print guest list in a table format.
     * @param guestList guest list
     */
    public static void printGuestList(List<Guest> guestList) {
        System.out.println();
        TableBuilder builder = new TableBuilder("No.", "Name", "Gender", "Country", "Nationality",
        		"Identity No.","Contact No","Address", "Credit Card No.");
        for (Guest guest: guestList) {
            builder.addRow(String.valueOf(guest.getGuestId()),
                    guest.getName().toUpperCase(), guest.getGender().toUpperCase(),
                    guest.getCountry().toUpperCase(), guest.getNationality().toUpperCase(),
                    guest.getIdentity().toUpperCase(),guest.getContactNo().toUpperCase(),
                    guest.getAddress().toUpperCase(), guest.getCreditCard().toUpperCase());
        }
        builder.print();
    }

    /**
     * Print guest details
     * @param id guest id
     */
    public static void guestDetails(int id) {
    	Console.printDivider();
    	System.out.format("** %-18s: %s\n", "Name",
    			Guests.searchGuestsById(id).getName());
    	System.out.format("** %-18s: %s\n", "Gender",
    			Guests.searchGuestsById(id).getGender());
    	System.out.format("** %-18s: %s\n", "Nationality",
    			Guests.searchGuestsById(id).getNationality());
    	System.out.format("** %-18s: %s\n", "Identity No.",
    			Guests.searchGuestsById(id).getIdentity());
    	System.out.format("** %-18s: %s\n", "Contact No.",
    			Guests.searchGuestsById(id).getContactNo());
    	System.out.format("** %-18s: %s\n", "Billing Address",
    			Guests.searchGuestsById(id).getAddress());
    }
    public static void updateGuestList() {
        Storage.storeGuestList(guestList);
    }
}
