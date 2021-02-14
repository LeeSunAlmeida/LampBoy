package org.academiadecodigo.rapunshells;

public class Window {
    private static final int PADDING = 10;

    private static final int COLS = 170;
    private static final int ROWS = 24;

    private static final int CELLSIZEX = 8;
    private static final int CELLSIZEY = 25;

    private static int height = ROWS * CELLSIZEY -1;
    private static int width = COLS * CELLSIZEX -1;

    private static final int FLOORCOORD = height - CELLSIZEY * 4;

    private static final int charHeight = 230;
    private static final int charWidth = 142;

    public static int getCols() {
        return COLS;
    }

    public static int getRows() {
        return ROWS;
    }

    public static int getCelSizeX() {
        return CELLSIZEX;
    }

    public static int getCelSizeY() {
        return CELLSIZEY;
    }

    public static int getHeight(){
        return height;
    }

    public static int getWidth(){
        return width;
    }

    public static int getPADDING(){
        return PADDING;
    }

    public static int getFLOORCOORD() {
        return FLOORCOORD;
    }

    public static int getCharHeight() {
        return charHeight;
    }

    public static int getCharWidth() {
        return charWidth;
    }
}
