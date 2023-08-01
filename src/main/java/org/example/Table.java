package org.example;

public class Table {
    private int width;
    private int height;

    private Direction direction;

    private int positionX;

    private int positionY;

    public Table(int width, int height, int positionX, int positionY) {
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
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

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void move(Command command) {
        switch (direction) {
            case NORTH:
                moveFromNorth(command);
                break;
            default:
                break;
        }
    }

    private void moveFromNorth(Command command) {
        switch (command) {
            case FORWARD:
                positionY = positionY - 1;
                break;
            case BACKWARD:
                positionY = positionY + 1;
                break;
            case ROTATE_CLOCKWISE:
                direction = Direction.EAST;
                break;
            case ROTATE_COUNTERCLOCKWISE:
                direction = Direction.WEST;
                break;
            default:
                break;
        }
    }

}
