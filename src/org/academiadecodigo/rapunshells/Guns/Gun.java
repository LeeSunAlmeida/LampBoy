package org.academiadecodigo.rapunshells.Guns;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.rapunshells.Enemies.Enemy;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Gun {
    private int bulletDamage;
    private int shootSpeed;
    private Player player;
    private Enemy enemy;
    private Rectangle gunVisual;
    public int gunSize = 10;
    public int gunHeightStart = 5 * Window.getCelSizeY();
    public int gunHeightDelta = 2 * Window.getCelSizeY();
    public int gunWidthDelta;

    public Gun(int bulletDmg, int shootSpeed, Player player) {
        this.gunWidthDelta = Window.getCelSizeX() * 8 + this.gunSize;
        this.bulletDamage = bulletDmg;
        this.shootSpeed = shootSpeed;
        this.player = player;
        this.gunVisualDrawPlayer();
    }

    public Gun(int bulletDamage, int shootSpeed, Enemy enemy) {
        this.gunWidthDelta = Window.getCelSizeX() * 8 + this.gunSize;
        this.bulletDamage = bulletDamage;
        this.shootSpeed = shootSpeed;
        this.enemy = enemy;
        this.gunVisualDrawEnemy();
    }

    public void gunVisualDrawPlayer() {
        this.gunVisual = new Rectangle((double)(this.player.getCharStartPointX() + this.player.getCharWidth()),
                (double)(this.player.getCharStartPointY() + this.gunHeightStart), (double)this.gunSize, (double)this.gunSize);
    }

    public void gunVisualDrawEnemy() {
        this.gunVisual = new Rectangle((double)this.enemy.getCharStartPointX(),
                (double)(this.enemy.getCharStartPointY() + this.gunHeightStart), (double)this.gunSize, (double)this.gunSize);
    }

    public void gunVisualUpdate(boolean lastFrameStand, boolean lastFrameFacedRight) {
        if (lastFrameStand != this.player.isStand() && lastFrameFacedRight != this.player.isFacedRight()) {
            this.gunVisualDuckUnduck();
            this.gunVisualLeftRight();
        } else if (lastFrameStand != this.player.isStand()) {
            this.gunVisualDuckUnduck();
        } else if (lastFrameFacedRight != this.player.isFacedRight()) {
            this.gunVisualLeftRight();
        }
    }

    public void gunVisualDuckUnduck() {
        if (!this.player.isStand()) {
            this.gunVisual.translate(0.0D, (double)this.gunHeightDelta);
        } else if (this.player.isStand()) {
            this.gunVisual.translate(0.0D, (double)(-this.gunHeightDelta));
        }
    }

    public void gunVisualJump() {
        int jumpHeight = this.player.getJumpHeight();
        int currentIteration = this.player.getCurrentIteration();
        if (currentIteration < jumpHeight) {
            this.gunVisual.translate(0.0D, (double)(-Window.getCelSizeY()));
        } else if (currentIteration < jumpHeight * 2) {
            this.gunVisual.translate(0.0D, (double)Window.getCelSizeY());
        }
    }

    public void gunVisualLeftRight() {
        if (this.player.isFacedRight()) {
            this.gunVisual.translate((double)this.gunWidthDelta, 0.0D);
        } else if (!this.player.isFacedRight()) {
            this.gunVisual.translate((double)(-this.gunWidthDelta), 0.0D);
        }
    }

    public void shootBullet(int bulletDamage) {
        System.out.println("gun.shootBullet() Method");
        new Bullet(bulletDamage, this);
    }

    public int getBulletDamage() {
        return this.bulletDamage;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Rectangle getGunVisual() {
        return gunVisual;
    }
}
