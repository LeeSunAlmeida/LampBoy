package org.academiadecodigo.rapunshells.Player;

import org.academiadecodigo.rapunshells.Enemies.Enemy;
import org.academiadecodigo.rapunshells.Game.Game;
import org.academiadecodigo.rapunshells.Game.Order;
import org.academiadecodigo.rapunshells.Guns.Bullet;
import org.academiadecodigo.rapunshells.Guns.Gun;
import org.academiadecodigo.rapunshells.Guns.Hittable;
import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;



public class Player implements Hittable, Movable, KeyboardHandler {

    private int health;
    private Gun gun;

    private int charHeight = Window.getCelSizeY() * 6;
    private int charWidth = Window.getCelSizeX() * 8;

    private int charStartPointX = Window.getPADDING() + 10;
    private int charStartPointY = Window.getFLOORCOORD() - charHeight;

    private boolean stand = true;
    private boolean facedRight = true;
    private boolean jumping = false;
    private int currentIteration = 0;
    private static final String[] playerOrders = {"playerJump", "playerDuck", "playerUnduck", "playerLeft", "playerRight", "playerShoot"};

    private Picture playerVisual;
    private int jumpHeight = 6;



    public Player() {
        health = 100;
        keyboardMove();

    }

    public void translate(double v, double v1) {

    }

    public void drawPlayer() {
        gun = new Gun(10, 0, this);
        playerVisual = new Picture(charStartPointX, charStartPointY, "lamp-boy.png");
        playerVisual.draw();
    }

    //Keyboard Methods
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
                if(playerVisual.getX() > Window.getPADDING() * 2) {
                    moveLeft();
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if(playerVisual.getMaxX() < Window.getWidth()) {
                    moveRight();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                Game.orderList.add(new Order(playerOrders[5], this));
                break;
            case KeyboardEvent.KEY_UP:
                Game.orderList.add(new Order(playerOrders[0], this));
                break;
            case KeyboardEvent.KEY_DOWN:
                duck();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_DOWN:
                unDuck();
                break;
        }
    }

    //Hit Mechanic
    @Override
    public void hit(Bullet bullet) {
        int damage = bullet.getDamage();
        health -= damage;
        if (isDead()) {
            Game.gameOver();
        }
        //Background.getPlayerLifeGreen().grow(-(damage * 0.5), 0);
        //Background.getPlayerLifeGreen().translate(-(damage * 0.5), 0);
        //TODO Implement
    }


    //Getters
    public Picture getPlayerVisual() {
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

    public boolean isFacedRight() {
        return facedRight;
    }

    public boolean isStand() {
        return stand;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean isJumping() {
        return jumping;
    }

    public static String[] getPlayerOrders() {
        return playerOrders;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getCurrentIteration() {
        return currentIteration;
    }

    public Gun getGun() {
        return gun;
    }

    //Orders Zone

    public void moveLeft() {
        playerVisual.translate(-Window.getCelSizeX(), 0);
        gun.getGunVisual().translate(-Window.getCelSizeX(), 0);
        if (facedRight) {
            gun.gunVisualUpdate(stand, true);
        }
        facedRight = false;
    }

    public void moveRight() {
        playerVisual.translate(Window.getCelSizeX(), 0);
        gun.getGunVisual().translate(Window.getCelSizeX(), 0);
        if (!facedRight) {
            gun.gunVisualUpdate(stand, false);
        }
        facedRight = true;
    }

    public void shoot() {
        gun.shootBullet(gun.getBulletDamage());
        System.out.println("shoot() Method");
    }

    public void duck() {
        if (stand) {
            stand = false;
            double duckHeight = (Window.getCelSizeY() * 1.5);
            playerVisual.grow(0, -duckHeight);
            playerVisual.translate(0, duckHeight);
            gun.gunVisualUpdate(true, facedRight);
        }
    }

    public void unDuck() {
        if (!stand) {
            stand = true;
            double duckHeight = (Window.getCelSizeY() * 1.5);
            playerVisual.grow(0, duckHeight);
            playerVisual.translate(0, -duckHeight);
            gun.gunVisualUpdate(false, facedRight);
        }
    }

    public int getCharHeight() {
        return charHeight;
    }

    public void jumpEvent() {

        if (jumping) {
            if (currentIteration == jumpHeight * 2) {
                currentIteration = 0;
                jumping = false;
            } else if (currentIteration < jumpHeight) {
                playerVisual.translate(0, -Window.getCelSizeY());
                currentIteration++;
            } else if (currentIteration < jumpHeight * 2) {
                playerVisual.translate(0, Window.getCelSizeY());
                currentIteration++;
            }
        }
    }

    public void jumpStart() {
        jumping = true;
    }

}

