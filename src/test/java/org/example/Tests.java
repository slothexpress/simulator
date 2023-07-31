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
        sut.move(Command.FORWARD);

        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(6, sut.getPositionY());
    }

    @Test
    public void movePositionBackward() {
        sut.move(Command.BACKWARD);

        Assertions.assertEquals(2, sut.getPositionX());
        Assertions.assertEquals(8, sut.getPositionY());
    }


}
