package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {

    @Test
    public void testPlaceAndMove() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 2));

        assertTrue(map.place(animal));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertEquals(animal, map.objectAt(new Vector2d(2, 2)));

        map.move(animal, MoveDirection.FORWARD);
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

}

