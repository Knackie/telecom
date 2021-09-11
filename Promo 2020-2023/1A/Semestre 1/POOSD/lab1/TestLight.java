package iot;

public class TestLight {

    public static void main(String[] args) {

        Light light = new Light(false);
        light.printState();
        light.switchOn();
        System.out.println("Lampe allumée.");
        light.printState();
        light.switchOff();
        System.out.println("Lampe éteinte");
        light.printState();
        light.inverseState();
        System.out.println("Etat inversé.");
        light.printState();

    }

}
