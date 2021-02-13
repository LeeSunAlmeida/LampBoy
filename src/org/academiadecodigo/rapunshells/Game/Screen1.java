package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Player.Player;


public class Screen1 {

    public static Player player = new Player();
    public static Soldier soldier = new Soldier(800, player);

    public static Soldier getSoldier() {
        return soldier;
    }




    public static Player getPlayer() {
        return player;
    }
}

