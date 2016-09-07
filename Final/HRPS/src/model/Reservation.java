package model;

import java.util.*;

public class Reservation {
	
	/**
     * The id of this Reservation.
     */
    private int id;
    
    /**
     * The guest id that booked this Reservation.
     */
    private int guestId;
    
    /**
     * The room number given to this Reservation.
     */
    private String roomNumber;
    
    /**
     * The check in date of this Reservation.
     */
    private Date checkIn;
    
    /**
     * The check out date of this Reservation.
     */
    private Date checkOut;
    
    /**
     * The number of adults booked in this Reservation.
     */
    private int numOfAdults;
    
    /**
     * The number of children booked in this Reservation.
     */
    private int numOfChildren;
    
    /**
     * The base rate of this Reservation.
     */
    private double baseRate;
    
    /**
     * The orders that this Reservation can make.
     */
    private List<RoomServiceOrderItem> orders;
    
    /**
     * The status of this Reservation.
     */
    private String status;
    
    /**
     * The extra charge of this Reservation.
     */
    private double extraCharge;
    
    /**
     * The discount of this Reservation.
     */
    private double discount;
    
    /**
     * The payment of this Reservation.
     */
    private Payment payment;

    /**
     * Gets id of this Reservation.
     * @return this Reservation's id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of this Reservation.
     * @param id this Reservation's id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Guest id that booked this Reservation.
     * @return this Reservation's guest id.
     */
    public int getGuestId() {
        return guestId;
    }

    /**
     * Sets the guest id that booked this Reservation.
     * @param guestId this Reservation's guestId.
     */
    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    /**
     * Gets the room number given to this Reservation.
     * @return this Reservation's room number.
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number given to this Reservation.
     * @param roomNumber this Reservation's roomNumber.
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets the check in date of this Reservation.
     * @return this Reservation's check in date.
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the check in date of this Reservation.
     * @param checkIn this Reservation's checkIn.
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Gets the check out date of this Reservation.
     * @return this Reservation's check out date.
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the check out date of this Reservation.
     * @param checkOut this Reservation's checkOut.
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Gets the number of adults booked in this Reservation.
     * @return the number of adults booked in this Reservation.
     */
    public int getNumOfAdults() {
        return numOfAdults;
    }

