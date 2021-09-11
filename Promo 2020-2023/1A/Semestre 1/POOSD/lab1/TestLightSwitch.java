package iot;

public class TestLightSwitch {

    public static void main(String[] args) {

        Light light = new Light(false);
        LightSwitch lightSwitch = new LightSwitch(light);
        light.printState();
        lightSwitch.turnOn();
        System.out.println("Switch on.");
        light.printState();
        lightSwitch.turnOff();
        System.out.println("Switch off.");
        light.printState();

    }

}
