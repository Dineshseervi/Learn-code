package com.lean.machine.coding.snake.ladder.play;

import com.lean.machine.coding.snake.ladder.model.*;

import java.util.ArrayList;
import java.util.List;

public class PalyGame {
    public static void main(String[] args) {
        java.util.List<LadderMagicMove> list=new ArrayList<>();

        LadderMagicMove  magicMove1=new LadderMagicMove(MagicMove.SNAKE,20,10);
        LadderMagicMove  magicMove2=new LadderMagicMove(MagicMove.SNAKE,30,15);
        LadderMagicMove  magicMove3=new LadderMagicMove(MagicMove.SNAKE,40,22);
        LadderMagicMove  magicMove4=new LadderMagicMove(MagicMove.SNAKE,50,32);
        LadderMagicMove  magicMove5=new LadderMagicMove(MagicMove.SNAKE,57,9);
        LadderMagicMove  magicMove6=new LadderMagicMove(MagicMove.SNAKE,65,5);
        LadderMagicMove  magicMove7=new LadderMagicMove(MagicMove.SNAKE,80,42);
        LadderMagicMove  magicMove8=new LadderMagicMove(MagicMove.SNAKE,88,32);
        LadderMagicMove  magicMove9=new LadderMagicMove(MagicMove.SNAKE,95,4);
        LadderMagicMove  magicMove10=new LadderMagicMove(MagicMove.SNAKE,99,1);
        LadderMagicMove  magicMove101=new LadderMagicMove(MagicMove.SNAKE,98,2);

        LadderMagicMove  magicMove11=new LadderMagicMove(MagicMove.LADDER,21,44);
        LadderMagicMove  magicMove12=new LadderMagicMove(MagicMove.LADDER,13,33);
        LadderMagicMove  magicMove13=new LadderMagicMove(MagicMove.LADDER,28,81);
        LadderMagicMove  magicMove14=new LadderMagicMove(MagicMove.LADDER,38,71);
        LadderMagicMove  magicMove15=new LadderMagicMove(MagicMove.LADDER,58,91);
        LadderMagicMove  magicMove16=new LadderMagicMove(MagicMove.LADDER,68,94);
        list.add(magicMove1);
        list.add(magicMove2);
        list.add(magicMove3);
        list.add(magicMove4);
        list.add(magicMove5);
        list.add(magicMove6);
        list.add(magicMove7);
        list.add(magicMove101);

        list.add(magicMove8);
        list.add(magicMove9);
        list.add(magicMove10);
        list.add(magicMove11);
        list.add(magicMove12);
        list.add(magicMove13);
        list.add(magicMove14);
        list.add(magicMove15);
        list.add(magicMove16);






        List<Player > players=new ArrayList<>();
        Player player1=new Player("Dinesh");
        Player player2=new Player("Rakesh");
        Player player3=new Player("Mahi");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        SnakeLadderBoard snakeLadderBoard=new SnakeLadderBoard(list,players);
        SnakeLadderService snakeLadderService=new SnakeLadderService(snakeLadderBoard);
        for (int i=0;i<1000;i++)
        {
            for (Player player:players) {

              int number=  snakeLadderService.playPlayer(player.getId());
                System.out.println("Player :"+player.getName() +" poisition :"+number + " current chance i:"+i);
              if(number>=100)
              {
                  System.out.println("PLAYER WON :"+player.getName() );
                  i=1000;
                  break;
              }
            }
        }
    }
}
