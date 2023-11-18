package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap extends AbstractWorldMap {
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
    public String toString() {
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(width, height));
    }
}
