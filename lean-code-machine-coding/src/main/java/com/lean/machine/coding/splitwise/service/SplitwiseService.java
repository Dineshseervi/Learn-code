package com.lean.machine.coding.splitwise.service;

import com.lean.machine.coding.splitwise.model.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitwiseService {
    //Map<String,Double> userOwns=new HashMap<>();
    Map<String,Map<String,Double>> userService=new HashMap<>();

    public void updateExpenseBasedOnType(double amount, int div, List<String> dividentUsers, List<Double> percentages, Expense expense)
    {

    }

    /*public void updateExpenseExactBased(double amount, int div, List<String> dividentUsers,List<Double> exactDistribution)
    {

    }

    public void updateExpenseEqualsBased(double amount, int div, List<String> dividentUsers,List<Double> exactDistribution)
    {

    }*/
}
