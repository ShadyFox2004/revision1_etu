package revision1;

public class Automobile extends VehiculeMotorise {
    private Etat etatCarosserie = Etat.NEUF;
    private Etat etatHabitacle = Etat.NEUF;

    public Automobile(String NIP) {
        super(NIP);
    }

    public Etat getEtatCarosserie() {
        return etatCarosserie;
    }

    public void setEtatCarosserie(Etat etatCarosserie) {
        this.etatCarosserie = etatCarosserie;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "NIP='" + getNIP() + '\'' +
                ", etatTransmission=" + getEtatTransmission() +
                ", etatCarosserie=" + getEtatCarosserie() +
                ", etatMoteur=" + getEtatMoteur() +
                '}';
    }

    /**
     * répare tous les dommages du vehicule en indiquant l'état réparé.
     * Défi: essayez de gérer le cout des réparations.
     */
    public String repare() {
        String composanteRepare = super.repare();
        if (getEtatCarosserie() != Etat.NEUF && getEtatCarosserie() != Etat.REPARE) {
            this.setEtatCarosserie(Etat.REPARE);
            composanteRepare += " carosserie";
        }

        /*
         * if (getEtat() != Etat.NEUF && getEtatTransmission() != Etat.REPARE) {
         * setEtatTransmission(Etat.REPARE);
         * composanteRepare += " habitacle";
         * }
         */

        return (composanteRepare);
    }
}