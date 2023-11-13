package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        GrassField grassField = new GrassField(10);

        Animal animal = new Animal(new Vector2d(2, 2));
        grassField.place(animal);

        String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(moves);

        for (MoveDirection direction : directions) {
            grassField.move(animal, direction);
            System.out.println(animal);
            System.out.println(grassField);
        }
    }

    public static void run(List<MoveDirection> directions) {
        System.out.println();
        if (!directions.isEmpty()) {  // zmieniamy sprawdzenie z directions.length na directions.isEmpty()
            for (MoveDirection direction: directions) {
                switch (direction){
                    case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                    case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                    case RIGHT -> System.out.println("Zwierzak idzie w prawo");
                    case LEFT -> System.out.println("Zwierzak idzie w lewo");
                }
            }
            System.out.println();
        }
    }
}
