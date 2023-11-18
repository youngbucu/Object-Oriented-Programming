package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("Start");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));

        RectangularMap rectangularMap = new RectangularMap(10, 10);

        Simulation simulation = new Simulation(directions, positions, rectangularMap);
        simulation.run();

        System.out.println("Stop");
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
