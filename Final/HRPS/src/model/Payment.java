package model;

public class Payment {
	
	/**
     * The id of this Payment.
     */
    private long id;
    
    /**
     * The status of this Payment.
     */
    private String status;
    
    /**
     * The mode of payment of this Payment.
     */
    private String mode;
    
    /**
     * The amount of this Payment.
     */
    private double amount;
    
    /**
     * The billing address of this Payment.
     */
    private String billingAddr;

    /**
     * Gets the id of this Payment.
     * @return this Payment's id.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of this Payment.
     * @param id this Payment's id.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the status of this Payment.
     * @return this Payment's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this Payment.
     * @param status this Payment's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the mode of payment of this Payment.
     * @return this Payment's mode.
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the mode of payment of this Payment.
     * @param mode this Payment's mode.
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the amount of this Payment.
     * @return this Payment's amount.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of this Payment.
     * @param amount this Payment's amount.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets the billing address of this Payment.
     * @return this Payment's billing address.
     */
    public String getBillingAddr() {
        return billingAddr;
    }

    /**
     * Sets the billing address of this Payment.
     * @param billingAddr this Payment's billingAddr.
     */
    public void setBillingAddr(String billingAddr) {
        this.billingAddr = billingAddr;
    }
}
