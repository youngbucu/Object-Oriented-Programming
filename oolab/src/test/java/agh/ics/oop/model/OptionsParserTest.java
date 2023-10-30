package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OptionsParserTest {
    @Test
    public void optionsParserVerify() {
        String[] testArray = {"f", "l", "gruby", "r", "b", "gruby", "b"};
        List<MoveDirection> expectedList = Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD);
        Assertions.assertEquals(expectedList, OptionsParser.parse(testArray));
    }
}

