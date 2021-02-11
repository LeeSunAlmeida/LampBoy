package org.academiadecodigo.rapunshells.Enemies;

import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Player.Player;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Soldier extends Enemy {

    private Rectangle soldierVisual;
    private int charHeight = Window.getCelSizeY() * 6;
    private int charWidth = Window.getCelSizeX() * 8;
    private int charStartPointX = 1200;
    private int charStartPointY = Window.getFLOORCOORD() - charHeight;

    public Soldier() {
        health = 100;
        gun = new Gun(10, 500, this);
        soldierVisual = new Rectangle(charStartPointX,charStartPointY,charWidth,charHeight);
        soldierVisual.draw();
        soldierVisual.fill();
        soldierVisual.setColor(Color.BLACK);
        while(health>0) {
            for(int i=0; i<10; i++) {
                this.translate(1,0);
                this.translate(1,0);
                this.translate(1,0);
                this.shoot();
            }
        }
    }

    @Override
    public void hit(Bullet bullet) {

    }

    @Override
    public void translate(double v, double v1) {

    }

    public Rectangle getSoldierVisual() {
        return soldierVisual;
    }
}