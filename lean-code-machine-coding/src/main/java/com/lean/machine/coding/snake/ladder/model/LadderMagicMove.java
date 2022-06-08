package com.lean.machine.coding.snake.ladder.model;

public class LadderMagicMove {
    private MagicMove magicMove;
    private int start;
    private int end;

    public LadderMagicMove(MagicMove magicMove, int start, int end) {
        this.magicMove = magicMove;
        this.start = start;
        this.end = end;
    }

    public MagicMove getMagicMove() {
        return magicMove;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
