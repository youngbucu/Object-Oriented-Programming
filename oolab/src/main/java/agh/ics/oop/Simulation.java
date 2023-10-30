package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> directions;

    public Simulation(List<MoveDirection> directions, List<Vector2d> initialPositions) {
        this.directions = directions;

        for (Vector2d position : initialPositions) {
            animals.add(new Animal(position));
        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            Animal currentAnimal = animals.get(i % numberOfAnimals);
            currentAnimal.move(directions.get(i));
            System.out.println("Zwierzę " + (i % numberOfAnimals + 1) + ": " + currentAnimal.toString());
        }
    }
}

