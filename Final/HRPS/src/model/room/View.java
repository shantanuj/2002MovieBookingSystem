package model.room;

public enum View {
    NOVIEW(""),
    SEA("Sea"),
	GARDEN("Garden");

	/**
     * The view of this Room.
     */
    private String view;

    /**
     * Create a new Room view.
     * @param view This View's view.
     */
    View(String view) {
        this.view = view;
    }

    /**
     * Get the view of this Room.
     * @return this Room view.
     */
    public String getView() {
        return view;
    }
}
