package model;

import model.Guest;
import model.Reservation;
import model.RoomServiceItem;
import model.room.Room;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Storage {
    public static final String SINGLERATE = "single";
    public static double singleRate;
    public static final String SINGLESEARATE = "single.sea";
    public static double singleSeaRate;
    public static final String SINGLEGARDENRATE = "single.garden";
    public static double singleGardenRate;
    public static final String DOUBLERATE = "double";
    public static double doubleRate;
    public static final String DOUBLESEARATE = "double.sea";
    public static double doubleSeaRate;
    public static final String DOUBLEGARDENRATE = "double.garden";
    public static double doubleGardenRate;
    public static final String DELUXERATE = "deluxe";
    public static double deluxeRate;
    public static final String DELUXESEARATE = "deluxe.sea";
    public static double deluxeSeaRate;
    public static final String DELUXEGARDENRATE = "deluxe.garden";
    public static double deluxeGardenRate;
    public static final String VIPSUITERATE = "vipsuite";
    public static double vipSuiteRate;
    public static final String VIPSUITESEARATE = "vipsuite.sea";
    public static double vipSuiteSeaRate;
    public static final String VIPSUITEGARDENRATE = "vipsuite.garden";
    public static double vipSuiteGardenRate;

    /**
     * Retrieve properties from hotel.properties file.
     * @return properties, otherwise null
     */
    public static Properties getProperties() {
        String FILENAME = "hotel.properties";
        try {
            Properties properties = new Properties();
            InputStream input = new FileInputStream(FILENAME);
            properties.load(input);
            return properties;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Store properties to hotel.properties file.
     * @param properties properties
     */
    public static void storeProperties(Properties properties) {
        String FILENAME = "hotel.properties";
        try {
            OutputStream output = new FileOutputStream(FILENAME);
            properties.store(output, null);
        } catch (IOException e) {
            System.out.println("Unable to store into " + FILENAME + ": "
                    + e.getMessage());
        }
    }

    /**
     * Retrieve guest list from data/Guests.xml file.
     * @return a list of Guest objects
     */
    public static List<Guest> getGuestList() {
        String FILENAME = "data/Guests.xml";
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
            List<Guest> guestList = (List<Guest>) decoder.readObject();
            decoder.close();
            return guestList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Store guest list to data/Guests.xml file.
     * @param guestList a list of Guest objects
     */
    public static void storeGuestList(List<Guest> guestList) {
        String FILENAME = "data/Guests.xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(FILENAME));
            encoder.writeObject(guestList);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to store into " + FILENAME + ": "
                + e.getMessage());
        }
    }

    /**
     * Retrieve room list from data/Rooms.xml file.
     * @return a list of Room objects
     */
    public static List<Room> getRoomList() {
        String FILENAME = "data/Rooms.xml";
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
            List<Room> roomList = (List<Room>) decoder.readObject();
            decoder.close();
            return roomList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Store room list to data/Rooms.xml file.
     * @param roomList a list of Room objects
     */
    public static void storeRoomList(List<Room> roomList) {
        String FILENAME = "data/Rooms.xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(FILENAME));
            encoder.writeObject(roomList);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to store into " + FILENAME + ": "
                    + e.getMessage());
        }
    }

    /**
     * Retrieve reservation list from data/Reservations.xml file.
     * @return a list of Reservation objects
     */
    public static List<Reservation> getReservationList() {
        String FILENAME = "data/Reservations.xml";
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
            List<Reservation> reservationList = (List<Reservation>) decoder.readObject();
            decoder.close();
            return reservationList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Store reservation list to data/Reservations.xml file.
     * @param reservationList a list of Reservation objects
     */
    public static void storeReservationList(List<Reservation> reservationList) {
        String FILENAME = "data/Reservations.xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(FILENAME));
            encoder.writeObject(reservationList);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to store into " + FILENAME + ": "
                    + e.getMessage());
        }
    }

    /**
     * Retrieve room service item list from data/RoomServiceItems.xml file.
     * @return a list of RoomServiceItem objects
     */
    public static List<RoomServiceItem> getRoomServiceItemList() {
        String FILENAME = "data/RoomServiceItems.xml";
        try {
            XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
            List<RoomServiceItem> roomServiceItemList = (List<RoomServiceItem>) decoder.readObject();
            decoder.close();
            return roomServiceItemList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Store room service item list to data/RoomServiceItems.xml file.
     * @param roomServiceItemList a list of RoomServiceItem objects
     */
    public static void storeRoomServiceItemList(List<RoomServiceItem> roomServiceItemList) {
        String FILENAME = "data/RoomServiceItems.xml";
        try {
            XMLEncoder encoder = new XMLEncoder(new FileOutputStream(FILENAME));
            encoder.writeObject(roomServiceItemList);
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to store into " + FILENAME + ": "
                    + e.getMessage());
        }
    }
}
