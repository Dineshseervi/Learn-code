package com.lean.machine.coding.snake.ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {

    private List<LadderMagicMove> list;

    private List<Player> players;

    Map<Integer,LadderMagicMove> board=new HashMap<>(); // This map will contains magic move at each position snake and ladder;
    Map<String,Integer> playerPosition=new HashMap<>(); // This map will contains playerId and player current position;

    public SnakeLadderBoard(List<LadderMagicMove> list, List<Player> players) {
        this.list = list;
        this.players = players;
        addPlayerToBoard(players);
        addMagicMovesToBoard(list);
    }

    private void addMagicMovesToBoard(List<LadderMagicMove> list)
    {
        for(LadderMagicMove magicMove:list)
        {
            board.put(magicMove.getStart(),magicMove);
        }
    }

    private void addPlayerToBoard(List<Player> players)
    {
        for(Player player:players)
        {
            playerPosition.put(player.getId(),0);
        }
    }

    public int getPlayerPosition(String id)
    {
        return playerPosition.get(id);
    }

  /*  public int playPlayer(String id)
    {
        int val=PlayRoll.playRoll();
        int currentPosition= playerPosition.get(id);
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
        updatePlayerNewPosition(id,newPosition);
        return newPosition;
    }

    public int getFinalPosition(int position)
    {
       if(board.containsKey(position)){
           LadderMagicMove magicMove=board.get(position);
          int newPosition = magicMove.getEnd();
          return getFinalPosition(newPosition);
       }
       return position;
    }*/

    public void updatePlayerNewPosition(String id,int position)
    {
        playerPosition.put(id,position);
    }

    public boolean boardContainsLadderSnake(int position)
    {
       return board.containsKey(position);
    }

    public LadderMagicMove getMagicMove(int position)
    {
        return board.get(position);
    }

    private void winnerMessage(String id)
    {
        System.out.println("GAME OVER user won the game :"+id);
    }
}
