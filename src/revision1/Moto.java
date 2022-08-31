package revision1;

public class Moto extends Vehicule {

    
    private Vehicule.Etat etatTransmission = Vehicule.Etat.NEUF;
    private Vehicule.Etat etatMoteur = Vehicule.Etat.NEUF;


    public Moto(String NIP) {
        super(NIP);
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public String repare() {
        String composanteRepare = "";
        
        if (getEtatMoteur() != Automobile.Etat.NEUF && getEtatMoteur() != Automobile.Etat.REPARE) {
            this.setEtatMoteur(Automobile.Etat.REPARE);
            composanteRepare += " moteur";
        }
        
        if (getEtatTransmission() != Automobile.Etat.NEUF && getEtatTransmission() != Automobile.Etat.REPARE) {
            setEtatTransmission(Automobile.Etat.REPARE);
            composanteRepare += " transmission";
        }

        return(composanteRepare);
    }

    public Automobile.Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Automobile.Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Automobile.Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Automobile.Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "NIP='" + getNIP() + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatMoteur=" + etatMoteur +
                '}';
    }
}
