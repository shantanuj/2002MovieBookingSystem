package model.room;

public class SingleGardenRoom extends SingleRoom {
	
	/**
     * Setup Single Room with Garden View
     */
    public SingleGardenRoom() {
        super();
        setRoomName("Single Room with Garden View");
        setView(View.GARDEN.getView());
    }
}
