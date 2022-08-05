package iot;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeDashboard {

    HashMap<String,Room> rooms;
    ArrayList<LightSwitch> lightSwitches;

    public HomeDashboard() {
        this.rooms = new HashMap<>();
        this.lightSwitches = new ArrayList<>();
    }

    public void bind(Room room) { if (!this.rooms.containsKey(room.getName())) this.rooms.put(room.getName(), room); }

    public void removeRoom(Room room) { this.rooms.remove(room.getName()); }

    public void installLight(Room room, Light light) {
        if (this.rooms.containsKey(room.getName())) {
            room.bind(light);
        }
    }

    public void uninstallLight(Room room, Light light) {
        if (this.rooms.containsKey(room.getName())) {
            room.remove(light);
        }
    }

    public void bind(LightSwitch lightSwitch) { if (!this.lightSwitches.contains(lightSwitch)) this.lightSwitches.add(lightSwitch); }

    public void removeLightSwitch(LightSwitch lightSwitch) { this.lightSwitches.remove(lightSwitch); }

    public void turnOn(Room room) {
        if (this.rooms.containsKey(room.getName())) room.getLights().forEach(Light::turnOn);
    }

    public void turnOff(Room room) {
        if (this.rooms.containsKey(room.getName())) room.getLights().forEach(Light::turnOff);
    }

    public void disconnectLight(Light light) {
        for (LightSwitch lightSwitch : this.lightSwitches) lightSwitch.removeLight(light);
    }

    public void print() {
        this.rooms.forEach((s, room) -> room.print());
        this.lightSwitches.forEach(LightSwitch::print);
    }

}
