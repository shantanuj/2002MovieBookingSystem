package model.room;

public class DoubleRoom extends Room {
	
	/**
     * Setup Double Room
     */
    public DoubleRoom() {
        super();
        setRoomName("Superior Room");
        setRoomType("Double");
        setMinOccupants(2);
        setMaxOccupants(3);
        setNumOfBeds(1);
        setBedType(BedType.DOUBLE.getType());
        setView(View.NOVIEW.getView());
    }
}
