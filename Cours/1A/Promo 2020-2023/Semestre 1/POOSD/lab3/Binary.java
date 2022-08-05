package dipole;

public abstract class Binary implements Dipole {

    protected Dipole d1;
    protected Dipole d2;

    public Binary(Dipole d1, Dipole d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    public abstract Complex impedance(double omega);

}