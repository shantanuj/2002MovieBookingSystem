package model;

public enum AvailabilityStatus {
    VACANT("Vacant"),
    OCCUPIED("Occupied"),
    RESERVED("Reserved"),
    MAINTENANCE("Under Maintenance");
	
	/**
     * The status of room availability.
     */
    private String status;

    /**
     * Set Availability Status.
     * @param status to be set
     */
    AvailabilityStatus(String status) {
        this.status = status;
    }
    
    /**
     * Get the status of the room.
     * @return this Availability status.
     */
    public String getStatus() {
        return status;
    }
}
