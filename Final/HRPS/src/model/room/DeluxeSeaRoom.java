package model.room;

public class DeluxeSeaRoom extends DeluxeRoom {
	
	/**
     * Setup Deluxe Room with Sea View
     */
    public DeluxeSeaRoom() {
        super();
        setRoomName("Deluxe Room with Sea View");
        setView(View.SEA.getView());
    }
}
