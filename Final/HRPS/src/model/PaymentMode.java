package model;

public enum PaymentMode {
    CASH("Cash"),
    CREDITCARD("Credit Card");

    private String mode;

    /**
     * Set a new Payment Mode.
     * @param mode This PaymentMode's mode.
     */
    PaymentMode(String mode) {
        this.mode = mode;
    }

    /**
     * Get the status of the room.
     * @return this Availability status.
     */
    public String getMode() {
        return mode;
    }
}
