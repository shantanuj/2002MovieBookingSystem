package model.room;

public class DeluxeRoom extends Room {
	
	/**
     * Setup Deluxe Room
     */
    public DeluxeRoom() {
        super();
        setRoomName("Deluxe Room");
        setRoomType("Deluxe");
        setMinOccupants(2);
        setMaxOccupants(4);
        setNumOfBeds(1);
        setBedType(BedType.MASTER.getType());
        setView(View.NOVIEW.getView());
    }
}
