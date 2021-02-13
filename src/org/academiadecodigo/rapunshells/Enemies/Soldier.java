package org.academiadecodigo.rapunshells.Enemies;
import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Player.Player;


public class Soldier extends Enemy {

    private int bulletDamage = 10;
    private int shootSpeed = 3;

    public Soldier(int charStartPointX, Player player) {
        super(charStartPointX, player);
        super.health = 100;
        gun = new Gun(bulletDamage, shootSpeed, this);
    }


    @Override
    public void translate(double v, double v1) {

    }


}