package revision1;

public abstract class VehiculeMotorise extends Vehicule {
    private Etat etatTransmission = Etat.NEUF;
    private Etat etatMoteur = Etat.NEUF;

    public VehiculeMotorise(String nip) {
        super(nip);
    }

    public Etat getEtatTransmission() {
        return etatTransmission;
    }

    public void setEtatTransmission(Etat etatTransmission) {
        this.etatTransmission = etatTransmission;
    }

    public Etat getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(Etat etatMoteur) {
        this.etatMoteur = etatMoteur;
    }

    @Override
    public String repare() {
        String composanteRepare = "";

        if (getEtatMoteur() != Etat.NEUF && getEtatMoteur() != Etat.REPARE) {
            this.setEtatMoteur(Etat.REPARE);
            composanteRepare += " moteur";
        }

        if (getEtatTransmission() != Etat.NEUF && getEtatTransmission() != Etat.REPARE) {
            setEtatTransmission(Etat.REPARE);
            composanteRepare += " transmission";
        }

        return (composanteRepare);
    }
}
