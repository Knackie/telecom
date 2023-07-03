package iot;

import java.util.ArrayList;

public class Dashboard {

    private ArrayList<Light> lights;
    private ArrayList<LightSwitch> lightSwitches;

    public Dashboard() {
        this.lights = new ArrayList<>();
        this.lightSwitches = new ArrayList<>();
    }

    public void bind(Light light) { if (!this.lights.contains(light)) this.lights.add(light); }

    public void bind(LightSwitch lightSwitch) { if (!this.lightSwitches.contains(lightSwitch)) this.lightSwitches.add(lightSwitch); }

    public void remove(Light light) { this.lights.remove(light); }

    public void remove(LightSwitch lightSwitch) {
        lightSwitch.removeAll();
        this.lightSwitches.remove(lightSwitch);
    }

    public void disconnect(Light light) {
        for (LightSwitch lightSwitch : this.lightSwitches) lightSwitch.removeLight(light);
    }

    public void print() {
        for (Light light : this.lights) light.print();
        for (LightSwitch lightSwitch : this.lightSwitches) lightSwitch.print();
        System.out.println("\n");
    }

}
