package model.room;

public class VIPSuiteSea extends VIPSuite {
	
	/**
     * Setup VIP Suite with Sea View
     */
    public VIPSuiteSea() {
        super();
        setRoomName("VIP Suite with Sea View");
        setView(View.SEA.getView());
    }
}
