package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;

public class Soldier extends Enemy {

    public Soldier() {
        health = 100;
        gun = new Gun(10, 500, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}