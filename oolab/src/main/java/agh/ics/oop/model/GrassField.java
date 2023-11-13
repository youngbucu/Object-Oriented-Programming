package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import agh.ics.oop.model.util.MapVisualizer;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();
    private final int mapSize;
    private final Random random = new Random();
    private final MapVisualizer mapVisualizer = new MapVisualizer(this);

    public GrassField(int grassCount) {
        this.mapSize = (int) Math.sqrt(grassCount * 10);

        for (int i = 0; i < grassCount; i++) {
            Vector2d position;
            do {
                position = new Vector2d(random.nextInt(mapSize), random.nextInt(mapSize));
            } while (isOccupied(position));

            grasses.put(position, new Grass(position));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement animal = super.objectAt(position);
        if (animal != null) {
            return animal;
        }
        return grasses.get(position);
    }

    @Override
    public String toString() {
        Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Vector2d position : animals.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }

        for (Vector2d position : grasses.keySet()) {
            lowerLeft = lowerLeft.lowerLeft(position);
            upperRight = upperRight.upperRight(position);
        }

        return mapVisualizer.draw(lowerLeft, upperRight);
    }
}
