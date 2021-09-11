package iot;

public class TestLightSwitch {

    public static void main(String[] args) {

        Light l1 = new Light();
        Light l2 = new Light();
        Light l3 = new Light();
        LightSwitch s1 = new LightSwitch();
        l1.turnOn();
        s1.bind(l1);
        s1.bind(l2);
        s1.bind(l3);
        System.out.println("Toutes allumées : " + s1.isLightsAllOn());
        s1.turnOff();
        System.out.println("Toutes allumées : " + s1.isLightsAllOn());
        s1.turnOn();
        System.out.println("Toutes allumées : " + s1.isLightsAllOn());
        s1.turnOnOff();
        System.out.println("Toutes allumées : " + s1.isLightsAllOn());

    }

}
