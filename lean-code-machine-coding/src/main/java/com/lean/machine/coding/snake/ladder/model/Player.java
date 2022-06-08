package com.lean.machine.coding.snake.ladder.model;

import java.util.UUID;

public class Player {
    private String name;
    private String id;
    private int currentPosition;

    public Player(String name) {
        this.name = name;
        this.id=UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
