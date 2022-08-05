package dipole;

public class Coil implements Dipole {

    private double l;

    public Coil(double l) {
        this.l = l;
    }

    public Complex impedance(double omega) {
        return new Complex(0, omega * this.l);
    }
}
