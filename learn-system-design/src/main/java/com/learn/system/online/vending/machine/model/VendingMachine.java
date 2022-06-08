package com.learn.system.online.vending.machine.model;

import java.util.List;

public interface VendingMachine {
    Item showItemDetails(String itemId);

    void insertAmount(Notes notes);

    List<Notes> collectChangeIfAny();

    Item collectItem();


}
