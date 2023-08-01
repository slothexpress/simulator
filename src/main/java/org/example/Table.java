package org.example;

public class Table {
    private int width;
    private int height;

    private Direction direction;

    private int positionX;

    private int positionY;

    private String result;


    public Table(int width, int height, int positionX, int positionY) {
        this.width = width;
        this.height = height;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = Direction.NORTH;
        this.result = "[-1,-1]";
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

    public String getResult() {
        return result;
    }

    public void movePosition(Command command) {
        if(command == Command.QUIT) {
            quitAndPrintResult();
        }
        else
        {
            switch (direction) {
                case NORTH:
                    moveFromNorth(command);
                    break;
                case EAST:
                    moveFromEast(command);
                    break;
                case WEST:
                    moveFromWest(command);
                    break;
                case SOUTH:
                    moveFromSouth(command);
                    break;
                default:
                    break;
            }
        }

    }

    private void quitAndPrintResult() {
        if(positionX < 0 || positionY < 0
                || positionX > width || positionY > height) {
            System.out.println(result);
        }
        else {
            result = "[" + positionX + "," + positionY + "]";
        }
        System.out.println(result);
    }

    private void moveFromSouth (Command command){
        switch (command) {
            case FORWARD:
                positionY = positionY + 1;
                break;
            case BACKWARD:
                positionY = positionY - 1;
                break;
            case ROTATE_CLOCKWISE:
                direction = Direction.WEST;
                break;
            case ROTATE_COUNTERCLOCKWISE:
                direction = Direction.EAST;
                break;
            default:
                break;
        }
    }

    private void moveFromWest(Command command) {
        switch (command) {
            case FORWARD:
                positionX = positionX - 1;
                break;
            case BACKWARD:
                positionX = positionX + 1;
                break;
            case ROTATE_CLOCKWISE:
                direction = Direction.NORTH;
                break;
            case ROTATE_COUNTERCLOCKWISE:
                direction = Direction.SOUTH;
                break;
            default:
                break;
        }
    }

    private void moveFromEast(Command command) {
        switch (command) {
            case FORWARD:
                positionX = positionX + 1;
                break;
            case BACKWARD:
                positionX = positionX - 1;
                break;
            case ROTATE_CLOCKWISE:
                direction = Direction.SOUTH;
                break;
            case ROTATE_COUNTERCLOCKWISE:
                direction = Direction.NORTH;
                break;
            default:
                break;
        }
    }

    private void moveFromNorth (Command command){
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

