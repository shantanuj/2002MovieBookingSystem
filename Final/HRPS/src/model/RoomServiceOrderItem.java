package model;

public class RoomServiceOrderItem {
	
	/**
     * The name of this Room Service Order Item.
     */
    private String name;
    
    /**
     * The description of this Room Service Order Item.
     */
    private String description;
    
    /**
     * The price of this Room Service Order Item.
     */
    private double price;
    
    /**
     * The quantity of this Room Service Order Item.
     */
    private int quantity;
    
    /**
     * The preparation of this Room Service Order Item.
     */
    private String preparation;
    
    /**
     * The status of this Room Service Order Item.
     */
    private String status;

    /**
     * Gets the name of this Room Service Order Item.
     * @return this RoomServiceOrderItem's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this Room Service Order Item.
     * @param name this RoomServiceOrderItem's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Room Service Order Item.
     * @return this RoomServiceOrderItem's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this Room Service Order Item.
     * @param description this RoomServiceOrderItem's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of this Room Service Order Item.
     * @return this RoomServiceOrderItem's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this Room Service Order Item.
     * @param price this RoomServiceOrderItem's price.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the quantity of this Room Service Order Item.
     * @return this RoomServiceOrderItem's quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of this Room Service Order Item.
     * @param quantity this RoomServiceOrderItem's quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the preparation of this Room Service Order Item.
     * @return this RoomServiceOrderItem's preparation.
     */
    public String getPreparation() {
        return preparation;
    }

    /**
     * Sets the preparation of this Room Service Order Item.
     * @param preparation this RoomServiceOrderItem's preparation.
     */
    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    /**
     * Gets the status of this Room Service Order Item.
     * @return this RoomServiceOrderItem's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this Room Service Order Item.
     * @param status this RoomServiceOrderItem's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
