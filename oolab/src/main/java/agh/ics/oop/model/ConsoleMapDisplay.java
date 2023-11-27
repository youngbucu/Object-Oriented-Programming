package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    public int counter = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message){
        System.out.println(message);
        System.out.println(worldMap.toString());
        counter += 1;
        System.out.println(counter + " changes so far");
        System.out.println(worldMap.getId());
    }
}
