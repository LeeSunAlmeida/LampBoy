package org.academiadecodigo.rapunshells.Enemies;
import org.academiadecodigo.rapunshells.Guns.Bullet;


public class Soldier extends Enemy {

    private int bulletDamage = 10;
    private int shootSpeed = 3;

    public Soldier(int charStarPointX) {
        super(charStarPointX);
        super.health = 100;
        gun = new Gun(bulletDamage, shootSpeed, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }


}