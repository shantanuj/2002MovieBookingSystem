package main;
import model.Storage;
import model.AvailabilityStatus;
import model.room.Room;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Reports {
    public Reports() {
        Console.printTitle("HRPS Reports");
        SimpleDateFormat dateFormat = new SimpleDateFormat("E, dd MMM yyyy, hh:mm aaa");
        Console.print("Date: " + dateFormat.format(new Date()));
        Console.printDivider();
        System.out.println();

        List<Room> roomList = Rooms.roomList;

        List<Room> singleRooms = roomList.stream().filter(room ->
            room.getRoomType().equalsIgnoreCase("single")).collect(Collectors.toList());
        List<Room> singleAvailableRooms = singleRooms.stream().filter(room ->
            room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
                .collect(Collectors.toList());
        Console.print("Single Rooms: " + singleAvailableRooms.size() + " of "
                + singleRooms.size() + " available.");
        Rooms.printRoomList(singleAvailableRooms);
        Console.printDivider();

        List<Room> doubleRooms = roomList.stream().filter(room ->
                room.getRoomType().equalsIgnoreCase("double")).collect(Collectors.toList());
        List<Room> doubleAvailableRooms = doubleRooms.stream().filter(room ->
            room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
                .collect(Collectors.toList());
        Console.print("Double Rooms: " + doubleAvailableRooms.size() + " of "
                + doubleRooms.size() + " available.");
        Rooms.printRoomList(doubleAvailableRooms);
        Console.printDivider();

        List<Room> deluxeRooms = roomList.stream().filter(room ->
                room.getRoomType().equalsIgnoreCase("deluxe")).collect(Collectors.toList());
        List<Room> deluxeAvailableRooms = deluxeRooms.stream().filter(room ->
            room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
                .collect(Collectors.toList());
        Console.print("Deluxe Rooms: " + deluxeAvailableRooms.size() + " of "
                + deluxeRooms.size() + " available.");
        Rooms.printRoomList(deluxeAvailableRooms);
        Console.printDivider();

        List<Room> VIPSuites = roomList.stream().filter(room ->
                room.getRoomType().equalsIgnoreCase("vip suite")).collect(Collectors.toList());
        List<Room> VIPSuiteAvailableRooms = VIPSuites.stream().filter(room ->
            room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
                .collect(Collectors.toList());
        Console.print("VIP Suites: " + VIPSuiteAvailableRooms.size() + " of "
                + VIPSuites.size() + " available.");
        Rooms.printRoomList(VIPSuiteAvailableRooms);

        Console.printTitle("Unavailable Rooms");
        List<Room> unavailableRooms = roomList.stream().filter(room ->
                !room.getAvailability().equalsIgnoreCase(AvailabilityStatus.VACANT.getStatus()))
                .collect(Collectors.toList());
        Rooms.printRoomList(unavailableRooms);
        Console.enterToContinue();
    }
}
