package revision1;

import java.io.IOException;
import java.util.Iterator;

public class Application {
    public static void main(String[] args) {
        Garage garage = new Garage(4);
        Automobile autoA = new Automobile("A");
        Automobile autoB = new Automobile("B");
        Automobile autoC = new Automobile("C");
        Automobile autoD = new Automobile("D");
        Moto motoA = new Moto("a");

        autoA.setEtatTransmission(Automobile.Etat.TRES_BRISE);
        autoA.setEtatMoteur(Automobile.Etat.BRISE);
        autoB.setEtatTransmission(Automobile.Etat.BRISE);
        autoC.setEtatCarosserie(Automobile.Etat.TRES_BRISE);
        autoD.setEtatMoteur(Automobile.Etat.BRISE);

        garage.stationne(autoA);
        garage.stationne(autoB);
        garage.stationne(autoC);
        garage.stationne(autoD);

        System.out.println("Les autos sont endommagés");
        System.out.println(autoA);
        System.out.println(autoB);
        System.out.println(autoC);
        System.out.println(autoD);
        // Réparation des autos A et B
        garage.entreVehiculeGarage(autoA, 1);
        garage.entreVehiculeGarage(autoB,2);

        try {
            garage.enregistreVehicules("garage.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        garage.repare();
        garage.sortVehicule(1,garage.trouvePlace());
        garage.sortVehicule(2,garage.trouvePlace());

        garage.faitDepartVehicule(autoA);
        garage.faitDepartVehicule(autoB);

        garage.stationne(motoA);

        System.out.println(autoA);
        System.out.println(autoB);

        // Réparation des autos C et D
        garage.entreVehiculeGarage(autoC, 1);
        garage.entreVehiculeGarage(autoD,2);

        

        garage.repare();
        garage.sortVehicule(1,garage.trouvePlace());
        garage.sortVehicule(2,garage.trouvePlace());

        garage.faitDepartVehicule(autoC);
        garage.faitDepartVehicule(autoD);

        System.out.println(autoC);
        System.out.println(autoD);

        Iterator i =  garage.getHistory().values().iterator();

        while(i.hasNext()) {
            System.out.println(i.next().toString());
        }
    }
}
