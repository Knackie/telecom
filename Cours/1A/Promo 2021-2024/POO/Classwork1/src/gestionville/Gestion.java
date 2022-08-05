package gestionville;

public class Gestion {
    
    public static void main(String[] args) {
        
        Ville ville = new Ville();
        Logement logement1 = new Logement(70000, 800, 50, 2);
        Logement logement2 = new Logement(100000, 1100, 80, 3);
        ville.add(logement1);
        ville.add(logement2);

        System.out.println(Bien.getNbExemplaires());
        System.out.println(ville.getCoutEntretienVehicules());
        System.out.println(ville.getEntretienCourantMensuel());
        System.out.println(ville.getNbPersonnesLogees());
        System.out.println(ville.getNbVehicules());
        System.out.println(ville.getInfo(1));

    }

}
