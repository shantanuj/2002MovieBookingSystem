package model.room;

public class DoubleSeaRoom extends DoubleRoom {
	
	/**
     * Setup Double Room with Sea View
     */
    public DoubleSeaRoom() {
        super();
        setRoomName("Superior Room with Sea View");
        setView(View.SEA.getView());
    }
}
