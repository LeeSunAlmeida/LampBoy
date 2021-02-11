package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.CanShoot;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Guns.Hittable;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class Enemy implements CanShoot, Hittable, Movable{
    protected int health;
    protected Gun gun;
    private final Rectangle enemyVisual;
    private final int charHeight = Window.getCelSizeY() * 6;
    private final int charWidth = Window.getCelSizeX() * 8;
    private final int charStartPointY = Window.getFLOORCOORD() - charHeight;
    private final int charStartPointX;

    public Enemy(int charStartPointX) {
        this.charStartPointX = charStartPointX;
        enemyVisual = new Rectangle(charStartPointX, charStartPointY, charWidth, charHeight);
        enemyVisual.draw();
        enemyVisual.fill();
        enemyVisual.setColor(Color.BLACK);
    }

    @Override
    public void shoot() {
        gun.shootBullet(gun.getBulletDamage());
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean setIsDead(){
        return isDead();
    }

    @Override
    public void hit(Bullet bullet) {

        if (!isDead()) {
            health -= bullet.getDamage();

        }

    }

    public int getCharHeight() {
        return charHeight;
    }

    public int getCharWidth() {
        return charWidth;
    }

    public int getCharStartPointX() {
        return charStartPointX;
    }

    public int getCharStartPointY() {
        return charStartPointY;
    }

    public Rectangle getEnemyVisual() {
        return enemyVisual;
    }

}
