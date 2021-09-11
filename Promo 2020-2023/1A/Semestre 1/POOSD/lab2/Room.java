package iot;

import java.util.ArrayList;

public class Room {

    String name;
    ArrayList<Light> lights;

    public Room(String name) {
        this.name = name;
        this.lights = new ArrayList<>();
    }

    public Room(String name, ArrayList<Light> lights) {
        this.name = name;
        this.lights = lights;
    }

    public void bind(Light light) { if (!this.lights.contains(light)) this.lights.add(light); }

    public void remove(Light light) { this.lights.remove(light); }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Salle : " + getName());
        this.lights.forEach(Light::print);
    }

    public ArrayList<Light> getLights() {
        return lights;
    }
}
