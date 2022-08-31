package revision1;

public class Automobile extends Vehicule{

    private Etat etatTransmission = Etat.NEUF;
    private Etat etatCarosserie = Etat.NEUF;
    private Etat etatMoteur = Etat.NEUF;
    private Etat etatHabitacle = Etat.NEUF;

    public Automobile(String NIP) {
        super(NIP);
    }

    public Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }

    public Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "NIP='" + getNIP() + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatCarosserie=" + etatCarosserie +
                ", etatMoteur=" + etatMoteur +
                '}';
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public String repare() {
        String composanteRepare = "";
        if (getEtatCarosserie() != Etat.NEUF && getEtatCarosserie() != Etat.REPARE) {
            this.setEtatCarosserie(Etat.REPARE);
            composanteRepare += " carosserie";
        }

        if (getEtatMoteur() != Etat.NEUF && getEtatMoteur() != Etat.REPARE) {
            this.setEtatMoteur(Etat.REPARE);
            composanteRepare += " moteur";
        }
        
        if (getEtatTransmission() != Etat.NEUF && getEtatTransmission() != Etat.REPARE) {
            setEtatTransmission(Etat.REPARE);
            composanteRepare += " transmission";
        }

        /*
        if (getEtat() != Etat.NEUF && getEtatTransmission() != Etat.REPARE) {
            setEtatTransmission(Etat.REPARE);
            composanteRepare += " habitacle";
        }
        */

        return(composanteRepare);
    }
}