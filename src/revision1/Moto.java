package revision1;

public class Moto extends VehiculeMotorise {
    public Moto(String NIP) {
        super(NIP);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "NIP='" + getNIP() + '\'' +
                ", etatTransmission=" + getEtatTransmission() +
                ", etatMoteur=" + getEtatMoteur() +
                '}';
    }
}
