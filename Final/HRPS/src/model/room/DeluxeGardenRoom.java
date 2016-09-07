package model.room;

public class DeluxeGardenRoom extends DeluxeRoom {
	
	/**
     * Setup Deluxe Room with Garden View
     */
	public DeluxeGardenRoom() {
        super();
        setRoomName("Deluxe Room with Garden View");
        setView(View.GARDEN.getView());
    }
}
