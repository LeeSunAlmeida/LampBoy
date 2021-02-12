package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Player.Player;

public class Screen1 {
    //todo implement 2 Soldiers
    public static Soldier soldier = new Soldier(1200);
    public static Player player = new Player();

    public static Soldier getSoldier() {
        return soldier;
    }

    public static Player getPlayer() {
        return player;
    }
}
