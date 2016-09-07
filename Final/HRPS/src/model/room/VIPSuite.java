package model.room;

public class VIPSuite extends Room {
	
	/**
     * Setup VIP Suite
     */
    public VIPSuite() {
        super();
        setRoomName("VIP Suite");
        setRoomType("VIP Suite");
        setMinOccupants(4);
        setMaxOccupants(6);
        setNumOfBeds(2);
        setBedType(BedType.MASTER.getType());
        setView(View.NOVIEW.getView());
    }
}
