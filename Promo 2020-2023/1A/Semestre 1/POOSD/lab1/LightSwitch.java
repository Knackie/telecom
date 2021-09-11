package iot;

public class LightSwitch {

    private Light light;

    public LightSwitch() {
    }

    public LightSwitch(Light light) {
        this.light = light;
    }

    public Light getLight() {
        return light;
    }

    public void bind(Light light) {
        this.light = light;
    }

    public void turnOn() {
        this.light.switchOn();
    }

    public void turnOff() {
        this.light.switchOff();
    }

}
