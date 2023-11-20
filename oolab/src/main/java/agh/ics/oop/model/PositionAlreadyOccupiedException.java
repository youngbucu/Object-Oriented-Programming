package agh.ics.oop.model;

public class PositionAlreadyOccupiedException extends Exception {

    public PositionAlreadyOccupiedException(Vector2d vector){
        super("Position" + vector.toString() + "is already occupied");
    }
}
