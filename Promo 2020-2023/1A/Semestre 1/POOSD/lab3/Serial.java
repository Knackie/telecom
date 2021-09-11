package dipole;

public class Serial extends Binary {

    public Serial(Dipole d1, Dipole d2) {
        super(d1, d2);
    }

    public Complex impedance(double omega) {
        return this.d1.impedance(omega).add(this.d2.impedance(omega));
    }

}
