package model.room;

public class SingleSeaRoom extends SingleRoom {
	
	/**
     * Setup Single Room with Sea View
     */
    public SingleSeaRoom() {
        super();
        setRoomName("Single Room with Sea View");
        setView(View.SEA.getView());
    }
}
