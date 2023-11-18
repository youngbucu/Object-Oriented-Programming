package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.Map;
import java.util.HashMap;

public class RectangularMap implements WorldMap<Animal, Vector2d> {
    private Map<Vector2d, Animal> animals = new HashMap<>();

    private final int height;
    private final int width;

    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public RectangularMap(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(width, height)) && position.precedes(new Vector2d(0, 0)) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animals.containsValue(animal)) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
