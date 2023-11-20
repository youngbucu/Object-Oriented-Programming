package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        try {
            GrassField grassField = new GrassField(10);
            ConsoleMapDisplay observer1 = new ConsoleMapDisplay();
            grassField.addObserver(observer1);

            Vector2d pos1 = new Vector2d(2,2);
            Vector2d pos2 = new Vector2d(7,5);
            Vector2d pos3 = new Vector2d(4, 4);

            List<Vector2d> positions = List.of(pos1, pos2, pos3);

            String[] moves = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
            List<MoveDirection> directions = OptionsParser.parse(moves);

            Simulation simulation = new Simulation(directions, positions, grassField);
            simulation.run();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void run(List<MoveDirection> directions) {
        System.out.println();
        if (!directions.isEmpty()) {  // zmieniamy sprawdzenie z directions.length na directions.isEmpty()
            for (MoveDirection direction : directions) {
                switch (direction) {
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
