package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Player.Player;

public class Milicia extends Enemy{
    private int bulletDamage = 20;
    private int shootSpeed = 1;

    public Milicia(int charStartPointX) {
        super(charStartPointX);
        super.health = 80;
        gun = new Gun(bulletDamage, shootSpeed, this);
    }


    @Override
    public void translate(double v, double v1) {

    }
}
