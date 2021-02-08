package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;

public class Milicia extends Enemy{


    public Milicia() {
        health = 70;
        gun = new Gun(10, 300, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
