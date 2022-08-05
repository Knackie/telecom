package gestionville;

import java.util.ArrayList;

public class Ville {
    
    private ArrayList<Bien> tabBiens;

    public Ville() {
        tabBiens = new ArrayList<Bien>();
    }

    public void add(Bien bien) {
        tabBiens.add(bien);
    }

    public int getNbVehicules() {
        int nb = 0;

        for (Bien bien : tabBiens) {
            if(bien instanceof Vehicule)
                nb++;
        }

        return nb;
    }

    public int getEntretienCourantMensuel() {
        int entretien = 0;
            
        for(int i=0; i < tabBiens.size(); i++) {
            entretien += tabBiens.get(i).coutEntretienMensuel;
        }

        return entretien;
    }
        
    public int getNbPersonnesLogees() {
        int nb = 0;

        for (Bien bien : tabBiens) {
            if(bien instanceof Logement)
                nb += ((Logement) bien).getNbPersonnesLogees();
        }

        return nb;
    }

    public int getCoutEntretienVehicules() {
        int entretien = 0;

        for (Bien bien : tabBiens) {
            if(bien instanceof Vehicule)
                entretien += bien.coutEntretienMensuel;
        }

        return entretien;
    }

    public String getInfo(int indice) {
        
        return tabBiens.get(indice).getInfo();
    }

}   
