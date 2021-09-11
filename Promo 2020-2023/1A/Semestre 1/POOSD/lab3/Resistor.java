package dipole;

public class Resistor implements Dipole {

    private double r;

    public Resistor(double r) {
        this.r = r;
    }

    public Complex impedance(double omega) {
        return new Complex(this.r, 0);
    }
}
