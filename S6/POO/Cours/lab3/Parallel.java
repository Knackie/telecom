package dipole;

public class Parallel extends Binary {

    public Parallel(Dipole d1, Dipole d2) {
        super(d1, d2);
    }

    public Complex impedance(double omega) {
        return (this.d1.impedance(omega).inverse().add(this.d2.impedance(omega).inverse())).inverse();
    }

}
