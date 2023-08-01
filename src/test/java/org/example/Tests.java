package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tests {

    Table sut;

    @BeforeEach
    public void setup() {
        sut = new Table(4, 9, 2, 7);;
    }

    @Test
    public void createTableWithWidthAndHeight() {
        Assertions.assertEquals(4, sut.getWidth());
        Assertions.assertEquals(9, sut.getHeight());
    }

    @Test
    public void createTableWithPosition() {
        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(7, sut.getPositionY());
    }

    @Test
    public void createTableWithDirectionNorthAsDefault() {
        Assertions.assertEquals(Direction.NORTH, sut.getDirection());
    }

    @Test
    public void movePositionForward() {
        sut.movePosition(Command.FORWARD);

        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(6, sut.getPositionY());
    }

    @Test
    public void movePositionBackward() {
        sut.movePosition(Command.BACKWARD);

        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(8, sut.getPositionY());
    }

    @Test
    public void rotateClockWise() {
        sut.movePosition(Command.ROTATE_CLOCKWISE);

        Assertions.assertEquals(Direction.EAST, sut.getDirection());
    }

    @Test
    public void rotateCounterClockWise() {
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);

        Assertions.assertEquals(Direction.WEST, sut.getDirection());
    }

    @Test
    public void rotateClockWiseAndMoveForward() {
        sut.movePosition(Command.ROTATE_CLOCKWISE);
        sut.movePosition(Command.FORWARD);

        Assertions.assertEquals(Direction.EAST, sut.getDirection());
        Assertions.assertEquals(3, sut.getPositionX());
        Assertions.assertEquals(7, sut.getPositionY());
    }

    @Test
    public void rotateClockWiseAndMoveBackward() {
        sut.movePosition(Command.ROTATE_CLOCKWISE);
        sut.movePosition(Command.BACKWARD);

        Assertions.assertEquals(Direction.EAST, sut.getDirection());
        Assertions.assertEquals(1, sut.getPositionX());
        Assertions.assertEquals(7, sut.getPositionY());
    }

    @Test
    public void rotateCounterClockWiseAndMoveForward() {
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);
        sut.movePosition(Command.FORWARD);

        Assertions.assertEquals(Direction.WEST, sut.getDirection());
        Assertions.assertEquals(1, sut.getPositionX());
        Assertions.assertEquals(7, sut.getPositionY());
    }

    @Test
    public void rotateCounterClockWiseAndMoveBackward() {
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);
        sut.movePosition(Command.BACKWARD);

        Assertions.assertEquals(Direction.WEST, sut.getDirection());
        Assertions.assertEquals(3, sut.getPositionX());
        Assertions.assertEquals(7, sut.getPositionY());
    }

    @Test
    public void rotateFromNorthToSouthAndMoveForward() {
        sut.movePosition(Command.ROTATE_CLOCKWISE);
        sut.movePosition(Command.ROTATE_CLOCKWISE);
        sut.movePosition(Command.FORWARD);

        Assertions.assertEquals(Direction.SOUTH, sut.getDirection());
        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(8, sut.getPositionY());
    }

    @Test
    public void rotateFromNorthToSouthAndMoveBackward() {
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);
        sut.movePosition(Command.BACKWARD);

        Assertions.assertEquals(Direction.SOUTH, sut.getDirection());
        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(6, sut.getPositionY());
    }

    @Test
    public void failedSimulationOutOfBoundsOnX() {
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);
        sut.movePosition(Command.FORWARD);
        sut.movePosition(Command.FORWARD);
        sut.movePosition(Command.QUIT);

        Assertions.assertSame("[-1,-1]", sut.getResult());
    }

    @Test
    public void failedSimulationOutOfBoundsOnY() {
        sut.movePosition(Command.BACKWARD);
        sut.movePosition(Command.BACKWARD);
        sut.movePosition(Command.BACKWARD);
        sut.movePosition(Command.QUIT);

        Assertions.assertSame("[-1,-1]", sut.getResult());
    }

    @Test
    public void successfulSimulationExample() {
        // This uses the example from the task description on page 3
        sut = new Table(4, 4, 2, 2);

        // Commands: 1,4,1,3,2,3,2,4,1,0
        sut.movePosition(Command.FORWARD);
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);

        sut.movePosition(Command.FORWARD);
        sut.movePosition(Command.ROTATE_CLOCKWISE);

        sut.movePosition(Command.BACKWARD);
        sut.movePosition(Command.ROTATE_CLOCKWISE);

        sut.movePosition(Command.BACKWARD);
        sut.movePosition(Command.ROTATE_COUNTERCLOCKWISE);

        sut.movePosition(Command.FORWARD);
        sut.movePosition(Command.QUIT);

        Assertions.assertEquals("[0,1]", sut.getResult());
    }

}
