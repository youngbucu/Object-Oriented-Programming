package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void optionsParserVerify() {
        String[] testArray = {"f", "l", "gruby", "r", "b", "gruby", "b"};
        MoveDirection[] expectedArray = {MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD};
        Assertions.assertArrayEquals(expectedArray, OptionsParser.parse(testArray));
    }
}
