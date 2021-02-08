package org.academiadecodigo.rapunshells.Test;

import org.academiadecodigo.rapunshells.Environment.Foreground;
import org.academiadecodigo.rapunshells.Grid.Grid;
import org.academiadecodigo.rapunshells.Player.Player;

public class Test {

    public static void main(String[] args) {

        new Grid();
        Player player = new Player();

        Foreground.drawFloor();
    }
}
