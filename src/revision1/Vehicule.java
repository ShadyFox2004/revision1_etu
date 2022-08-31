package revision1;

import java.util.Objects;

public abstract class Vehicule {
    public enum Etat {TRES_BRISE, BRISE, REPARE, NEUF};

    private String NIP;

    public Vehicule(String nip) {
        this.NIP = nip;
    }

    public String getNIP() {
        return NIP;
    }

    abstract public String repare();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule that = (Vehicule) o;
        return Objects.equals(getNIP(), that.getNIP());
    }
}
