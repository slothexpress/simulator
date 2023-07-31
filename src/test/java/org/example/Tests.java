package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {

    @Test
    public void createTableWithWidthAndHeight() {
        Table sut = new Table(4, 9);

        Assertions.assertEquals(4, sut.getWidth());
        Assertions.assertEquals(9, sut.getHeight());
    }
}
