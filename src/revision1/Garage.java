package revision1;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Garage {
    private Vehicule[] stationnements;
    private Vehicule[] garages;

    private Map<LocalDateTime, String> historiqueDesReparation;

    /**
     * crée un Garage avec le nombre de place de stationnement demandé et toujours 2
     * places de garage pour les réparations.
     *
     * @param nombrePlacesStationnement le nombre de places requises.
     */
    public Garage(int nombrePlacesStationnement) {
        assert nombrePlacesStationnement > 0 : "valeur négative";
        garages = new Vehicule[2];
        stationnements = new Vehicule[nombrePlacesStationnement];
        historiqueDesReparation = new TreeMap<LocalDateTime, String>();
    }

    /**
     * Stationne l'auto dans le premier emplacement vide. La méthode
     * trouveIndexPlaceLibre peut aider à le faire.
     * La méthode stationnementEstPlein indique s'il y a une place disponible.
     *
     * @param auto l'auto à placer dans le stationnement
     * @return faux s'il n'y a plus de palce
     */
    public boolean stationne(Vehicule auto) {
        boolean estStationne = false;

        int indexPlaceLibre = trouveIndexPlaceLibre();

        if (indexPlaceLibre != -1) {
            stationnements[indexPlaceLibre] = auto;
            estStationne = true;
        }

        return estStationne;
    }

    /**
     * indique si le stationnement est plein
     *
     * @return vrai s'il est plein
     */
    private boolean stationnementEstPlein() {
        return trouveIndexPlaceLibre() == -1;
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre
     * avant d'appeler cette méthode
     *
     * @return l'indice de la place libre ou ArrayIndexOutOfBoundsException si le
     *         stationnement est plein
     */
    private int trouveIndexPlaceLibre() {
        int indexPlaceLibre = -1;

        for (int indexStationnement = 0; indexStationnement < stationnements.length
                && indexPlaceLibre == -1; indexStationnement++) {
            if (stationnements[indexStationnement] == null) {
                indexPlaceLibre = indexStationnement;
            }
        }

        return indexPlaceLibre;
    }

    /**
     * trouve la première place libre. On doit vérifier qu'il y a une place libre
     * avant d'appeler cette méthode
     *
     * @return l'indice de la place libre ou ArrayIndexOutOfBoundsException si le
     *         stationnement est plein
     */
    public int trouvePlace() {
        return trouveIndexPlaceLibre() + 1;
    }

    /**
     * entre le vehicule demandé dans le garage à la place demandé. On peut
     * retrouver la
     * place de stationnement d'un vehicule à l'aide de la méthode
     * chercheVehiculeStationnement.
     *
     * @param vehiculeRepare le vehicule à entrer (il doit être dans le
     *                       stationnement)
     * @param placeGarage    la place du garage (elle ne doit pas contenir de
     *                       vehicule)
     * @return vrai si le vehicule a pu être entré
     */
    public boolean entreVehiculeGarage(Vehicule vehiculeRepare, int placeGarage) {
        int indexGarage = placeGarage - 1;
        boolean estEntre = false;

        assert vehiculeRepare != null : "null Vehicule";
        assert indexGarage >= 0 : "place négative";
        assert indexGarage < garages.length : "place inexistante";

        int indexStationement = chercheVehiculeStationnement(vehiculeRepare);

        if (indexStationement != -1 && garages[indexGarage] == null) {
            garages[indexGarage] = stationnements[indexStationement];
            stationnements[indexStationement] = null; // libere le stationnement

            estEntre = true;
        }

        return estEntre;
    }

    /**
     * trouve le vehicule reçu en paramètre dans le stationnement et retourne son
     * index
     *
     * @param vehiculeRepare le véhicule à trouver (avec méthode equals)
     * @return l'index du vehicule ou -1 s'il n'a pas été trouvé
     */
    private int chercheVehiculeStationnement(Vehicule vehiculeRepare) {

        int indexPlaceStationnement = -1;

        assert vehiculeRepare != null : "parametre null";

        for (int indexStationnement = 0; indexStationnement < stationnements.length &&
                indexPlaceStationnement == -1; indexStationnement++) {
            if (vehiculeRepare.equals(stationnements[indexStationnement])) {
                indexPlaceStationnement = indexStationnement;
            }
        }

        return (indexPlaceStationnement);
    }

    /**
     * sort le vehicule du garage et le remet dans le stationnement.
     *
     * @param placeGarage       la place du garabe où prendre le vehicule à sortir (
     *                          il doit y avoir un vehicule à cette place)
     * @param placeStationement la place de stationnement où mettre le vehicule (le
     *                          stationnement doit être libre)
     * @return retourne vrai si le vehicule est sorti.
     */
    public boolean sortVehicule(int placeGarage, int placeStationement) {

        boolean estSortie = false;

        assert placeGarage > 0 : "place negative";
        assert placeStationement > 0 : "place negative";

        int indexStationement = placeStationement - 1;
        int indexGarage = placeGarage - 1;

        if (stationnements[indexStationement] == null && garages[indexGarage] != null) {
            stationnements[indexStationement] = garages[indexGarage]; // deplace dans le stationnement

            garages[indexGarage] = null; // libere le garage;

            estSortie = true;
        }

        return estSortie;
    }

    /**
     * gère le départ d'un véhicule en l'effacant du stationnement et en retournant
     * sa valeur
     *
     * @param auto le vehicule qui doit être retiré
     * @return le vehicule qui doit être retiré sii il est trouvé null autrement.
     */
    public Vehicule faitDepartVehicule(Vehicule auto) {
        Vehicule vehiculeParti = null;

        int indexStationement = chercheVehiculeStationnement(auto);

        if (indexStationement != -1) {
            vehiculeParti = stationnements[indexStationement];
            stationnements[indexStationement] = null;
        }

        return vehiculeParti;
    }

    /**
     * répare tous les dommages de tous les vehicules dans le garage en indiquant
     * l'état réparé.
     */
    public void repare() {
        Vehicule vehicule;
        for (int i = 0; i < garages.length; i++) {
            vehicule = garages[i];

            if (vehicule != null) {
                historiqueDesReparation.put(LocalDateTime.now(), "; " + vehicule.getNIP() + "-" + vehicule.repare());
            }
        }
    }

    public Map getHistory() {
        return(historiqueDesReparation);
    }
}
