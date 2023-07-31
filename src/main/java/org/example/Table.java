package org.example;

public class Table {
    private int width;
    private int height;

    private Direction direction;

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
        this.direction = Direction.NORTH;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getDirection() {
        return direction;
    }
}
