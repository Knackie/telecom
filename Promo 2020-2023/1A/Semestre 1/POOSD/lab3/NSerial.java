package dipole;

public class NSerial extends NAry {

    public NSerial() {
        super();
    }

    public Complex impedance(double omega) {
        Complex result = new Complex();
        for (Dipole dipole : this.dipoles) result.add(dipole.impedance(omega));
        return result;
    }
}
