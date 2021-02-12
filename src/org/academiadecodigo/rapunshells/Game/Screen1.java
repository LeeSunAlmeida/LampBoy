package org.academiadecodigo.rapunshells.Game;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Screen1 {
    //todo implement 2 Soldiers

    private Picture backGround1;



    public Picture BackGround1(){

        backGround1 = new Picture(Window.getPADDING(), Window.getPADDING(), "spacebackground.jpg");

        backGround1.draw();
        backGround1.grow(75,0);
        backGround1.translate(75,0);


        return backGround1;
    }

    private Picture backGround2;

    public Picture BackGround2() {

        backGround2 = new Picture(Window.getPADDING(), Window.getPADDING(), "background-space.jpg");
        backGround2.draw();
        // backGround2.grow(75,0);
        //backGround2.translate(75,0);


        return backGround2;
    }





}
