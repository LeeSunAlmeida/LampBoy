package org.academiadecodigo.rapunshells.Guns;

import org.academiadecodigo.rapunshells.Enemies.ArmoredSoldier;
import org.academiadecodigo.rapunshells.Enemies.Milicia;
import org.academiadecodigo.rapunshells.Enemies.Soldier;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.rapunshells.Enemies.Enemy;

public class Gun {
    private int bulletDamage;
    private int shootSpeed;
    private Player player;
    private Enemy enemy;
    public Rectangle gunVisual;
    public int gunSize = 10;
    public int gunHeightStand = 3 * Window.getCelSizeY();
    public int gunHeightDuck = Window.getCelSizeY();

    public Gun(int bulletDmg, int shootSpeed, Player player) {
        this.bulletDamage = bulletDmg;
        this.shootSpeed = shootSpeed;
        this.player = player;
        if(player.isFacedRight() && player.isStand()) {
            gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + gunHeightStand, gunSize, gunSize);
        } else if (player.isFacedRight() && !player.isStand()) {
            gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + gunHeightDuck, gunSize, gunSize);
        } else if (!player.isFacedRight() && player.isStand()) {
            gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + gunHeightStand, gunSize, gunSize);
        } else if (!player.isFacedRight() && !player.isStand()) {
            gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + gunHeightDuck, gunSize, gunSize);
        }
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

