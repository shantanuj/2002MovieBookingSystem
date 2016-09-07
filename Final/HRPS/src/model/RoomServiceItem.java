package model;

public class RoomServiceItem {
	
	/**
     * The name of this Room Service Item.
     */
    private String name;
    
    /**
     * The description of this Room Service Item.
     */
    private String description;
    
    /**
     * The price of this Room Service Item.
     */
    private double price;

    /**
     * Gets the name of this Room Service Item.
     * @return this RoomServiceItem's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this Room Service Item.
     * @param name this RoomServiceItem's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of this Room Service Item.
     * @return this RoomServiceItem's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this Room Service Item.
     * @param description this RoomServiceItem's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the price of this Room Service Item.
     * @return this RoomServiceItem's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of this Room Service Item.
     * @param price this RoomServiceItem's price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
