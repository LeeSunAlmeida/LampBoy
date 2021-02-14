package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Environment.Foreground;
import org.academiadecodigo.rapunshells.Grid.Grid;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Screen1 {

    private static Player player = null;
    private final static Soldier soldier = new Soldier(1000);
    private Picture backGround1;



    public Text PlayerName() {


        Text playerName = new Text(Window.getPADDING() + 135, Window.getPADDING() + 100, "LAMP BOY");
        playerName.draw();
        playerName.setColor(Color.BLACK);
        playerName.grow(1, 10);

        return playerName;
    }


    public static Picture Final(){

        Picture winner = new Picture(Window.getPADDING(), Window.getPADDING(), "background-room.final.jpg");

        winner.draw();

        return winner;
    }


    public Screen1(Player player) {
        this.player = player;
        new Grid();
        backGround1 = backGround1();
        soldier.drawEnemy();
        player.drawPlayer();
        Game.createPlayerLifeBar(player);
        PlayerName();

        Game.executeOrders(player);

    }

    public static Soldier getSoldier() {
        return soldier;
    }

    public Picture backGround1() {

        backGround1 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-room.jpg");

        backGround1.draw();

        return backGround1;

    }

}

