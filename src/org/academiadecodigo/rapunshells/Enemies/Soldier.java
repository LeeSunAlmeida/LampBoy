package org.academiadecodigo.rapunshells.Enemies;
import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Soldier extends Enemy {
    private Rectangle soldierVisual;
    private final int charHeight = Window.getCelSizeY() * 6;
    private final int charWidth = Window.getCelSizeX() * 8;
    private int charStartPointX;
    private int charStartPointY = Window.getFLOORCOORD() - charHeight;

    public Soldier(int charStarPointX) {
        this.charStartPointX = charStarPointX;
        health = 100;
        gun = new Gun(10, 500, this);
        soldierVisual = new Rectangle(charStartPointX, charStartPointY, charWidth, charHeight);
        soldierVisual.draw();
        soldierVisual.fill();
        soldierVisual.setColor(Color.BLACK);
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