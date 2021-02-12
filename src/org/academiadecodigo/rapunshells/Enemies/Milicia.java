package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;

public class Milicia extends Enemy{
    private int bulletDamage = 20;
    private int shootSpeed = 1;

    public Milicia(int charStartPointX) {
        super(charStartPointX);
        super.health = 80;
        gun = new Gun(bulletDamage, shootSpeed, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
