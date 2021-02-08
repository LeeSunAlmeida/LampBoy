package org.academiadecodigo.rapunshells.Player;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerMovement /*implements KeyboardHandler */{
    private Rectangle playerVisual;


    public PlayerMovement(Player player) {
        playerVisual = player.getPlayerVisual();

    }

/*
    public void keyboardMove(Player player) {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                playerVisual.translate(-40, 0);
                break;
            case KeyboardEvent.KEY_RIGHT:
                playerVisual.translate(40, 0);
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
    */
}
