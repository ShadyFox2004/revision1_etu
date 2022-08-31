package revision1;

public class Camion extends Vehicule{

    private Vehicule.Etat etatTransmission = Vehicule.Etat.NEUF;
    private Vehicule.Etat etatCarosserie = Vehicule.Etat.NEUF;
    private Vehicule.Etat etatMoteur = Vehicule.Etat.NEUF;

    private Vehicule.Etat etatEspaceCargaison = Vehicule.Etat.NEUF;

    public Camion(String NIP) {
        super(NIP);
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    @Override
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

        if (getEtatEspaceCargaison() != Etat.NEUF && getEtatEspaceCargaison() != Etat.REPARE) {
            setEtatEspaceCargaison(Etat.REPARE);
            composanteRepare += " espacesCargaison";
        }
        
        return(composanteRepare);
    }

    public Vehicule.Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Vehicule.Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Vehicule.Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Vehicule.Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }

    public Vehicule.Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Vehicule.Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    public Vehicule.Etat getEtatEspaceCargaison() {
        return etatEspaceCargaison;
    }

    public void setEtatEspaceCargaison(Vehicule.Etat etatEspaceCargaison) {
        this.etatEspaceCargaison = etatEspaceCargaison;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "NIP='" + getNIP() + '\'' +
                ", etatTransmission=" + etatTransmission +
                ", etatCarosserie=" + etatCarosserie +
                ", etatMoteur=" + etatMoteur +
                ", etatEspaceCargaison=" + etatEspaceCargaison +
                '}';
    }
}
