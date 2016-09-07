package model.room;

public class SingleRoom extends Room {
	
	/**
     * Setup Single Room
     */
    public SingleRoom() {
        super();
        setRoomName("Single Room");
        setRoomType("Single");
        setMinOccupants(1);
        setMaxOccupants(1);
        setNumOfBeds(1);
        setBedType(BedType.SINGLE.getType());
        setView(View.NOVIEW.getView());
    }
}
