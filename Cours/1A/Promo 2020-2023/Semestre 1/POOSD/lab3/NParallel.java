package dipole;

public class NParallel extends NAry {

    public NParallel() {
        super();
    }

    public Complex impedance(double omega) {
        Complex result = new Complex();
        for (Dipole dipole : this.dipoles) result.add(dipole.impedance(omega).inverse());
        return result.inverse();
    }

}
