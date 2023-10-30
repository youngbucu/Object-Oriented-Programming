package agh.ics.oop.model;


import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimulationIntegrationTest {

    @Test
    public void testAnimalOrientationAfterMoves() {
        Animal animal = new Animal(); // for comparison
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.LEFT);

        assertEquals(animal.getDirection(), MapDirection.SOUTH);
    }

    @Test
    public void testAnimalPositionAfterMoves() {
        Animal animal = new Animal(); // for comparison
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.BACKWARD);

        assertEquals(new Vector2d(3, 2), animal.getPosition());
    }

    @Test
    public void testAnimalStaysWithinMapBoundaries() {
        Animal animal = new Animal(); // for comparison
        for (int i = 0; i < 7; i++) {
            animal.move(MoveDirection.FORWARD);
        }

        Assertions.assertEquals(animal.getPosition(), new Vector2d(2, 4));
    }

    @Test
    public void testInputParsing() {
        String[] testArgs = {"f", "b", "l", "r", "r", "l"};
        List<MoveDirection> parsedDirections = OptionsParser.parse(testArgs);

        Assertions.assertEquals(List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.LEFT), parsedDirections);
    }
}
