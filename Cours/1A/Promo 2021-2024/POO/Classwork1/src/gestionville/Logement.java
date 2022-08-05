package gestionville;

public class Logement extends Bien {
    
    private int superficieAuSol, nbPersonnesLogees;

    public Logement() {
        super();
        superficieAuSol = 0;
        nbPersonnesLogees = 0;
    }

    public Logement(int val, int entretien, int superficie, int nbPers) {
        super(val, entretien);
        superficieAuSol = superficie;
        nbPersonnesLogees = nbPers;
    }

    public int getSuperficieAuSol() {
        return superficieAuSol;
    }

    public int getNbPersonnesLogees() {
        return nbPersonnesLogees;
    }

    public String getInfo() {

        String res = String.format("--- Logement ---\nSuperficie au sol : %d\nNombre de personnes logees : %d\n", superficieAuSol, nbPersonnesLogees);
        return res + super.getInfo();
    }
}
