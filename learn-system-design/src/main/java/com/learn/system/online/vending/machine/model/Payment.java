package com.learn.system.online.vending.machine.model;

import java.util.Date;

public class Payment {
    private long id;
    private int amount;
    private String bucketID;
    private String rowID;
    private String itemName;
    private Date paymentTime;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBucketID() {
        return bucketID;
    }

    public void setBucketID(String bucketID) {
        this.bucketID = bucketID;
    }

    public String getRowID() {
        return rowID;
    }

    public void setRowID(String rowID) {
        this.rowID = rowID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
