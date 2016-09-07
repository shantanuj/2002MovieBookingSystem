package model.room;

public class VIPSuiteGarden extends VIPSuite {
	
	/**
     * Setup VIP Suite with Garden View
     */
    public VIPSuiteGarden() {
        super();
        setRoomName("VIP Suite with Garden View");
        setView(View.GARDEN.getView());
    }
}
