package org.academiadecodigo.rapunshells.Grid;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {



    public Grid() {

        Rectangle grid = new Rectangle(Window.getPADDING(), Window.getPADDING(), Window.getWidth(), Window.getHeight());
        grid.draw();

    }
}
