package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void testPlaceAndMove() {
        RectangularMap map = new RectangularMap(10, 10);
        Animal animal = new Animal();

        assertTrue(map.place(animal));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertEquals(new Vector2d(2, 2), animal.getPosition());

        map.move(animal, MoveDirection.FORWARD);
        System.out.println(map.toString());
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
        assertEquals(new Vector2d(2, 3), animal.getPosition());

    }
}
