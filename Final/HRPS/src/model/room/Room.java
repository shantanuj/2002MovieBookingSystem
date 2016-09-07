package model.room;

public class Room {
	
	/**
     * The room number of this Room.
     */
    private String roomNumber;
    
    /**
     * The room name of this Room.
     */
    private String roomName;
    
    /**
     * The room type of this Room.
     */
    private String roomType;
    
    /**
     * The bed type of this Room.
     */
    private String bedType;
    
    /**
     * The number of bed in this Room.
     */
    private int numOfBeds;
    
    /**
     * The minimum occupants of this Room.
     */
    private int minOccupants;
    
    /**
     * The maximum occupants of this Room.
     */
    private int maxOccupants;
    
    /**
     * The wifi of this Room.
     */
    private boolean wifi;
    
    /**
     * The view of this Room.
     */
    private String view;
    
    /**
     * Smoking allowed in this Room.
     */
    private boolean smoking;
    
    /**
     * The availability of this Room.
     */
    private String availability;
    
    /**
     * The rate of this Room.
     */
    private double rate;

    /**
     * Gets the room number of this Room.
     * @return this Room's roomNumber.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number of this Room.
     * @param roomNumber this Room's roomNumber.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets the room name of this Room.
     * @return this Room's room name.
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     * Sets the room name of this Room.
     * @param roomName this Room's roomName.
     */
    protected void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     * Gets the room type of this Room.
     * @return this Room's room type.
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type of this Room.
     * @param roomType this Room's roomType.
     */
    protected void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Gets the bed type of this Room.
     * @return this Room's bed type.
     */
    public String getBedType() {
        return bedType;
    }

    /**
     * Sets the bed type of this Room.
     * @param bedType this Room's bedType.
     */
    protected void setBedType(String bedType) {
        this.bedType = bedType;
    }

    /**
     * Gets the number of beds of this Room.
     * @return this Room's number of beds.
     */
    public int getNumOfBeds() {
        return numOfBeds;
    }

    /**
     * Sets the number of beds of this Room.
     * @param numOfBeds this Room's numOfBeds.
     */
    protected void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    /**
     * Gets the minimum occupants of this Room.
     * @return this Room's minimum occupants.
     */
    public int getMinOccupants() {
        return minOccupants;
    }

    /**
     * Sets the minimum occupants of this Room.
     * @param minOccupants this Room's minOccupants.
     */
    protected void setMinOccupants(int minOccupants) {
        this.minOccupants = minOccupants;
    }

    /**
     * Gets the maximum occupants of this Room.
     * @return this Room's maximum occupants.
     */
    public int getMaxOccupants() {
        return maxOccupants;
    }

    /**
     * Sets the maximum occupants of this Room.
     * @param maxOccupants this Room's maxOccupants.
     */
    protected void setMaxOccupants(int maxOccupants) {
        this.maxOccupants = maxOccupants;
    }

    /**
     * Is there wifi in this Room.
     * @return if this Room's has wifi.
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     * Sets the wifi of this Room.
     * @param wifi this Room's wifi.
     */
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    /**
     * Gets the view of this Room.
     * @return this Room's view.
     */
    public String getView() {
        return view;
    }

    /**
     * Sets the view of this Room.
     * @param view this Room's view.
     */
    protected void setView(String view) {
        this.view = view;
    }

    /**
     * Is smoking allowed in this Room.
     * @return if this Room's allows smoking.
     */
    public boolean isSmoking() {
        return smoking;
    }

    /**
     * Sets the is smoking allowed in this Room.
     * @param smoking this Room's smoking.
     */
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    /**
     * Gets the Availability of this Room.
     * @return this Room's Availability.
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Sets the availability of this Room.
     * @param availability this Room's availability.
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Gets the rate of this Room.
     * @return this Room's rate.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Sets the rate of this Room.
     * @param rate this Room's rate.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
}
