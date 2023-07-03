package iot;

public class TestHomeDashboard {

    public static void main(String[] args) {

        Light l1 = new Light(true);
        Light l2 = new Light(false);
        Light l3 = new Light(false);
        Light l4 = new Light(true);
        Light l5 = new Light(true);
        LightSwitch s1 = new LightSwitch();
        LightSwitch s2 = new LightSwitch();
        Room salon = new Room("Salon");
        Room chambre = new Room("Chambre");
        HomeDashboard homeDashboard = new HomeDashboard();

        s1.bind(l1);
        s1.bind(l2);
        s2.bind(l3);
        homeDashboard.bind(salon);
        homeDashboard.bind(chambre);
        homeDashboard.bind(s1);
        homeDashboard.bind(s2);
        homeDashboard.installLight(salon, l4);
        homeDashboard.installLight(salon, l5);
        homeDashboard.installLight(chambre, l1);
        homeDashboard.print();
        homeDashboard.turnOn(salon);
        homeDashboard.print();
        homeDashboard.turnOff(salon);
        homeDashboard.print();
        homeDashboard.disconnectLight(l1);
        homeDashboard.print();

    }

}
