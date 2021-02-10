package org.academiadecodigo.rapunshells.Player;

import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Grid.Position;
import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.CanShoot;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Guns.Hittable;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements CanShoot, Hittable, Movable, KeyboardHandler {
    private int health;
    private Gun gun;
    private int charHeight = Window.getCelSizeY() * 6;
    private int charWidth = Window.getCelSizeX() * 8;
    private int charStartPointX = Window.getPADDING() + 10;
    private int charStartPointY = Window.getFLOORCOORD() - charHeight;
    private boolean stand = true;
    private boolean facedRight = true;

    private Rectangle playerVisual;

    public Player(){
        health = 100;
        gun = new Gun(10, 500,this);
        playerVisual = new Rectangle(charStartPointX, charStartPointY, charWidth, charHeight);
        playerVisual.draw();
        playerVisual.fill();
        playerVisual.setColor(Color.MAGENTA);
        keyboardMove();
    }

    //todo martelo
    public void keyboardMove() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent shoot = new KeyboardEvent();
        shoot.setKey(KeyboardEvent.KEY_SPACE);
        shoot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shoot);

        KeyboardEvent jump = new KeyboardEvent();
        jump.setKey(KeyboardEvent.KEY_UP);
        jump.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(jump);

        KeyboardEvent duck = new KeyboardEvent();
        duck.setKey(KeyboardEvent.KEY_DOWN);
        duck.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(duck);

        KeyboardEvent unDuck = new KeyboardEvent();
        unDuck.setKey(KeyboardEvent.KEY_DOWN);
        unDuck.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(unDuck);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                playerVisual.translate(-Window.getCelSizeX(), 0);
                gun.gunVisual.translate(-Window.getCelSizeX(), 0);
                if(facedRight) {
                    gun.gunVisualUpdate(stand, true);
                }
                facedRight = false;
                break;
            case KeyboardEvent.KEY_RIGHT:
                playerVisual.translate(Window.getCelSizeX(), 0);
                gun.gunVisual.translate(Window.getCelSizeX(), 0);
                if(!facedRight) {
                    gun.gunVisualUpdate(stand, false);
                }
                facedRight = true;
                break;
            case KeyboardEvent.KEY_SPACE:
                this.shoot();
                break;
            case KeyboardEvent.KEY_UP:
                try {
                    jumpEvent();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if(stand) {
                    stand = false;
                    System.out.println("I'm ducked");
                    double duckHeight = (Window.getCelSizeY() * 1.5);
                    playerVisual.grow(0, -duckHeight);
                    playerVisual.translate(0, duckHeight);
                    gun.gunVisualUpdate(true, facedRight);
                    break;
                }
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                if(!stand) {
                    stand = true;
                    System.out.println("I'm standing");
                    double duckHeight = (Window.getCelSizeY() * 1.5);
                    playerVisual.grow(0, duckHeight);
                    playerVisual.translate(0, -duckHeight);
                    gun.gunVisualUpdate(false, facedRight);
                    break;
                }
        }

    }
    //todo end martelo



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void jumpEvent() throws InterruptedException {
        int jumpHeight = 6;

        for (int i = 0; i < jumpHeight; i++) {
            playerVisual.translate(0, -Window.getCelSizeY());
            //todo Thread.sleep(200);
        }

        for (int i = 0; i < jumpHeight; i++) {
            playerVisual.translate(0, Window.getCelSizeY());
            //todo Thread.sleep(200);
        }

    }

    @Override
    public void shoot() {
        gun.shootBullet(gun.getBulletDamage());
    }

    public boolean isDead() {

        return health <= 0;
    }

    public boolean getIsDead(){
        return isDead();
    }


    @Override
    public void hit(Bullet bullet) {
        health -= bullet.getDamage();
        if (isDead()) {
            Game.gameOver();
        }

    }

    @Override
    public void translate(double v, double v1) {

    }

    public Rectangle getPlayerVisual() {
        return playerVisual;
    }

    public int getCharStartPointX() {
        return charStartPointX;
    }

    public int getCharStartPointY() {
        return charStartPointY;
    }

    public int getCharWidth() {
        return charWidth;
    }

    public int getCharHeight() {
        return charHeight;
    }

    public boolean isFacedRight() {
        return facedRight;
    }

    public boolean isStand() {
        return stand;
    }
}
