package gestionville;

public class Vehicule extends Bien {
    
    private String numeroImmatriculation;
    private int nbPlaces;

    public Vehicule() {
        super();
        numeroImmatriculation = "";
        nbPlaces = 0;
    }

    public Vehicule(int val, int entretien, String plaque, int nb) {
        super(val, entretien);
        numeroImmatriculation = plaque;
        nbPlaces = nb;
    }

    public String getNumeroImmatriculation() {
        return numeroImmatriculation;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public String getInfo() {

        String res = String.format("--- Vehicule ---\nImmatriculation : %s\nNombre de places : %d\n", numeroImmatriculation, nbPlaces);
        return res + super.getInfo();
    }
}
