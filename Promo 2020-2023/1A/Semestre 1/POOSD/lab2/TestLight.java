package iot;

public class TestLight {

    public static void main(String[] args) {

        Light light = new Light(false);
        light.print();
        light.turnOn();
        System.out.println("Lampe allumée.");
        light.print();
        light.turnOff();
        System.out.println("Lampe éteinte");
        light.print();
        light.turnOnOff();
        System.out.println("Etat inversé.");
        light.print();

    }

}
