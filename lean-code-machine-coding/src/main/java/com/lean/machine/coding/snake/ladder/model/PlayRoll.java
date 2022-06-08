package com.lean.machine.coding.snake.ladder.model;

import java.util.Random;

public class PlayRoll {

    public static int playRoll()
    {
        return new Random().nextInt(6)+1;
    }
}
