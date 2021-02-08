package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Player.Player;

public class ArmoredSoldier extends Enemy{



    public ArmoredSoldier() {

        health = 150;
        gun = new Gun(15, 900, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
