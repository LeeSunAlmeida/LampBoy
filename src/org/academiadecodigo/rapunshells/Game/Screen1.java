package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Environment.Foreground;
import org.academiadecodigo.rapunshells.Grid.Grid;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Screen1 {

    private static Player player = null;
    private final static Soldier soldier = new Soldier(1000);
    private Picture backGround1;

    public Screen1(Player player) {
        this.player = player;
        new Grid();
        backGround1 = backGround1();
        soldier.drawEnemy();
        player.drawPlayer();
        Game.createPlayerLifeBar(player);

        Game.executeOrders(player);

    }

    public static Soldier getSoldier() {
        return soldier;
    }

    public Picture backGround1() {

        backGround1 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-mars.jpg");

        backGround1.draw();
        backGround1.grow(80, 0);
        backGround1.translate(80, 0);

        return backGround1;

    }

}

