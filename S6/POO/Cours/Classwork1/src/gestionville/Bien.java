package gestionville;

public abstract class Bien {
    
    protected int valEuros, coutEntretienMensuel;
    protected static int nbExemplaires = 0;
        
    public Bien() {
        nbExemplaires++;
        valEuros = 0;
        coutEntretienMensuel = 0;
    }

    public Bien(int val, int entretien) {
        valEuros = val;
        coutEntretienMensuel = entretien;
        nbExemplaires++;
    }

    public int getValEuros() {
        return valEuros;
    }
    
    public void setValEuros(int v) {
        valEuros = v;
    }

    public int getCoutEntretienMensuel() {
        return coutEntretienMensuel;
    }

    public void setCoutEntretienMensuel(int c) {
        coutEntretienMensuel = c;
    }

    public static int getNbExemplaires() {
        return Bien.nbExemplaires;
    }

    public String getInfo() {

        return String.format("Valeur : %d$\nCout d'entretien mensuel : %d$", valEuros, coutEntretienMensuel);
    }
}
