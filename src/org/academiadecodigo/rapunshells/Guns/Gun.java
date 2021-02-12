package org.academiadecodigo.rapunshells.Guns;

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
    public int gunHeightStart = 2 * Window.getCelSizeY(); //starting pos of gun
    public int gunHeightDelta = 3 * Window.getCelSizeY(); //diff position between stand and duck
    public int gunWidthDelta = Window.getCelSizeX() * 8 + gunSize; //diff position between facing right and left

    public Gun(int bulletDmg, int shootSpeed, Player player) {
        this.bulletDamage = bulletDmg;
        this.shootSpeed = shootSpeed;
        this.player = player;
        gunVisualDrawPlayer();
    }

    public Gun(int bulletDamage, int shootSpeed, Enemy enemy) {
        this.bulletDamage = bulletDamage;
        this.shootSpeed = shootSpeed;
        this.enemy = enemy;
        gunVisualDrawEnemy();
    }

    public void gunVisualDrawPlayer() {
        gunVisual = new Rectangle(player.getCharStartPointX() + player.getCharWidth(), player.getCharStartPointY() + gunHeightStart, gunSize, gunSize);
        gunVisual.draw();
        gunVisual.fill();
        gunVisual.setColor(Color.BLUE);
    }

    public void gunVisualDrawEnemy() {
        gunVisual = new Rectangle(enemy.getCharStartPointX(), enemy.getCharStartPointY() + gunHeightStart, gunSize,gunSize);
        gunVisual.draw();
        gunVisual.fill();
        gunVisual.setColor(Color.BLUE);
    }

    public void gunVisualUpdate(boolean lastFrameStand, boolean lastFrameFacedRight) {
        if(lastFrameStand != player.isStand() && lastFrameFacedRight != player.isFacedRight()) {
        gunVisualDuckUnduck();
        gunVisualLeftRight();
        } else if (lastFrameStand != player.isStand()) {
            gunVisualDuckUnduck();
        } else if (lastFrameFacedRight != player.isFacedRight()) {
            gunVisualLeftRight();
        }
    }

    public void gunVisualDuckUnduck() {
        if(!player.isStand()) {
            gunVisual.translate(0, gunHeightDelta);
        } else if(player.isStand()) {
            gunVisual.translate(0, - gunHeightDelta);
        }
    }

    public void gunVisualJump() {
        int jumpHeight = player.getJumpHeight();
        int currentIteration = player.getCurrentIteration();
        if (currentIteration < jumpHeight) {
            gunVisual.translate(0, -Window.getCelSizeY());
        } else if (currentIteration < jumpHeight * 2) {
            gunVisual.translate(0, Window.getCelSizeY());
        }
    }

    public void gunVisualLeftRight() {
        if(player.isFacedRight()) {
            gunVisual.translate(gunWidthDelta, 0);
        } else if(!player.isFacedRight()) {
            gunVisual.translate(- gunWidthDelta, 0);
        }
    }

    public void shootBullet(int bulletDamage) {
        System.out.println("gun.shootBullet() Method");
        new Bullet(bulletDamage, this);
        //todo number of turns between each shot
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public Player getPlayer() {
        return player;
    }
}

