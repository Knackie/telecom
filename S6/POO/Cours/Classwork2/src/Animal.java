package src;
public class Animal {

    public Animal f(Animal z, Canard t) {
        Canard unCanard;
        if (!this.estUneSorteDe(z))
            return z;
        if (t.estUnCanard())
            return t;
        unCanard = new Canard();
        return unCanard;
    }

    public boolean estUneSorteDe(Animal x) {
        return !(x.estUnCanard());
    }

    public boolean estUnCanard() {
        return false;
    }
}
