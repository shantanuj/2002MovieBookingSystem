package model;

public enum ReservationStatus {
    RESERVED("Reserved"),
    CHECKIN("Checked-in"),
    CHECKOUT("Checked-out"),
    EXPIRED("Expired"),
    CANCELLED("Cancelled"),;

	/**
     * The mode of this PaymentMode.
     */
    private String status;

    /**
     * Set a new Reservation Status.
     * @param status This ReservationStatus's status.
     */
    ReservationStatus(String status) {
        this.status = status;
    }

    /**
     * Get the status of this Reservation.
     * @return this Reservation status.
     */
    public String getStatus() {
        return status;
    }
}
