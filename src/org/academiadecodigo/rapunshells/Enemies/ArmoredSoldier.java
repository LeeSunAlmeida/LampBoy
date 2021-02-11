package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Player.Player;

public class ArmoredSoldier extends Enemy{
    private int bulletDamage = 30;
    private int shootSpeed = 4;

    public ArmoredSoldier(int charStarPointX) {
        super(charStarPointX);
        super.health = 150;
        gun = new Gun(bulletDamage, shootSpeed, this);
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }
}
