package org.academiadecodigo.rapunshells.Environment;

import org.academiadecodigo.rapunshells.Window;
import org.academiadecodigo.simplegraphics.graphics.Line;

public class Foreground {

    public static void drawFloor() {
        Line floor = new Line(Window.getPADDING(), Window.getFLOORCOORD(), Window.getWidth() + Window.getPADDING(), Window.getFLOORCOORD());
        floor.draw();
    }
}
