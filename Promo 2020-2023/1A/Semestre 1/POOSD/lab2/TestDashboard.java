package iot;

import java.lang.invoke.SwitchPoint;

public class TestDashboard {

    public static void main(String[] args) {
        Light l1 = new Light(true);
        Light l2 = new Light(false);
        Light l3 = new Light(false);
        Light l4 = new Light(true);
        LightSwitch s1 = new LightSwitch();
        LightSwitch s2 = new LightSwitch();
        Dashboard dashboard = new Dashboard();

        s1.bind(l1);
        s1.bind(l1);
        s1.bind(l2);
        s2.bind(l1);
        s2.bind(l3);
        dashboard.bind(s1);
        dashboard.bind(s2);
        dashboard.bind(l4);

        dashboard.print();
        dashboard.remove(s2);
        dashboard.print();
        dashboard.bind(s2);
        dashboard.disconnect(l1);
        dashboard.print();
    }

}
