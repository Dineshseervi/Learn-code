package com.learn.system.online.vending.machine.model;

public class VendingMachineDesign {
    private Row [] rows;

    public VendingMachineDesign(int rowCount , int bucketCount, int coolingCount) {
        rows=new Row[rowCount];
        int coolingDesignCount=0;
        for (int i=0;i<rows.length;i++)
        {
            if(coolingDesignCount<coolingCount)
            {
                rows[i]=new Row(i+"",true,bucketCount);
                coolingDesignCount++;
            }else {
                rows[i]=new Row(i+"",false,bucketCount);
            }
        }
    }

    //public void addIteams()





}
