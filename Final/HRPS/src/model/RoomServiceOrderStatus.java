package model;

public enum RoomServiceOrderStatus {
    CONFIRMED("Confirmed"),
    PREPARING("Preparing"),
    DELIVERED("Delivered");

	/**
     * The status of this Room Service Order.
     */
    private String status;

    /**
     * Set a new RoomServiceOrder Status.
     * @param status This RoomServiceOrderStatus's status.
     */
    RoomServiceOrderStatus(String status) {
        this.status = status;
    }

    /**
     * Get the status of this RoomServiceOrder.
     * @return this RoomServiceOrder status.
     */
    public String getStatus() {
        return status;
    }
}
