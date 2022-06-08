package com.learn.system.online.vending.machine.model;

public class Row {
    private String rowId;
    private Bucket [] bucket;
    private boolean isColling;

    public Row(String rowId, boolean isColling, int bucketCount) {
        this.rowId = rowId;
        this.isColling = isColling;
        bucket=new Bucket[bucketCount];
        addBucket();
    }

    private void addBucket() {
        int count=1;
        for(int i=0;i<bucket.length;i++)
        {
            bucket[i]=new Bucket(count+"");
            count++;
        }
    }
}