    /**
     * Sets the number of adults booked in this Reservation.
     * @param numOfAdults this Reservation's numOfAdults.
     */
    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
    }

    /**
     * Gets the number of children booked in this Reservation.
     * @return number of children booked in this Reservation.
     */
    public int getNumOfChildren() {
        return numOfChildren;
    }

    /**
     * Sets the number of children booked in this Reservation.
     * @param numOfChildren this Reservation's numOfChildren.
     */
    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
    }

    /**
     * Gets the base rate of this Reservation.
     * @return this Reservation's base rate.
     */
    public double getBaseRate() {
        return baseRate;
    }

    /**
     * Sets the base rate of this Reservation.
     * @param baseRate this Reservation's baseRate.
     */
    public void setBaseRate(double baseRate) {
        this.baseRate = baseRate;
    }

    /**
     * Gets the orders that this Reservation can make.
     * @return this Reservation's orders.
     */
    public List<RoomServiceOrderItem> getOrders() {
        return orders;
    }

    /**
     * Sets the orders that this Reservation can make.
     * @param orders this Reservation's orders.
     */
    public void setOrders(List<RoomServiceOrderItem> orders) {
        this.orders = orders;
    }

    /**
     * Gets the status of this Reservation.
     * @return this Reservation's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of this Reservation.
     * @param status this Reservation's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Gets the extra charge of this Reservation.
     * @return this Reservation's extra charge.
     */
    public double getExtraCharge() {
    	return extraCharge;
    }
    
    /**
     * Sets the extra charge of this Reservation.
     * @param extraCharge this Reservation's extraCharge.
     */
    public void setExtraCharge(double extraCharge) {
    	this.extraCharge = extraCharge;
    }

    /**
     * Gets the discount of this Reservation.
     * @return this Reservation's discount.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the discount of this Reservation.
     * @param discount this Reservation's discount.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Gets the payment of this Reservation.
     * @return payment Reservation's payment.
     */
    public Payment getPayment() {
        return payment;
    }
    
    /**
     * Sets the payment of this Reservation.
     * @param payment this Reservation's payment.
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Gets the total of room service charge in this Reservation.
     * @return this Reservation's total room service charge.
     */
    public double getRoomServiceTotal() {
        double roomServiceTotal = 0;
        if (orders != null) {
            for (RoomServiceOrderItem item : orders) {
                if (item.getStatus().equalsIgnoreCase(RoomServiceOrderStatus.DELIVERED.getStatus()))
                    roomServiceTotal += item.getPrice() * item.getQuantity();
            }
        }
        return roomServiceTotal;
    }

    /**
     * Gets the total rate in this Reservation.
     * @return this Reservation's total rate.
     */
    public double getRateTotal() {
        Calendar start = Calendar.getInstance();
        start.setTime(getCheckIn());
        start.set(Calendar.HOUR_OF_DAY, 13);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(getCheckOut());
        double totalCost = 0;

        // get cost per day
        for (; start.before(end);
             start.add(Calendar.DATE, 1), start.getTime()) {

            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
                // day is a weekend; additional 5% charge
                totalCost += (1.05) * getBaseRate();
            } else {
                // day is a weekday
                totalCost += getBaseRate();
            }
        }
        return totalCost;
    }

    /**
     * Gets the sub total in this Reservation.
     * @return this Reservation's sub total.
     */
    public double getSubTotal() {
        return getRateTotal() + getRoomServiceTotal();
    }

    /**
     * Gets the GST in this Reservation.
     * @return this Reservation's GST.
     */
    public double getGST() {
        return 0.07 * (getRateTotal() + getRoomServiceTotal());
    }

    /**
     * Gets the total bill in this Reservation.
     * @return this Reservation's total bill.
     */
    public double getTotalBill() {
        return 1.07 * (getRateTotal() + getRoomServiceTotal());
    }

    /**
     * Gets the number of weekdays stayed in this Reservation.
     * @return this Reservation's number of weekdays stayed.
     */
    public int numOfWeekdays() {
        Calendar start = Calendar.getInstance();
        start.setTime(getCheckIn());
        start.set(Calendar.HOUR_OF_DAY, 13);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(getCheckOut());
        int numOfWeekdays = 0;
        for (; start.before(end);
             start.add(Calendar.DATE, 1), start.getTime()) {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day != Calendar.SATURDAY && day != Calendar.SUNDAY)
                numOfWeekdays++;
        }
        return numOfWeekdays;
    }

    /**
     * Gets the total rate of weekdays stayed in this Reservation.
     * @return this Reservation's total rate of weekdays stayed.
     */
    public double weekdaysTotal() {
        Calendar start = Calendar.getInstance();
        start.setTime(getCheckIn());
        start.set(Calendar.HOUR_OF_DAY, 13);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(getCheckOut());
        double weekdaysTotal = 0;
        for (; start.before(end);
             start.add(Calendar.DATE, 1), start.getTime()) {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day != Calendar.SATURDAY && day != Calendar.SUNDAY)
                weekdaysTotal += getBaseRate();
        }
        return weekdaysTotal;
    }

    /**
     * Gets the number of weekends stayed in this Reservation.
     * @return this Reservation's number of weekends stayed.
     */
    public int numOfWeekends() {
        Calendar start = Calendar.getInstance();
        start.setTime(getCheckIn());
        start.set(Calendar.HOUR_OF_DAY, 13);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(getCheckOut());
        int numOfWeekends = 0;
        for (; start.before(end);
             start.add(Calendar.DATE, 1), start.getTime()) {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SATURDAY || day == Calendar.SUNDAY)
                numOfWeekends++;
        }
        return numOfWeekends;
    }

    /**
     * Gets the total rate of weekends stayed in this Reservation.
     * @return this Reservation's total rate of weekends stayed.
     */
    public double weekendsTotal() {
        Calendar start = Calendar.getInstance();
        start.setTime(getCheckIn());
        start.set(Calendar.HOUR_OF_DAY, 13);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(getCheckOut());
        double weekendsTotal = 0;
        for (; start.before(end);
             start.add(Calendar.DATE, 1), start.getTime()) {
            int day = start.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SATURDAY || day == Calendar.SUNDAY)
                weekendsTotal += (1.05) * getBaseRate();
        }
        return weekendsTotal;
    }
}
