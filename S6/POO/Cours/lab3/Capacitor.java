package dipole;

public class Capacitor implements Dipole {

    private double c;

    public Capacitor(double c) {
        this.c = c;
    }

    public Complex impedance(double omega) {
        return new Complex(0, -1 / (omega * this.c));
    }
}
