package revision1;

public class Camion extends Automobile{

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
        String composanteRepare = super.repare();

        if (getEtatEspaceCargaison() != Etat.NEUF && getEtatEspaceCargaison() != Etat.REPARE) {
            setEtatEspaceCargaison(Etat.REPARE);
            composanteRepare += " espacesCargaison";
        }
        
        return(composanteRepare);
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
                ", etatTransmission=" + getEtatTransmission() +
                ", etatCarosserie=" + getEtatCarosserie() +
                ", etatMoteur=" + getEtatMoteur() +
                ", etatEspaceCargaison=" + getEtatEspaceCargaison() +
                '}';
    }
}
