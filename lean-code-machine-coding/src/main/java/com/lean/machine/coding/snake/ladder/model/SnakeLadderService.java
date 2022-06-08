package com.lean.machine.coding.snake.ladder.model;

public class SnakeLadderService {

    private SnakeLadderBoard snakeLadderBoard;

    public SnakeLadderService(SnakeLadderBoard snakeLadderBoard) {
        this.snakeLadderBoard = snakeLadderBoard;
    }

    public int playPlayer(String id)
    {
        int val=PlayRoll.playRoll();
        int currentPosition= snakeLadderBoard.getPlayerPosition(id);
        if(currentPosition+val>100)
        {
            return currentPosition;
        }
        if(currentPosition+val==100)
        {
            winnerMessage(id);
            return currentPosition+val;
        }
        int newPosition=getFinalPosition(currentPosition + val);
        snakeLadderBoard.updatePlayerNewPosition(id,newPosition);
        return newPosition;
    }

    private void winnerMessage(String id) {
    }


    public int getFinalPosition(int position)
    {
        if(snakeLadderBoard.boardContainsLadderSnake(position)){
            LadderMagicMove magicMove=snakeLadderBoard.getMagicMove(position);
            int newPosition = magicMove.getEnd();
            return getFinalPosition(newPosition);
        }
        return position;
    }


}
