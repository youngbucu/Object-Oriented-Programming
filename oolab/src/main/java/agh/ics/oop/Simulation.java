package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> directions;

    private final WorldMap<Animal, Vector2d> worldMap;

    public Simulation(List<MoveDirection> directions, List<Vector2d> initialPositions, WorldMap<Animal, Vector2d> worldMap) {
        this.directions = directions;
        this.worldMap = worldMap;

        for (Vector2d position : initialPositions) {
            Animal animal = new Animal(position);
            if (worldMap.place(animal)) {
                animals.add(animal);
            }
        }
    }

    public void run() {
        int numberOfAnimals = animals.size();
        for (int i = 0; i < directions.size(); i++) {
            Animal currentAnimal = animals.get(i % numberOfAnimals);
            worldMap.move(currentAnimal, directions.get(i));
            System.out.println("Zwierzę " + (i % numberOfAnimals + 1) + ": " + currentAnimal.toString());
            System.out.println(worldMap.toString());
        }
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
