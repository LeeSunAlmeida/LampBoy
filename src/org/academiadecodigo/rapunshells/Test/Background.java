package org.academiadecodigo.rapunshells.Test;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture intro;
    private Picture backGround1;
    private Picture backGround2;
    private Picture backGround3;
    private Rectangle playerLifeBarr;
    private Rectangle enemyLifeBarr;


    public Picture Intro() {

        intro = new Picture(Window.getPADDING(), Window.getPADDING(), "background-room.jpg");


        intro.draw();
        intro.grow(20, 5);
        intro.translate(20, 5);

        return intro;

    }


    public Picture BackGround1() {

        backGround1 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-mars.jpg");

        backGround1.draw();
        backGround1.grow(80, 0);
        backGround1.translate(80, 0);

        return backGround1;

    }


    public Picture BackGround2() {

        backGround2 = new Picture(Window.getPADDING(), Window.getPADDING(), "space-background.jpg");
        backGround2.draw();
        backGround2.grow(10, 10);
        backGround2.translate(Window.getPADDING(), Window.getPADDING());


        return backGround2;
    }


    public Picture BackGround3() {

        backGround3 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-milicia.jpg");
        backGround3.draw();
        backGround3.grow(47, 10);
        backGround3.translate(Window.getPADDING() + 37, Window.getPADDING());


        return backGround3;
    }

    public Rectangle PlayerLifeBarr() {


        Rectangle playerLifeBarr = new Rectangle(134, 60, 300, 40);

        playerLifeBarr.draw();
        playerLifeBarr.fill();
        playerLifeBarr.setColor(Color.GREEN);

        return playerLifeBarr;
    }


    public Rectangle EnemyLifeBarr() {


        Rectangle enemyLifeBarr = new Rectangle(134, 60, 1200, 540);

        enemyLifeBarr.draw();
        enemyLifeBarr.fill();
        enemyLifeBarr.setColor(Color.GREEN);

        return enemyLifeBarr;
    }

}

