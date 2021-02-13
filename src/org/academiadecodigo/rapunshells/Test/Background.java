package org.academiadecodigo.rapunshells.Test;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {


    private Picture backGround1;
    private Picture backGround2;
    private Picture backGround3;


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
        backGround2.grow(10,10);
        backGround2.translate(Window.getPADDING(),Window.getPADDING());


        return backGround2;
    }


    public Picture BackGround3() {

        backGround3 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-milicia.jpg");
        backGround3.draw();
        backGround3.grow(47,10);
        backGround3.translate(Window.getPADDING() + 37, Window.getPADDING());


        return backGround3;
    }

}

