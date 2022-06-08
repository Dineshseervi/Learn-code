package com.learn.system.online.vending.machine.model;

public class Bucket {
    private Item bucketItem;
    private int itemCount; //this count shoud he greater then 0 and less the MAX bucket size;
    private String bucketId;


    public Bucket(String bucketId) {
        this.bucketId=bucketId;
    }

    public Item getBucketItem() {
        return bucketItem;
    }

    public void setBucketItem(Item bucketItem) {
        this.bucketItem = bucketItem;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public String getBucketId() {
        return bucketId;
    }

    public void setBucketId(String bucketId) {
        this.bucketId = bucketId;
    }
}
