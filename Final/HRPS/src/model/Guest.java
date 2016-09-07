package model;

public class Guest {
	
	/**
     * The guest id of this Guest.
     */
    private int guestId;
    
    /**
     * The name of this Guest.
     */
    private String name;
    
    /**
     * The Credit card information of this Guest.
     */
    private String creditCard;
    
    /**
     * The address of this Guest.
     */
    private String address;
    
    /**
     * The country this Guest came from.
     */
    private String country;
    
    /**
     * The gender of this Guest.
     */
    private String gender;
    
    /**
     * The identification of this Guest.
     */
    private String identity;
    
    /**
     * The nationality of this Guest.
     */
    private String nationality;
    
    /**
     * The contact number of this Guest.
     */
    private String contactNo;

    
    /**
     * Gets the Guest id of this Guest.
     * @return this Guest's id.
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * Sets the Guest id of this Guest.
     * @param guestId this Guest's guestId.
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    /**
     * Gets the name of this Guest.
     * @return this Guest's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this Guest.
     * @param name this Guest's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the credit card of this Guest.
     * @return this Guest's credit card.
     */
    public String getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card information of this Guest.
     * @param creditCard this Guest's creditCard.
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Gets the address of this Guest.
     * @return this Guest's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of this Guest.
     * @param address this Guest's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the country this Guest came from.
     * @return the country this Guest came from.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the country of this Guest.
     * @param country this Guest's country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the gender of this Guest.
     * @return this Guest's gender.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of this Guest.
     * @param gender this Guest's gender.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the identification of this Guest.
     * @return the identification of this Guest.
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * Sets the identification of this Guest.
     * @param identity this Guest's identity.
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * Gets the nationality of this Guest.
     * @return this Guest's nationality.
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the nationality of this Guest.
     * @param nationality this Guest's nationality.
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    /**
     * Gets the contact number of this Guest.
     * @return this Guest's contact number.
     */
    public String getContactNo(){
    	return contactNo;
    }
    
    /**
     * Sets the contact number of this Guest.
     * @param conNo this Guest's contactNo.
     */
    public void setContactNo(String conNo){
    	this.contactNo = conNo;
    }
    
}
