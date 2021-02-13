package org.academiadecodigo.rapunshells.Test;

import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Environment.Foreground;
import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Screen1;

import org.academiadecodigo.rapunshells.Grid.Grid;
import org.academiadecodigo.rapunshells.Player.Player;



public class Test {

    public static void main(String[] args) {

        new Grid();

        new Background().Intro();
        new Background().PlayerLifeBarr();
        new Background().EnemyLifeBarr();

        //new Screen2().BackGround2();

        Foreground.drawFloor();
        try{
            Game.executeOrders(Screen1.getPlayer());
        } catch (Exception e) {
            System.out.println("Thread sleep busted");
        }
    }
}
