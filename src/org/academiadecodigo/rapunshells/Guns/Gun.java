package org.academiadecodigo.rapunshells.Guns;

import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.rapunshells.Enemies.Enemy;

public class Gun {
    private int bulletDamage;
    private int shootSpeed;
    private Player player;
    private Enemy enemy;
    public Rectangle gunVisual;

    public Gun(int bulletDmg, int shootSpeed, Player player) {
        this.bulletDamage = bulletDmg;
        this.shootSpeed = shootSpeed;
        this.player = player;
        gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + 15, 10, 10);
        gunVisual.draw();
        gunVisual.fill();
        gunVisual.setColor(Color.BLUE);
    }

    public Gun(int bulletDamage, int shootSpeed, Enemy enemy) {
        this.bulletDamage = bulletDamage;
        this.shootSpeed = shootSpeed;
        this.enemy = enemy;
        // needs to be finished
    }
    //shootBullets
    public Bullet shootBullet(int bulletDamage) {
        return new Bullet(bulletDamage, this);
    }

    public int getBulletDamage() {
        return bulletDamage;
    }


}

// todo on space, call shootBullets() once every shootspeed seconds

