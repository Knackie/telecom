package iot;

import java.util.ArrayList;

public class LightSwitch {

    private  boolean state;
    private ArrayList<Light> lights;

    public LightSwitch() {
        this.state = false;
        this.lights = new ArrayList<>();
    }

    public ArrayList<Light> getLights() { return lights; }

    public void setState(boolean state) {
        this.state = state;
    }

    public void bind(Light light) {
        if (!getLights().contains(light)) {
            if (this.state) light.turnOn();
            else light.turnOff();
            getLights().add(light);
        }
    }

    public void removeLight(Light light) { getLights().remove(light); }

    public void removeAll() { getLights().clear(); }

//    public void turnOn(Light light) {
//        int index = getLights().indexOf(light);
//        getLights().get(index).switchOn();
//    }
//
//    public void turnOff(Light light) {
//        int index = getLights().indexOf(light);
//        getLights().get(index).switchOff();
//    }

    public void turnOn() {
        setState(true);
        getLights().forEach(Light::turnOn);
    }

    public void turnOff() {
        setState(false);
        getLights().forEach(Light::turnOff);
    }

    public void turnOnOff() {
        setState(!this.state);
        getLights().forEach(Light::turnOnOff);
    }

    public boolean isLightsAllOn() {
        int i = 0;
        int size = getLights().size();
        while (i < size && getLights().get(i).isState()) {
            i++;
        }
        return i == size;
    }

    public void print() {
        System.out.println("Interrupteur et lampes rattachées :");
        if (this.state) System.out.println("Interrupteur activé");
        else System.out.println("Interrupteur désactivé");
        for (Light light : getLights()) {
            light.print();
        }
    }
}
