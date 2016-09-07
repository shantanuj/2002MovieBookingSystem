package model.room;

public class DoubleGardenRoom extends DoubleRoom {
	
	/**
     * Setup Double Room with Garden View
     */
    public DoubleGardenRoom() {
        super();
        setRoomName("Superior Room with Garden View");
        setView(View.GARDEN.getView());
    }
}
