package dipole;

import java.util.List;
import java.util.ArrayList;

public abstract class NAry implements Dipole {

    protected List<Dipole> dipoles;

    public NAry() {
        this.dipoles = new ArrayList<Dipole>();
    }

    public void addDipole(Dipole d) {
        this.dipoles.add(d);
    }

    public abstract Complex impedance(double omega) ;

}